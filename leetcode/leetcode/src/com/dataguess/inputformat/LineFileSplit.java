package com.dataguess.inputformat;

import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.SplitLocationInfo;
import org.apache.hadoop.mapreduce.InputSplit;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by shiyanghuang on 16/7/18.
 */
public class LineFileSplit extends InputSplit implements Writable {
    private Path file;
    private long start;
    private long length;
    private String[] hosts;
    private SplitLocationInfo[] hostInfos;
    private long lineNumber;


    LineFileSplit() {

    }

    LineFileSplit(Path file, long start, long length, String[] hosts, long lineNumber) {
        this.file = file;
        this.start = start;
        this.length = length;
        this.hosts = hosts;
        this.lineNumber = lineNumber;
    }

    LineFileSplit(Path file, long start, long length, String[] hosts, String[] inMemoryHosts, long lineNumber) {
        this(file, start, length, hosts, lineNumber);
        this.hostInfos = new SplitLocationInfo[hosts.length];
        int i = 0;

        while(i < hosts.length) {
            boolean inMemory = false;
            String[] arr$ = inMemoryHosts;
            int len$ = inMemoryHosts.length;
            int i$ = 0;

            while(true) {
                if(i$ < len$) {
                    String inMemoryHost = arr$[i$];
                    if(!inMemoryHost.equals(hosts[i])) {
                        ++i$;
                        continue;
                    }

                    inMemory = true;
                }

                this.hostInfos[i] = new SplitLocationInfo(hosts[i], inMemory);
                ++i;
                break;
            }
        }
        this.lineNumber = lineNumber;
    }

    public Path getPath() {
        return this.file;
    }

    public long getStart() {
        return this.start;
    }

    public long getLength() {
        return this.length;
    }

    public String toString() {
        return this.file + ":" + this.start + "+" + this.length;
    }

    public void write(DataOutput out) throws IOException {
        Text.writeString(out, this.file.toString());
        out.writeLong(this.start);
        out.writeLong(this.length);
    }

    public void readFields(DataInput in) throws IOException {
        this.file = new Path(Text.readString(in));
        this.start = in.readLong();
        this.length = in.readLong();
        this.hosts = null;
    }

    public String[] getLocations() throws IOException {
        return this.hosts == null?new String[0]:this.hosts;
    }

    @InterfaceStability.Evolving
    public SplitLocationInfo[] getLocationInfo() throws IOException {
        return this.hostInfos;
    }

    public long getLineNumber() {
        return this.lineNumber;
    }
}
