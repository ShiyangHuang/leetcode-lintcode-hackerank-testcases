package com.testcases;

import java.io.File;
import java.net.URI;
import java.net.URLEncoder;

/**
 * Created by shiyanghuang on 17/1/17.
 */
public class URItest {
    public static void main(String[] args) {
        String str = "gs://sdf asdf";

            URI uri = null;

            uri = URI.create((URLEncoder.encode(str)));

            System.out.println(uri);
            uri = new File(str).toURI();
            System.out.println(uri);

    }
}
