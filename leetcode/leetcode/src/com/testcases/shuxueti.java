package com.testcases;

/**
 * Created by shiyanghuang on 16/9/21.
 */
public class shuxueti {
    int[] num = {1,2,3,4,5,6,7,8,9};
    boolean[] f = new boolean[9];

    int a,b,c,d,e;
    int[] s = {1,2,3,4,5,6,7,8,9};
    private void gen(int n) {
        if (n >= 9) {
            a = s[0] * 10 + s[1];
            b = s[2];
            c = s[3] * 10 + s[4];
            d = s[5] * 10 + s[6];
            e = s[7] * 10 + s[8];
            if (varify()) {
                System.out.println("a = " + a);
                System.out.println("b = " + b);
                System.out.println("c = " + c);
                System.out.println("d = " + d);
                System.out.println("e = " + e);
            } else {
                //System.out.println(a + " " + b + " " + c + " " + d + " " + e + " is not correct");
            }
        }

        else {
            for (int i = 0; i < 9; i++) {
                if (!f[i]) {
                    f[i] = true;
                    s[n] = num[i];
                    gen(n + 1);
                    f[i] = false;
                }
            }
        }
    }

    private boolean varify() {
        return (a * b == c) && (c + d == e);
    }

    public static void main(String[] args) {

        new shuxueti().gen(0);
    }
}
