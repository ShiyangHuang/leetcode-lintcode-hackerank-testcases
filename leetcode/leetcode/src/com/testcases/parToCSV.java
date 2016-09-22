package com.testcases;

/**
 * Created by shiyanghuang on 15/12/16.
 */
public class parToCSV {

    private static String[] converseParquetToStringArrayComplex(String value) {

        String line = value;

        String[] lineTokens = line.split("\n");

        for (String str : lineTokens) {
            System.out.println(str);
        }
        StringBuilder csv = new StringBuilder();

        int linenum = 0;
        StringBuilder subcsv = new StringBuilder();

        while (linenum < lineTokens.length) {
            if (lineTokens[linenum] != null && lineTokens[linenum] != "") {
                if (lineTokens[linenum].charAt(0) == ' ') {
                    String[] tokens = lineTokens[linenum].split(": ");
                    if (tokens != null && tokens.length >= 2) {
                        System.out.println("Token data: " + tokens[1]);
                        subcsv.append(tokens[1]);
                        subcsv.append(";");
                    }
                } else {
                    if (subcsv.length() != 0) {
                        subcsv.setLength(subcsv.length() - 1);
                        csv.append(subcsv);
                        csv.append(",");
                        subcsv = new StringBuilder();
                    }
                    String[] tokens = lineTokens[linenum].split(": ");
                    if (tokens != null && tokens.length >= 2) {
                        System.out.println("Token data: " + tokens[1]);
                        subcsv.append(tokens[1]);
                        subcsv.append(";");
                    }
                }
            }
            linenum++;
        }
        if (subcsv.length() != 0) {
            subcsv.setLength(subcsv.length() - 1);
            csv.append(subcsv);
            csv.append(",");
            subcsv = null;
        }

        csv.setLength(csv.length() - 1);
        System.out.println("csv: " + csv.toString());
        return csv.toString().split(",");
    }

    public static void main(String[] args) {
        String value =
                "c1\n" +
                "  bag\n" +
                "    array_element: Apple\n" +
                "  bag\n" +
                "    array_element: Grapes\n" +
                "  bag\n" +
                "    array_element: Orange\n" +
                "c2\n" +
                "  name: John\n" +
                "  score: 150\n" +
                "c3\n" +
                "  map\n" +
                "    key: cc\n" +
                "    value: 367191234\n" +
                "  map\n" +
                "    key: CC\n" +
                "    value: 4123123412341234\n" +
                "c4: French is my 1st language. I like it\n";

        String[] result = converseParquetToStringArrayComplex(value);
        for (String str : result) {
            System.out.println(str);
        }

    }
}
