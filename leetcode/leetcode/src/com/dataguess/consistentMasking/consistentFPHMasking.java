package com.dataguess.consistentMasking;

import com.dataguise.util.Base26;

import java.math.BigInteger;

/**
 * Created by shiyanghuang on 16/8/31.
 */
public class consistentFPHMasking {
    public String encChar2(String input, String tweakNumber, String key, String tweak) throws Exception{
        String maskedString="";
        int sizeToMaskStart = 15;
        int sizeToMaskMax = 20;
        int beginIndex = 0;
        int endIndex = 0;
        int sizeToMask =input.length();
        int pendingLength = input.length();

        if (pendingLength>sizeToMaskMax)
        {
            sizeToMask = sizeToMaskStart;

        }

        while(pendingLength>0)
        {
            if (pendingLength>sizeToMaskMax && pendingLength <  2 * sizeToMaskMax)
            {
                sizeToMask = pendingLength / 2 + 1;

            }

            endIndex = endIndex + sizeToMask;

            if(endIndex>input.length())
            {
                endIndex = input.length();
            }

            String strToMask = input.substring(beginIndex, endIndex);
            maskedString = maskedString + encCharStringParts(strToMask,tweakNumber,key,tweak);

            beginIndex = beginIndex +  sizeToMask;
            pendingLength = pendingLength - sizeToMask;

            if (sizeToMask == sizeToMaskMax)
            {
                sizeToMask = sizeToMaskStart;
            }else
            {
                sizeToMask = sizeToMask + 1;
            }
        }
        return maskedString;
    }

    private String encCharStringParts(String charStr, String tweakNumber, String key, String tweak) throws Exception{
        String encString = "";
        if (!charStr.isEmpty())
        {
            String _tweek = tweak;
            String As =repeatString("A", charStr.length());
            String Zs =repeatString("Z", charStr.length());

            BigInteger a = new BigInteger(Base26.CharToNum(As));
            BigInteger z = new BigInteger(Base26.CharToNum(Zs));
            BigInteger input = new BigInteger(Base26.CharToNum(charStr));

            if(!tweakNumber.isEmpty())
            {
                input = input.add(new BigInteger(tweakNumber));
            }

            BigInteger encVal = FE1.FPH(z.subtract(a).add(BigInteger.valueOf(1)), input, key.getBytes(), _tweek.getBytes());
            encVal = encVal.add(a);

            encString = Base26.NumToChar(encVal.toString());
        }
        return encString;
    }

    private String repeatString(String s, int n){
        String retStr="";
        for (int i = 0; i<n; i++)
        {
            retStr = retStr + s;
        }
        return retStr;
    }

    public static void main(String[] args) {
        // sets: {nums=, chars=Fremont, format=CSSSSSS, tweak=CSSSSSS, oChars=}
        // sets: {nums=, chars=CA, format=CC, tweak=CC, oChars=}
        // sets: {nums=2201, chars=WalnutAvenue, format=NNNN CSSSSS CSSSSS, tweak=NNNNCSSSSSCSSSSS, oChars=  }
        // sets: {nums=, chars=JohnZeng, format=CSSS CSSS, tweak=CSSSCSSS, oChars= }
        // sets: {nums=94538, chars=, format=NNNNN, tweak=NNNNN, oChars=}
        // Vbyg Ccem,7846 Luumlf Fpvliz, Majanng, NG, 84912

        String chars = "Fremont";
        String nums = "";
        String tweak = "CSSSSSS";
        String output = "";
        try {
            output = new consistentFPHMasking().encChar2(chars, nums, "asdf", tweak);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(chars);
        System.out.println(output);
    }
}

