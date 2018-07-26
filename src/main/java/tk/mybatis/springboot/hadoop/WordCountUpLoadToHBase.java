package tk.mybatis.springboot.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 7:59 PM 7/23/2018
 */
public class WordCountUpLoadToHBase extends Configured {

    public static class WCHBaseMapper extends Mapper<Object, Text, ImmutableBytesWritable, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
            StringTokenizer strs = new StringTokenizer(value.toString());
            while(strs.hasMoreTokens()){
                word.set(strs.nextToken());
                context.write(new ImmutableBytesWritable(Bytes.toBytes(word.toString())), one);
            }
        }

    }

    public static class WCHBaseReducer extends TableReducer<ImmutableBytesWritable, IntWritable, ImmutableBytesWritable> {

        @Override
        public void reduce(ImmutableBytesWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException{
            int sum = 0;
            for(IntWritable val:values){
                sum += val.get();
            }
            Put put = new Put(key.get());
            put.add(Bytes.toBytes("content"),Bytes.toBytes("count"),Bytes.toBytes(sum+""));
            context.write(key, put);
        }
    }


    public static void main(String[] args) throws MasterNotRunningException, ZooKeeperConnectionException, IOException, ClassNotFoundException, InterruptedException {
        // TODO Auto-generated method stub
        String tableName = "wordcount";
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum","106.15.58.63");
        conf.set("hbase.zookeeper.property.clientPort","2181");

        HBaseAdmin admin = new HBaseAdmin(conf);
        //如果表格存在就删除
        if(admin.tableExists(tableName)){
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
        }
        HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
        HColumnDescriptor columnDescriptor =new HColumnDescriptor("content");
        tableDescriptor.addFamily(columnDescriptor);
        admin.createTable(tableDescriptor);

        Job job = new Job(conf,"upload to hbase");
        job.setJarByClass(WordCountUpLoadToHBase.class);
        job.setMapperClass(WCHBaseMapper.class);
        TableMapReduceUtil.initTableReducerJob(tableName, WCHBaseReducer.class, job,null,null,null,null,false);

        job.setMapOutputKeyClass(ImmutableBytesWritable.class);
        job.setMapOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(ImmutableBytesWritable.class);
        job.setOutputValueClass(Put.class);
        FileInputFormat.addInputPaths(job, "hdfs://106.15.58.63:9000/input/data.txt");
        job.waitForCompletion(true);

    }

}
