package com.dataguess.Masking;

import java.util.ArrayList;

/**
 * Created by shiyanghuang on 16/9/27.
 */
public class randName {
    String charString = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    public String getMaskedName(String stringToMask) {
        ArrayList<String> spliter = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<String>();

        int l = 0;
        StringBuilder sbname = new StringBuilder();
        StringBuilder sbspliter = new StringBuilder();

        int flag = 0;
        StringBuilder formatsb = new StringBuilder();
        while (l < stringToMask.length()) {
            if (charString.contains(stringToMask.charAt(l) + "")) {
                sbname.append(stringToMask.charAt(l++));
                if (flag == 2) {
                    spliter.add(sbspliter.toString());
                    sbspliter = new StringBuilder();
                    formatsb.append("s");
                }
                flag = 1;   // char in charString
            } else {
                sbspliter.append(stringToMask.charAt(l++));
                if (flag == 1) {
                    names.add(sbname.toString());
                    sbname = new StringBuilder();
                    formatsb.append("n");
                }
                flag = 2;	// char not in charString
            }
        }
        if (sbname.length() > 0) {
            names.add(sbname.toString());
            formatsb.append("n");
        }
        if (sbspliter.length() > 0) {
            spliter.add(sbspliter.toString());
            formatsb.append("s");
        }

        String format = formatsb.toString();

        StringBuilder sb = new StringBuilder();
        int tn = 0;
        int ts = 0;

        System.out.println(names);
        System.out.println(spliter);

        for (int i = 0; i < format.length(); i++) {
            if ("n".equals(format.charAt(i) + "")) {
                if (tn != names.size() - 1) {
                    sb.append(getMaskedFirstName(names.get(tn++)));
                } else {
                    sb.append(getMaskedLastName(names.get(tn++)));
                }
            } else {
                sb.append(spliter.get(ts++));
            }
        }

        return sb.toString();
    }

    public String getMaskedFirstName(String name) {
        return "|" + name + "|";
    }

    public String getMaskedLastName(String name) {
        return "|" + name + "|";
    }

    public static void main(String[] args) {
        String input = " John ;s, Zeng ";
        System.out.print(new randName().getMaskedName(input));
    }
}
