package com.dataguess;

import java.io.*;

/**
 * Created by shiyanghuang on 16/9/26.
 */
public class bug11582FileGenerator {
        public static void main(String[] args) {
            /**
             * 创建读取字符数据的流对象。
             * 读取路径不正确时会抛 IOException
             * 用以个读取流对象关联一个已存在文件。
             */
            try {
                String file = "/Users/shiyanghuang/Documents/Dataguise/bug11582/sample_modified.txt";
                FileWriter fw = null;
                String line = "";
                fw = new FileWriter("/Users/shiyanghuang/Documents/Dataguise/bug11582/3GrandomData_Amex.txt", true);
                int r = 0;
                BufferedReader br = new BufferedReader(new FileReader(file));
                int count = 0;
                String spliter = "\u0001\u0005\u0001";
                line = br.readLine();
                int t = 0;
                while (t < 600000) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                            sb.append(randomDigit());
                        } else {
                            sb.append(line.charAt(i));
                        }
                    }
                    fw.write(sb.toString() + "\n");
                    t++;
                    if (t % 10000 == 0) {
                        System.out.println(t);
                    }
                }

//
//                System.out.println(line);
//                System.out.println(sb.toString());


//            while ((line = br.readLine()) != null) { // while loop begins here
//                String[] col = line.split(",");
//
//                System.out.println("{\"" + col[0] + "\",\"" + col[1] + "\",\"" + col[2] + "\"},");
//                // fw.write("{\"" + col[0] + "\",\"" + col[1] + "\",\"" + col[2] + "\"},\n");
//            }

                // System.out.println("column" + count / 2);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

    private static String randomnum(String column) {
        int num = (int) (Math.random() * (Math.pow(10, column.length())));
        while ((num + "").length() != column.length()) {
            num = (int) (Math.random() * (Math.pow(10, column.length())));
        }
        return num + "";
    }

    private static int randomDigit() {
        return (int) (Math.random() * 10 % 10);
    }
}
