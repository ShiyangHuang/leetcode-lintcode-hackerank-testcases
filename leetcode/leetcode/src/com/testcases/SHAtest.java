package com.testcases;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * Created by shiyanghuang on 17/1/3.
 */
public class SHAtest {
    public static void main(String[] args) {
        HashFunction hashFunction = Hashing.sha1();

        // HashCode s1 = hashFunction.newHasher().putString("asdf").hash();  //87814298d79654da7920c1f145f14bf5012ae2f3
        HashCode s2 = hashFunction.newHasher().putUnencodedChars("asdf").hash();
        HashCode s3 = hashFunction.newHasher().putString("asdf", Charset.defaultCharset()).hash();
        System.out.println(putString("asdf"));
        // System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }

    public static String putString(CharSequence charSequence) {
        Hasher hasher = Hashing.sha1().newHasher();
        for (int i = 0; i < charSequence.length(); i++) {
            hasher.putChar(charSequence.charAt(i));
        }
        return hasher.hash().toString();
    }
}
