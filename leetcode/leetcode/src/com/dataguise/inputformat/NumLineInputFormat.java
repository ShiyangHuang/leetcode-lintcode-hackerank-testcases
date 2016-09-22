package com.dataguise.inputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.LineReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
* Created by shiyanghuang on 16/7/18.
*/

public class NumLineInputFormat extends FileInputFormat<LongWritable, Text> {
    public static final String LINES_PER_MAP = "mapreduce.input.lineinputformat.linespermap";

    public NumLineInputFormat() {
    }

    public RecordReader<LongWritable, Text> createRecordReader(InputSplit genericSplit, TaskAttemptContext context) throws IOException {
        context.setStatus(genericSplit.toString());
        return new NRecordReader();
    }

    public List<InputSplit> getSplits(JobContext job) throws IOException {
        ArrayList splits = new ArrayList();
        int numLinesPerSplit = getNumLinesPerSplit(job);
        Iterator i$ = this.listStatus(job).iterator();

        while(i$.hasNext()) {
            FileStatus status = (FileStatus)i$.next();
            splits.addAll(getSplitsForFile(status, job.getConfiguration(), numLinesPerSplit));
        }

        return splits;
    }

    public static List<LineFileSplit> getSplitsForFile(FileStatus status, Configuration conf, int numLinesPerSplit) throws IOException {
        ArrayList splits = new ArrayList();
        Path fileName = status.getPath();
        if(status.isDir()) {
            throw new IOException("Not a file: " + fileName);
        } else {
            FileSystem fs = fileName.getFileSystem(conf);
            LineReader lr = null;

            try {
                FSDataInputStream in = fs.open(fileName);
                lr = new LineReader(in, conf);
                Text line = new Text();
                int numLines = 0;
                long begin = 0L;
                long length = 0L;
                boolean num = true;
                long totalLines = 1;

                int var18;
                while((var18 = lr.readLine(line)) > 0) {
                    ++numLines;
                    length += (long)var18;
                    if(numLines == numLinesPerSplit) {
                        if(begin == 0L) {
                            splits.add(new LineFileSplit(fileName, begin, length - 1L, new String[0], totalLines++));
                        } else {
                            splits.add(new LineFileSplit(fileName, begin - 1L, length, new String[0], totalLines++));
                        }

                        begin += length;
                        length = 0L;
                        numLines = 0;
                    }
                }

                if(numLines != 0) {
                    splits.add(new LineFileSplit(fileName, begin, length, new String[0], totalLines++));
                }
            } finally {
                if(lr != null) {
                    lr.close();
                }

            }

            return splits;
        }
    }

    public static void setNumLinesPerSplit(Job job, int numLines) {
        job.getConfiguration().setInt("mapreduce.input.lineinputformat.linespermap", numLines);
    }

    public static int getNumLinesPerSplit(JobContext job) {
        return job.getConfiguration().getInt("mapreduce.input.lineinputformat.linespermap", 1);
    }
}