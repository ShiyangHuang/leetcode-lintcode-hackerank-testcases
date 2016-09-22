package com.dataguise;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.ql.io.RCFile;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * Created by shiyanghuang on 16/7/25.
 */
public class snappyRCFile {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        FileSystem fs = null;
        RCFile.Reader rcReader = null;
        try {
            fs = FileSystem.get(conf);
            rcReader= new RCFile.Reader(fs, new Path(args[0]), conf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Text columns = rcReader.getMetadata().get(new Text("hive.io.rcfile.column.number"));
        System.out.println(columns);
    }
}
