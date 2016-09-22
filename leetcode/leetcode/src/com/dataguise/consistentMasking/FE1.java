package com.dataguise.consistentMasking;

/**
 * Created by shiyanghuang on 16/8/31.
 */
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

/**
 * Format Preserving Encryption using the scheme FE1 from the paper
 * "Format-Preserving Encryption" by Bellare, Rogaway, et al
 * (http://eprint.iacr.org/2009/251)
 * Ported from Botan Library Version 1.10.3 (http://botan.randombit.net)
 */
public class FE1
{
    /**
     * Generic Z_n FPE decryption, FD1 scheme
     *
     * @param modulus 		Use to determine the range of the numbers. Example, if the
     * numbers range from 0 to 999, use "1000" here
     * @param ciphertext	The number to decrypt.
     * @param key			Secret key
     * @param tweak			Non-secret parameter, think of it as an IV - use the same one used to encrypt
     * @return				The decrypted number
     * @throws Exception
     */
    public static BigInteger Decrypt(BigInteger modulus, BigInteger ciphertext,
                                     byte[] key,
                                     byte[] tweak) throws Exception
    {
        FPE_Encryptor F = new FPE_Encryptor(key, modulus, tweak);
        AB ab = new AB();
        NumberTheory.factor(modulus,  ab);

        int r = rounds(ab.a, ab.b);

        BigInteger X = ciphertext;

        for (int i = 0; i != r; ++i)
        {
            BigInteger W = X.mod(ab.a);
            BigInteger R = X.divide(ab.a);

            BigInteger bigInteger = W.subtract(F.F(r - i - 1, R));

            BigInteger L = bigInteger.mod(ab.a);
            X = ab.b.multiply(L).add(R);
        }

        return X;
    }

    /**
     * Generic Z_n FPE encryption, FE1 scheme
     *
     * @param modulus		Use to determine the range of the numbers. Example, if the
     * numbers range from 0 to 999, use "1000" here.
     * @param plaintext		The number to encrypt.
     * @param key			Secret key.
     * @param tweak			Non-secret parameter, think of it as an IV.
     * @return				The encrypted number.
     * @throws Exception
     */
    public static BigInteger Encrypt(BigInteger modulus, BigInteger plaintext,
                                     byte[] key,
                                     byte[] tweak) throws Exception
    {
        FPE_Encryptor F = new FPE_Encryptor(key, modulus, tweak);

        AB ab = new AB();
        NumberTheory.factor(modulus, ab);

        int r = rounds(ab.a, ab.b);


        BigInteger X = plaintext;

        for (int i = 0; i != r; ++i)
        {
            BigInteger L = X.divide(ab.b);
            BigInteger R = X.mod(ab.b);

            BigInteger W = (L.add(F.F(i, R))).mod(ab.a);
            X = ab.a.multiply(R).add(W);
        }

        return X;
    }


    public static BigInteger FPH(BigInteger modulus, BigInteger plaintext,
                                 byte[] key,
                                 byte[] tweak) throws Exception {
        FPE_Encryptor F = new FPE_Encryptor(key, modulus, tweak);
        AB factors = new AB();
        NumberTheory.factor(modulus, factors);
        int r = rounds(factors.a, factors.b);
        BigInteger X = plaintext;
        for (int i = 0; i != r; ++i) {
            BigInteger L = X.divide(factors.b);
            BigInteger R;
            if (i == r-1) {
                R = X.add(F.F(i, L)).mod(factors.b);
            }else{
                R = X.mod(factors.b);
            }
            BigInteger W = (L.add(F.F(i, R))).mod(factors.a);
            X = factors.a.multiply(R).add(W);
        }
        return X;
    }



    /**
     *  According to a paper by Rogaway, Bellare, etc, the min safe number
     *  of rounds to use for FPE is 2+log_a(b). If a >= b then log_a(b) &lt;= 1
     *  so 3 rounds is safe. The FPE factorization routine should always
     * return a >= b, so just confirm that and return 3.
     * @param a
     * @param b
     * @return
     * @throws Exception
     */
    private static int rounds(BigInteger a, BigInteger b) throws Exception
    {
        if (a.compareTo(b) < 0)
            throw new Exception("FPE rounds: a < b");
        return 7;
    }

}

/**
 * A simple round function based on HMAC(SHA-256)
 */
class FPE_Encryptor
{
    private int MAX_N_BYTES = 128 / 8;
    private Mac mac ;

    private byte[] mac_n_t;

    FPE_Encryptor(byte[] key,
                  BigInteger n,
                  byte[] tweak) throws Exception
    {
        SecretKeySpec keySpec = new SecretKeySpec(key, "HmacSHA256");
        mac = Mac.getInstance("HmacSHA256"); //System.Security.Cryptography.HMACSHA256(key);
        mac.init(keySpec);

        byte[] n_bin = Utility.encode(n); //.toByteArray(); //encode();

        if (n_bin.length > MAX_N_BYTES)
            throw new Exception("N is too large for FPE encryption");

        ByteArrayOutputStream ms = new ByteArrayOutputStream();

        Utility.update_be(ms,n_bin.length);
        Utility.update(ms,n_bin);

        Utility.update_be(ms,tweak.length);
        Utility.update(ms,tweak);
        mac_n_t = mac.doFinal(ms.toByteArray());

        Utility.shuffle(mac_n_t);
    }

    BigInteger F(int round_no, BigInteger R)
    {
        byte[] r_bin = Utility.skipZero(R.toByteArray());
        ByteArrayOutputStream ms = new ByteArrayOutputStream();
        Utility.update(ms,mac_n_t);
        Utility.update_be(ms,round_no);

        Utility.update_be(ms,r_bin.length);
        Utility.update(ms,r_bin);
        byte[] X = Utility.reverse(mac.doFinal(ms.toByteArray()));// ToArray()).Reverse().ToArray();
        Utility.shuffle(X);
        byte[] X_ = new byte[X.length + 1];
        Utility.copyArray(X , X_); //X_ = X.clone(); //X.CopyTo(X_, 0);
        X_[X.length] = 0; // guarantee a positive interpretation
        BigInteger ret = new BigInteger(Utility.reverse(X_));
        return ret;
    }

}
