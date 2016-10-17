package com.dataguess.Masking;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by shiyanghuang on 16/6/17.
 */
public class GenerateNameList {
    private ArrayList<String> nameList = new ArrayList<String>();

    public void readFile(String path) throws IOException {
        InputStream in = getClass().getResourceAsStream(path);
        BufferedReader fr = null;
        try {
            fr = new BufferedReader(new InputStreamReader(in));
        } catch (NullPointerException npe) {
            throw new NullPointerException("Cannot find file: " + in + "\n" + npe.getMessage());
        }

        try {
            String ch = "";
            while((ch = fr.readLine()) != null){
                if (ch.startsWith("#")) {
                    continue;
                } else {
                    nameList.add(ch);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    GenerateNameList(String path) {
        try {
            readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getNameList() {
        return nameList;
    }

    public String maskName(String name) {
        return nameList.get(name.hashCode() % nameList.size());
    }
}
