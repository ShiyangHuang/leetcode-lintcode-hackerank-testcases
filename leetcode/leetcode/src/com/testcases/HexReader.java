package com.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shiyanghuang on 16/5/11.
 */
public class HexReader {

    public static String readHex(String inputPath) throws IOException {
        InputStream is = new FileInputStream(inputPath);
        byte[] buff = new byte[1024];
        int len;
        StringBuffer sb = new StringBuffer();
        while((len = is.read(buff)) != -1){
            for(int i = 0 ; i < len ; i++){
                byte b = (byte)(Integer.parseInt(new String(new byte[]{(byte)buff[i],(byte)buff[++i]}),16) & 0xff);
                sb.append(b);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "/Users/shiyanghuang/Documents/Dataguise/edi/SECO/ansi5020.dct";
        try {
            System.out.print(readHex(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
