package com.testcases;


import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * Created by shiyanghuang on 16/11/17.
 */
public class GuavaTest {
    public static void main(String[] args) {
        String str = "asdf";
        HashFunction hashFunction = Hashing.sha1();
        HashCode hashCode = hashFunction.newHasher().putString(str, Charset.defaultCharset()).hash();
        System.out.println(hashCode);
    }
}
