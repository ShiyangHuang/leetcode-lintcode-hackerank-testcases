package com.Jmap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.security.PrivilegedExceptionAction;
import java.util.Date;

/**
 * Created by shiyanghuang on 16/3/22.
 */
public class filesystemCloseTest {

    final static Configuration conf = new Configuration();

    public static void main(String[] args) {
        conf.setBoolean("fs.hdfs.impl.disable.cache", true);
        conf.setBoolean("fs.maprfs.impl.disable.cache", true);
        int t = 0;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    new filesystemCloseTest().doSomething();
                }
            };


        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    public void doSomething() {

        UserGroupInformation.setConfiguration(conf);
        UserGroupInformation ugi = null;

        try {
            ugi = UserGroupInformation.getLoginUser();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            final UserGroupInformation finalUgi = ugi;
            System.out.println(Thread.currentThread().getName());
            // Thread.sleep((int)Math.random()*100);
            FileSystem fs = (FileSystem) ugi.doAs(new PrivilegedExceptionAction() {
                @Override
                public Object run() throws Exception {
                    FileSystem fsInternal = FileSystem.get(conf);
                    return fsInternal;
                }
            });
            Path path = new Path("hdfs://cdh1.dg:8020/");
            FileStatus[] fsStatus = fs.listStatus(path);
            FSDataInputStream fsi = fs.open(new Path("/amexTest/out.txt"));
            int a = 0;
            while ((a = fsi.read()) > 0) {
                System.out.print((char) a);
            }
            Date date = new Date();
            // System.out.println(date.toString() + " Username: " + finalUgi.getUserName());
            // Thread.sleep((int)Math.random()*100);
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
