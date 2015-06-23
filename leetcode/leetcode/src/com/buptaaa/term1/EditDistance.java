package com.buptaaa.term1;

/**
 * Created by shiyanghuang on 15/6/21.
 */
public class EditDistance {
    public int EditDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if(word1.isEmpty())
            return l2;
        if(word2.isEmpty())
            return l1;
        int[][] dp = new int[l1+1][l2+1];
        //Base condition
        for(int i =0; i<=l1; i++)
            dp[i][0] = i;
        for(int j=1; j<=l2; j++)
            dp[0][j] = j;
        for(int i=1; i<=l1 ; i++)
        {
            for(int j=1; j<=l2; j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min( Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + 1);
            }
        }
        System.out.print("    ");
        for (int i = 0; i < l2; i++) {
            System.out.print(word2.charAt(i) + " ");
        }
        System.out.println();
        for (int i = 0; i <= l1; i++) {
            if (i >= 1) {
                System.out.print(word1.charAt(i - 1) + " ");
            } else {
                System.out.print("  ");
            }

            for (int j = 0; j <= l2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().EditDistance("asdf", "qwddfrr"));
    }
}
