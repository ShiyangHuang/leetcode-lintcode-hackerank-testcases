package com.lintcode;

/**
 * Created by shiyanghuang on 15/6/12.
 */
public class hashCode {
    public int hashCode2(char[] key,int HASH_SIZE) {
        // write your code here
        int hash = 0;
        long hashKey = 1;
        for (int i = key.length - 1; i >= 0; i--) {
            hash += (hashKey * (int)key[i]) % HASH_SIZE;
            System.out.println(hash);
            hash %= HASH_SIZE;
            hashKey *= 33;
            hashKey %= HASH_SIZE;
        }
        return hash;
    }
    public int hashCode(char[] key,int HASH_SIZE) {
                if (key.length==0) return 0;
                int res = 0;
                 int base = 1;
                 for (int i=key.length-1;i>=0;i--){
                         res += modMultiply((int)key[i],base,HASH_SIZE);;
                         res %= HASH_SIZE;
                         System.out.println(res);
                         base = modMultiply(base,33,HASH_SIZE);
                     }
                 return res;
             }

                 public int modMultiply(long a, long b, int HASH_SIZE){
                 long temp = a*b%HASH_SIZE;
                 return (int) temp;
             }
    public static void main(String[] args) {
        String s = "Wrong answer or accepted?";
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
        }
        int n = 1000000007;
        System.out.print(new hashCode().hashCode(c,n));
    }
}
