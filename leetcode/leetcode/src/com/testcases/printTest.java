package com.testcases;

/**
 * Created by shiyanghuang on 16/8/28.
 */
public class printTest {
    public static void main(String[] args) {
        String str = "<a href=\"http://huangshiyang.com/vr/examples/vr.php?id=house/R0010";
        String str2 = "\">";
        for (int i = 125; i < 207; i++) {
            System.out.println(str + i + str2 + i + "</a>");
        }
    }
}
