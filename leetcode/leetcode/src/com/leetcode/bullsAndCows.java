package com.leetcode;

/**
 * Created by shiyanghuang on 15/11/5.
 */
public class bullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secrets = new int[10];
        int[] guesses = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                cows++;
            } else {
                secrets[secret.charAt(i) - '0']++;
                guesses[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            bulls += Math.min(secrets[i],guesses[i]);
        }

        return cows + "A" + bulls + "B";
    }

    public static void main(String[] args) {
        System.out.print(new bullsAndCows().getHint("1123","0114"));
    }
}
