package com.testcases;

import java.io.*;

/**
 * Created by shiyanghuang on 16/9/2.
 */
public class FileReaderTest {
    public static void main(String[] args) {
        /**
         * 创建读取字符数据的流对象。
         * 读取路径不正确时会抛 IOException
         * 用以个读取流对象关联一个已存在文件。
         */
        try {
            String file = "/Users/shiyanghuang/Documents/Dataguise/us_postal_codes.csv";
            FileWriter fw = null;
            String line = "";
            fw = new FileWriter("/Users/shiyanghuang/Documents/Dataguise/us_postal_codes_col.txt", true);

            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) { // while loop begins here
                String[] col = line.split(",");

                System.out.println("{\"" + col[0] + "\",\"" + col[1] + "\",\"" + col[2] + "\"},");
                fw.write("{\"" + col[0] + "\",\"" + col[1] + "\",\"" + col[2] + "\"},\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
