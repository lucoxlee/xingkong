package tk.mybatis.springboot.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 10:32 AM 7/24/2018
 */
//上传本地文件到HDFS
public class CopyFile {
    public static void main(String[] args) throws IOException {
        //获取配置文件信息
        Configuration conf = new Configuration();
        conf.addResource(new Path("core-site.xml"));
        //获取文件系统
        FileSystem hdfs = FileSystem.get(conf);
        //文件名称
        Path src = new Path("F:\\hadooptest\\hello.txt");
        Path dst = new Path("hdfs://106.15.58.63:9000/hello");
        if(!hdfs.exists(dst)){
            hdfs.mkdirs(dst);
        }
        hdfs.copyFromLocalFile(src, dst);
        System.out.println("Upload to " + conf.get("fs.default.name"));
        FileStatus files[] = hdfs.listStatus(dst);
        for(FileStatus file:files){
            System.out.println(file.getPath());
        }
    }
}