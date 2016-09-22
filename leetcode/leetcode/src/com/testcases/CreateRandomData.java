package com.testcases;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by shiyanghuang on 16/1/5.
 */
public class CreateRandomData {
    private static String CTRL_A = "\u0001";
    private static String CTRL_C = "\u0003";
    private static String CTRL_G = "\u0007";
    private static String TAB = "\t";
    private static String ENTER = "\n";
    private static String COMMER = ",";

    private String createCCN(String connecter) {
        StringBuilder sb = new StringBuilder();
        sb.append("5173");
        for (int i = 0; i < 12; i++) {
            if (i % 4 == 0) {
                sb.append(connecter);
            }
            sb.append((int)(Math.random()*10));
        }
        return sb.toString();
    }

    private String createSSN(String connecter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append((int)(Math.random()*10));
            if (i == 2 || i == 4) {
                sb.append(connecter);
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public void createData() throws IOException{
        FileWriter fw = new FileWriter("/Users/shiyanghuang/Documents/randomData.txt",false);
        /**
         * 调用该对象的write方法，向文件写入字符。
         *
         * 其实写入到了临时存储缓冲区中
         */
        for (int i = 0; i < 100; i++) {
            int c1 = (int)(Math.random()*10);
            for (int j = 0; j < c1; j++) {
                createCCN("");
            }
            fw.write("");
        }

        /**
         * 进行刷新，将字符写到目的地中。
         */
		//fw.flush();
        /**
         * 关闭流，关闭资源。在关闭前会调用flush方法 刷新缓冲区。关闭后在写的话，会抛IOException
         */
        fw.close();
    }

    public static void main(String[] args) {
        CreateRandomData crd = new CreateRandomData();




    }
}
