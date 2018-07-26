package tk.mybatis.springboot.hadoop;

import com.alibaba.fastjson.JSON;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.Tool;
import tk.mybatis.springboot.hbase.CityNum;

import java.io.IOException;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 5:43 PM 7/23/2018
 */
public class ImpHBaseFormHDFS extends Configured implements Tool {

    /**
     * LongWritable 文件中一行文本的偏移量
     * Text 文件中一行文本内容
     * ImmutableBytesWritable 对应行健
     * Put 对应一条数据
     */
    public static class HDFSMapper extends Mapper<LongWritable, Text, ImmutableBytesWritable, Put> {
        private ImmutableBytesWritable rowkey = new ImmutableBytesWritable(); // rowkey
        private byte[] info = Bytes.toBytes("ciInfo");// 列族
        private byte[] name = Bytes.toBytes("name");// 列：名称 name
        private byte[] num = Bytes.toBytes("num");// 列：数量 num

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            CityNum city = JSON.parseObject(value.toString(), CityNum.class);
            rowkey.set(Bytes.toBytes(city.getName())); // 将课程作为rowkey
            Put put = new Put(Bytes.toBytes(city.getName()));
            put.addColumn(info, name, Bytes.toBytes(city.getName()));
            put.addColumn(info, num, Bytes.toBytes(city.getNum()));
            context.write(rowkey, put);
        }
    }

    @Override
    public int run(String[] args) throws Exception {
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "106.15.58.63");
        conf.set("hbase.zookeeper.port", "2181");
        Job job = Job.getInstance(conf, "导入hdfs数据到HBase中");
        job.setJarByClass(ImpHBaseFormHDFS.class);
        job.setMapperClass(HDFSMapper.class);
        job.setMapOutputKeyClass(ImmutableBytesWritable.class);
        job.setMapOutputValueClass(Put.class);
        FileInputFormat.addInputPath(job, new Path("/"));
        // TableMapReduceUtil 读取了hadoop的配置文件和hbase的配置文件，并做了合并
        TableMapReduceUtil.initTableReducerJob(
                "cityNum",        // output table
                null,  // reducer class
                job);
        job.setNumReduceTasks(1); // at least one, adjust as required

        // 成功返回0，失败返回1
        return job.waitForCompletion(true) ? 0 : 1;
    }

}
