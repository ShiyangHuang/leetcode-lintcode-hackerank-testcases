package com.dataguess.Masking;

/**
 * Created by shiyanghuang on 16/9/2.
 */
public class AddressRecord {
    String zip;
    String city;
    String state;

    public AddressRecord(String zip, String city, String state) {
        this.zip = zip;
        this.city = city;
        this.state = state;
    }

    public String getZip() {
        return this.zip;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }
}
