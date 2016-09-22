package com.testcases;

/**
 * Created by shiyanghuang on 16/5/11.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

/**
 * RO Utility Mainly used for: 1.Double Open client 2.Open Unlimited View
 *
 * @author Ciro Deng(cdtdx@sohu.com)
 * @version 1.0
 *
 */
public class HexTool {
    private final String RO_HOME = "/Users/shiyanghuang/Documents/Dataguise/edi/SECO/"; //修改文件的路径
    private final String FILE = "ansi5020"; //修改文件的主文件名
    private final String BAK_FILE = FILE + "_BAK.sp2"; //修改文件的备份扩展名
    private final String PATCH_FILE = FILE + ".dct.mod"; //修改文件的扩展名
    /**
     * 进行16进制替换的规则定义
     * Pattern Array Example: pattern[0][0] = "Original Hex String"; 原16进制字符串
     * pattern[0][1] = "New Hex String"; 要替换的16进制字符串
     */
    private final String[][] pattern = {
            { "85C074095F5E33C05B8BE55DC3", "85C0EB095F5E33C05B8BE55DC3" },
            { "85C0740E5F5EB801000000", "85C0EB0E5F5EB801000000" }, // Double
// Open
            { "000066430000C843", "0000004300008644" } // Umlimited View
    };
    /**
     * 备份文件恢复
     * ture the backup file into real file
     *
     */
    public void restore() {
        if (isExistBackup()) {
            new File(RO_HOME + PATCH_FILE).delete();
            new File(RO_HOME + BAK_FILE)
                    .renameTo(new File(RO_HOME + PATCH_FILE));
            System.out.println("[----------------Restore file OK!--------------------]");
        } else {
            System.out.println("Backup file does not exist!");
            System.exit(0);
        }
    }
    public void init() { //初始化操作
        if (new File(RO_HOME + PATCH_FILE).exists()) {
            System.out
                    .println("[-------------Initialize original file OK!-----------]");
        } else {
            System.out.println("File is not Existed! Please restore it first!");
        }
// backup original file
        if (!isExistBackup()) {
            new File(RO_HOME + PATCH_FILE)
                    .renameTo(new File(RO_HOME + BAK_FILE));
        }
        System.out
                .println("[---------------Please choose your action------------]");
        System.out.println("1:Modify double open and unlimited view mode!");
        System.out.println("2:Restore original mode!");
        System.out.println("Please input 1 or 2 and Enter:");
    }
    public void success() { //成功操作提示
        System.out.println();
        System.out
                .println("[-------------Patch file OK! Have fun with RO!-------]");
    }
    /**
     * 进行16进制替换
     * replace input Hex String with defined pattern
     *
     * @param original
     * @return
     */
    public String replace(String original) {
        for (int i = 0; i < pattern.length; i++) {
            original = original.replaceAll(pattern[i][0].toLowerCase(),
                    pattern[i][1].toLowerCase());
        }
        return original;
    }
    /**
     * 将文件读取为16进制String
     * Read original File and transfer it into Hex String
     *
     * @return
     * @throws IOException
     */
    public String readOriginal2Hex() throws IOException {
        FileInputStream fin = new FileInputStream(new File(RO_HOME + BAK_FILE));
        StringWriter sw = new StringWriter();
        int len = 1;
        byte[] temp = new byte[len];
/*16进制转化模块*/
        for (; (fin.read(temp, 0, len)) != -1;) {
            if (temp[0] > 0xf && temp[0] <= 0xff) {
                sw.write(Integer.toHexString(temp[0]));
            } else if (temp[0] >= 0x0 && temp[0] <= 0xf) {//对于只有1位的16进制数前边补“0”
                sw.write("0" + Integer.toHexString(temp[0]));
            } else { //对于int<0的位转化为16进制的特殊处理，因为Java没有Unsigned int，所以这个int可能为负数
                sw.write(Integer.toHexString(temp[0]).substring(6));
            }
        }
        return sw.toString();
    }
    /**
     * 将替换后的16进制字符串写回文件
     * write replaced original String to file
     *
     * @param replaced
     * @throws NumberFormatException
     * @throws IOException
     */
    public void writeNew2Binary(String replaced) throws NumberFormatException,
            IOException {
        FileOutputStream fout = new FileOutputStream(RO_HOME + PATCH_FILE);
        for (int i = 0; i < replaced.length(); i = i + 2) {
            fout.write(Integer.parseInt(replaced.substring(i, i + 2), 16));
        }
    }
    /**
     * test direct output string to file
     *
     * @param temp
     * @throws IOException
     */
    public void writeTest(String temp) throws IOException {
        FileOutputStream fout = new FileOutputStream(RO_HOME + "test.txt");
        for (int i = 0; i < temp.length(); i++) {
            fout.write(temp.charAt(i));
        }
    }
    /**
     * check if the backup file exists
     *
     * @return
     */
    public boolean isExistBackup() {
        return new File(RO_HOME + BAK_FILE).exists();
    }
    /**
     * 主要操作方法，组织工作流程
     * Main process method
     *
     * @throws IOException
     */
    public void patch() throws IOException {
// init
        init();
//输入参数：
//1:进行查找替换
//2:将备份文件恢复
        String input = new BufferedReader(new InputStreamReader(System.in))
                .readLine();
        if (input.equals("1")) {
            String temp = null;
            temp = readOriginal2Hex();
            temp = replace(temp);
            writeNew2Binary(temp);
            success();
        } else if (input.equals("2")) {
            restore();
        } else {
            System.out.println("Bad input parameter!");
            System.exit(0);
        }
    }
    /**
     * Main方法
     * main
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        HexTool tool = new HexTool();
        tool.patch();
    }
}
