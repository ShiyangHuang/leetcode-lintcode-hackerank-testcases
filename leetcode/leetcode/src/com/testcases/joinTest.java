package com.testcases;

import org.apache.commons.lang.StringUtils;

/**
 * Created by shiyanghuang on 16/10/5.
 */
public class joinTest {
    public static void main(String[] args) {
        String[] s = new String[]{"a","b","c","d"};
        String ss = StringUtils.join(s, ",");
        System.out.print(ss);
    }
}
