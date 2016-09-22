package com.dataguise;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;

/**
 * Created by shiyanghuang on 16/6/20.
 */
public class hadoopAPI {
    public static void main(String[] args) {

    }

    public void listFolder(Configuration conf, String path) throws IOException {
        FileSystem fs = null;
        fs = FileSystem.get(conf);
        FileStatus[] fileStatuses = fs.listStatus(new Path(path));
        FileChecksum fc = fs.getFileChecksum(new Path(path));
        fc.getLength();
        ContentSummary cs = fs.getContentSummary(new Path(path));
        System.out.println(cs.getFileCount());
    }
}
