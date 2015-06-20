package com.leetcode;

/**
 * Created by shiyanghuang on 15/6/19.
 */
public class isMatch {
    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            while ((s.length() > 0 && p.charAt(0) == '.') || ((s.length() > 0) && (s.charAt(0) == p.charAt(0)))) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        } else if ((s.length() != 0 && p.charAt(0) == '.') || ((s.length() > 0) && (s.charAt(0) == p.charAt(0)))) {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        if (s.equals("")) {
            return true;
        }
        if (p.equals("")) {
            return false;
        }
        if (p.length() > s.length()) {
            return false;
        }
        boolean[][] map = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= p.length(); i++) {
            //a=="", b==b.substring(0,i+1)
            map[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            //b =="", a==a.substring
            map[i][0] = false;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    map[i][j] = map[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        map[i][j] = map[i - 1][j];
                    } else {
                        map[i][j] = map[i][j - 1];
                    }
                } else if (s.charAt(i - 1) != p.charAt(j - 1)){
                    map[i][j] = map[i][j - 1];
                }
            }
        }
        return map[s.length()][p.length()];
    }
//    bool isMatch(const char *s, const char *p) {
//        if(s==NULL||p==NULL) return false;
//        if(*p=='\0') return *s=='\0';
//
//        if(*(p+1) == '*')
//        {
//            while((*s!='\0'&&*p=='.')||*s==*p)
//            {
//                if(isMatch(s,p+2)) return true;
//                s++;
//            }
//            return isMatch(s,p+2);
//        }
//        else if((*s!='\0'&&*p=='.')||*s==*p)
//        {
//            return isMatch(s+1,p+1);
//        }
//        return false;
//    }

    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";
        System.out.print(new isMatch().isMatch(s,p));
    }
}
