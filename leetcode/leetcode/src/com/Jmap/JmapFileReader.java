package com.Jmap;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by shiyanghuang on 16/3/15.
 */
public class JmapFileReader {
    static String path = "/Users/shiyanghuang/Documents/Dataguise/memoryLeak/mapr/jmapa/jmaplog/";

    public static void main(String[] args){
        dif();
        // one();
        // all();
        // analyze();
        // list();
    }

    public static void analyze() {
        ArrayList<String> list = one();
        // System.out.print(list.size());
        for (String str : list) {
            // System.out.println(str);
            System.out.print(str.replace("\n","\t"));
            all(str);
            System.out.println();
        }
    }
    public static ArrayList<String> list() {
        try {
            return tree(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void all(String classname) {

        // classname = "UserGroup";
        File f = new File(path);
        try {
            tree(f, classname);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> one() {

        String filename = "03.30.11.22.00";
        try {
            return fileReader(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void dif() {
        String file1 = "jmap_agent_2016-3-31";
        String file2 = "04.03.17.05.10";
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();

        try {
            fileReader(file1, map1);
            fileReader(file2, map2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Map.Entry<String, Integer>> set = map1.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            if (map2.containsKey(entry.getKey())) {
                int dif = (map2.get(entry.getKey()) - entry.getValue());
                System.out.println("" + dif + "\t\t\t" + entry.getKey());
            }
        }
    }
    //显示目录的方法

    public static ArrayList<String> tree(File f) throws IOException {
        //判断传入对象是否为一个文件夹对象
        ArrayList<String> list = new ArrayList<String>();
        if(!f.isDirectory()){
            System.out.println("你输入的不是一个文件夹，请检查路径是否有误！！");
        }
        else{
            File[] t = f.listFiles();
            for(int i=0;i<t.length;i++){
                //判断文件列表中的对象是否为文件夹对象，如果是则执行tree递归，直到把此文件夹中所有文件输出为止
                if(t[i].isDirectory()){
                    // System.out.println(t[i].getName()+"\tttdir");
                    tree(t[i]);
                }
                else{
                    list.add(t[i].getName());
                    System.out.println(t[i].getName());
                }
            }
        }
        return list;
    }

    public static void tree(File f, String classname) throws IOException {
        //判断传入对象是否为一个文件夹对象
        if(!f.isDirectory()){
            System.out.println("你输入的不是一个文件夹，请检查路径是否有误！！");
        }
        else{
            File[] t = f.listFiles();
            for(int i=0;i<t.length;i++){
                //判断文件列表中的对象是否为文件夹对象，如果是则执行tree递归，直到把此文件夹中所有文件输出为止
                if(t[i].isDirectory()){
                    // System.out.println(t[i].getName()+"\tttdir");
                    tree(t[i], classname);
                }
                else{
                    fileReader(t[i].getName(), classname);
                    // System.out.println(t[i].getName()+"tFile");
                }
            }
        }
    }

    public static ArrayList<String> fileReader(String filename, String classname) throws IOException {
        FileReader fr = new FileReader(path + filename);
        ArrayList<String> list = new ArrayList<String>();
        int ch = 0;
        String line = null;
        StringBuffer sb = new StringBuffer();
        // System.out.print(classname + "\t");
        while((ch = fr.read()) != -1){
            if (sb.length() == 0 || ((char) ch != ' ') || ((char) ch == ' ' && sb.charAt(sb.length() -1) != ' ')) {
                sb.append((char) ch);
            }
            if (ch == '\n') {
                line = sb.toString();
                if (line.contains(classname)) {
                    list.add(line.replace(' ', '\t'));
                    try {
                        System.out.print(line.replace(' ', '\t').split("\t")[3] + "\t");
                    } catch (Exception e) {

                    }
                    break;
                }
                sb = new StringBuffer();
            }
        }
        fr.close();
        // System.out.println();
        return list;
    }



    public static ArrayList<String> fileReader(String filename) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        FileReader fr = new FileReader(path + filename);
        int ch = 0;
        String line = null;
        StringBuffer sb = new StringBuffer();
        while((ch = fr.read()) != -1){
            if (sb.length() == 0 || ((char) ch != ' ') || ((char) ch == ' ' && sb.charAt(sb.length() -1) != ' ')) {
                sb.append((char) ch);
            }
            if (ch == '\n') {
                line = sb.toString();
                try {
                    list.add(line.replace(' ', '\t').split("\t")[4]);
                } catch (Exception e) {

                }
                // System.out.print(line.replace(' ', '\t'));
                sb = new StringBuffer();
            }
        }
        fr.close();
        return list;
    }

    public static void fileReader(String filename, HashMap<String, Integer> map) throws IOException {
        FileReader fr = new FileReader(path + filename);
        int ch = 0;
        String line = null;
        StringBuffer sb = new StringBuffer();
        while((ch = fr.read()) != -1){
            if (sb.length() == 0 || ((char) ch != ' ') || ((char) ch == ' ' && sb.charAt(sb.length() -1) != ' ')) {
                sb.append((char) ch);
            }
            if (ch == '\n') {
                line = sb.toString().replace(" ","-");
                String[] newLine = line.split("-");
                // System.out.print(line + " " + newLine.length);
                if (newLine.length > 4) {
                    // System.out.println(newLine[3] + " " + newLine[4]);
                    // 2 for instance
                    // 3 for bytes
                    // 4 for Classname
                    try {
                        map.put(newLine[4].substring(0, newLine[4].length() - 1), Integer.parseInt(newLine[2]));
                    } catch (Exception e) {

                    }
                }
                // System.out.println();
                sb = new StringBuffer();
            }
        }
        fr.close();
    }
}
