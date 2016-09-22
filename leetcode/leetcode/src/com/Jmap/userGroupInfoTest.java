package com.Jmap;

import org.apache.hadoop.conf.Configuration;
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
public class userGroupInfoTest {

    public static void main(String[] args) {

        while (true) {
            Runnable run = new  Runnable() {
                @Override
                public void run() {
                    new userGroupInfoTest().run();
                }
            };
            run.run();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        Configuration conf = new Configuration();

        UserGroupInformation.setConfiguration(conf);

        UserGroupInformation ugi = null;

        try {
            ugi = UserGroupInformation.getLoginUser();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            final UserGroupInformation finalUgi = ugi;
            FileSystem fs = (FileSystem) ugi.doAs(new PrivilegedExceptionAction() {
                @Override
                public Object run() throws Exception {
                    FileSystem fsInternal = FileSystem.get(new Configuration());
                    Path path = new Path("hdfs://cdh1.dg:8020/");
                    FileStatus[] fsStatus = fsInternal.listStatus(path);
                    for (int i = 0; i < fsStatus.length; i++) {
                        System.out.println("FileStatus: " + fsStatus[i].getPath().toString());
                    }

                    Date date = new Date();
                    System.out.println(date.toString() + " Username: " + finalUgi.getUserName());
                    Thread.sleep(1000);
                    return fsInternal;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
