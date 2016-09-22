package com.dataguise.Masking;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by shiyanghuang on 16/9/2.
 */
public class AddressRecords {

    ArrayList<AddressRecord> records = new ArrayList<AddressRecord>();

    AddressRecords() {
        InputStream in = getClass().getResourceAsStream("./zip,city,state.csv");
        try {
            String line = "";

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while ((line = br.readLine()) != null) { // while loop begins here
                String[] col = line.split(",");
                records.add(new AddressRecord(col[0], col[1], col[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    AddressRecords(String path) {
        try {
            String line = "";

            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) { // while loop begins here
                String[] col = line.split(",");
                records.add(new AddressRecord(col[0], col[1], col[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public long getRecordsNum() {
        return records.size();
    }

    public ArrayList<AddressRecord> getRecords() {
        return this.records;
    }
    public static void main(String[] args) {

        String file = "/Users/shiyanghuang/Documents/Dataguise/us_postal_codes.csv";
        String output = "/Users/shiyanghuang/Documents/Dataguise/zip,city,state.csv";
        AddressRecords addressRecords = new AddressRecords();
        System.out.println(addressRecords.getRecordsNum());

        FileWriter fw = null;

        try {
            fw = new FileWriter(output, true);
            for (int i = 0; i < addressRecords.getRecordsNum(); i++) {
                fw.write(addressRecords.getRecords().get(i).getZip() + "," +
                        addressRecords.getRecords().get(i).getCity() + "," +
                        addressRecords.getRecords().get(i).getState() + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException("Error!");
                }
        }
    }
}
