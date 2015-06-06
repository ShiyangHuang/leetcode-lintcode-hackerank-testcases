package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/5.
 */
public class replaceBlank {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < length; i++ ) {
            if (string[i] == ' ') {
                count++;
            }
        }
        int ans = count;
        length -= 1;
        int newl = length + count * 2;
        while (length >= 0) {
            if (string[length] == ' ') {
                string[newl--] = '0';
                string[newl--] = '2';
                string[newl--] = '%';
            } else {
                string[newl--] = string[length];
            }
            length--;
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] c = new char[100];
        String s = "helloworld";
        for (int i = 0; i < s.length(); i++ ) {
            c[i] = s.charAt(i);
        }
        System.out.println(new replaceBlank().replaceBlank(c, s.length()));
        System.out.println(c);
    }
}
