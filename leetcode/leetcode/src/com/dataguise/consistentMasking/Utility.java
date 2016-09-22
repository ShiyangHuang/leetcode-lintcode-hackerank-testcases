package com.dataguise.consistentMasking;

/**
 * Created by shiyanghuang on 16/8/31.
 */
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.Random;

public class Utility
{
    static byte[] encode(BigInteger n)
    {
        if (n.compareTo(BigInteger.ZERO)==0) return new byte[0];
        else return  skipZero(n.toByteArray());
    }

    static void copyArray(byte[] sourceArray,byte[] targetArray)
    {
        for(int i = 0; i < sourceArray.length && i < targetArray.length ; i++)
        {

            targetArray[i] = sourceArray[i];

        }

    }

    static byte[] skipZero(byte[] arr)
    {
        int zeroCount = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 0 ) zeroCount++;
        }

        byte[] retArr = new byte[arr.length - zeroCount];
        int j = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if  (arr[i] != 0 )
            {
                retArr[j++] =  arr[i];
            }
        }
        return retArr;
    }


    static byte[] reverse(byte[] arr) {
        for(int i = 0; i < arr.length/2; i++)
        {
            byte temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    static BigInteger mod(BigInteger n, BigInteger op)
    {
        BigInteger x = n.mod(op); //n % op
        if (x.signum() >= 0) return x;
        else return op.add(x);
    }

    static void Swap(BigInteger[] ab)
    {
        BigInteger tmp = ab[0];
        ab[0] = ab[1];
        ab[1] = tmp;
    }

    static void Swap(AB ab)
    {
        BigInteger tmp = ab.a;
        ab.a = ab.b;
        ab.b = tmp;
    }

    static void update( ByteArrayOutputStream  mac, byte[] num)
    {
        mac.write(num, 0, num.length);
    }

    static void update_be(ByteArrayOutputStream mac, int num)
    {
        String bytes = String.format("%04d", num);

        for (int i = 0; i <= 3; i++)
        {
            byte b = Byte.parseByte(bytes.substring(i, i+1));
            mac.write(b);
        }
    }

    public static void shuffle (byte[] array)
    {
        Random rng = new Random(2);
        int n = array.length;
        while (n > 1)
        {
            n--;
            int k = rng.nextInt(n + 1);
            byte tmp = array[k];
            array[k] = array[n];
            array[n] = tmp;
        }
    }


    public static int CharTypeStartNo(String charType)
    {
        int ct = 0;
        if (charType.equalsIgnoreCase("C"))
        {
            ct = 65;
        }else if (charType.equalsIgnoreCase("S"))
        {
            ct = 97;
        }
        return ct;
    }
}
