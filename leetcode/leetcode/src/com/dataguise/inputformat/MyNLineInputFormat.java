package com.dataguise.inputformat;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/**
 * Created by shiyanghuang on 16/7/15.
 */
public class MyNLineInputFormat {

    public static void main(String[] args) {

        try {
            // 创建配置信息
            JobConf jobconf = new JobConf();
            //设置每个Map可以是处理多少条记录
            jobconf.setInt("mapreduce.input.lineinputformat.linespermap", 10);
            /**********************************************/
            //对Map端输出进行压缩
            //conf.setBoolean("mapred.compress.map.output", true);
            //设置map端输出使用的压缩类
            //conf.setClass("mapred.map.output.compression.codec", GzipCodec.class, CompressionCodec.class);
            //对reduce端输出进行压缩
            //conf.setBoolean("mapred.output.compress", true);
            //设置reduce端输出使用的压缩类
            //conf.setClass("mapred.output.compression.codec", GzipCodec.class, CompressionCodec.class);
            // 添加配置文件(我们可以在编程的时候动态配置信息，而不需要手动去改变集群)
				/*
				 * conf.addResource("classpath://hadoop/core-site.xml");
				 * conf.addResource("classpath://hadoop/hdfs-site.xml");
				 * conf.addResource("classpath://hadoop/hdfs-site.xml");
				 */


            // 创建任务
            jobconf.setMapRunnerClass(NMapRunner.class);
            Job job = new Job(jobconf, MyNLineInputFormat.class.getName());
            job.setJarByClass(MyNLineInputFormat.class);


            // 天龙八部1.1	设置输入目录和设置输入数据格式化的类
            FileInputFormat.setInputPaths(job, args[0]);
            job.setInputFormatClass(NumLineInputFormat.class);

            // 天龙八部1.2	设置自定义Mapper类和设置map函数输出数据的key和value的类型
            job.setMapperClass(MyNLineInputFormatMapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(LongWritable.class);

            // 天龙八部1.3	设置分区和reduce数量(reduce的数量，和分区的数量对应，因为分区为一个，所以reduce的数量也是一个)
            job.setPartitionerClass(Partitioner.class);
            job.setNumReduceTasks(1);

            // 天龙八部1.4	排序、分组
            // 天龙八部1.5	归约
            // 天龙八部2.1	Shuffle把数据从Map端拷贝到Reduce端。
            // 天龙八部2.2	指定Reducer类和输出key和value的类型
            job.setReducerClass(MyNLineInputFormatReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(LongWritable.class);

            // 天龙八部2.3	指定输出的路径和设置输出的格式化类
            FileOutputFormat.setOutputPath(job, new Path(args[1]));
            job.setOutputFormatClass(TextOutputFormat.class);


            // 提交作业 退出
            System.exit(job.waitForCompletion(true) ? 0 : 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MyNLineInputFormatMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

        // 定义一个LongWritable对象作为map输出的value类型
        LongWritable oneTime = new LongWritable(1);
        // 定义一个Text对象作为map输出的key类型
        Text word = new Text();

        protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException,
                InterruptedException {

            // 对每一行记录采用制表符(\t)进行分割
            String[] splits = value.toString().split("\t");

            // 遍历字符串数组输出每一个单词
            for (String str : splits) {

                // 设置word
                word.set(str);
                // 把结果写出去
                context.write(word, key);
            }

        }
    }

    public static class MyNLineInputFormatReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        // 定义LongWritable对象最为Reduce输出的value类型
        LongWritable result = new LongWritable();

        protected void reduce(Text key, Iterable<LongWritable> values, Reducer.Context context) throws IOException,
                InterruptedException {

            int sum = 0;

            // 遍历集合，计算每个单词出现的和
            for (LongWritable s : values) {

                // 设置result
                result.set(s.get());
                // 把结果写出去
                context.write(key, result);
            }
        }
    }
}

