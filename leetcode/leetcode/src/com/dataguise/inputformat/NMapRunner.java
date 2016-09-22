package com.dataguise.inputformat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;

/**
 * Created by shiyanghuang on 16/7/18.
 */
public class NMapRunner<K1, V1, K2, V2>  extends MapRunner<LongWritable, Text, K2, V2> {

    private Mapper<LongWritable, Text, K2, V2> mapper;
    private boolean incrProcCount;
    private int lineNum = 0;

    public NMapRunner() {
    }

    public void configure(JobConf job) {
        this.mapper = (Mapper) ReflectionUtils.newInstance(job.getMapperClass(), job);
        this.incrProcCount = SkipBadRecords.getMapperMaxSkipRecords(job) > 0L && SkipBadRecords.getAutoIncrMapperProcCount(job);
    }

    public void run(LineRecordReader input, OutputCollector<K2, V2> output, Reporter reporter) throws IOException {
        try {

            while(input.nextKeyValue()) {
                this.mapper.map(new LongWritable(lineNum++), input.getCurrentValue(), output, reporter);
                if(this.incrProcCount) {
                    reporter.incrCounter("SkippingTaskCounters", "MapProcessedRecords", 1L);
                }
            }
        } finally {
            this.mapper.close();
        }

    }

    protected Mapper<LongWritable, Text, K2, V2> getMapper() {
        return this.mapper;
    }
}
