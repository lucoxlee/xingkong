package tk.mybatis.springboot.conf;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 4:19 PM 7/20/2018
 */
@Configuration
@ImportResource(locations ={"hadoop-context.xml"})
public class HadoopConfig {

    @Bean
    public HbaseTemplate hbaseTemplate(@Value("${hbase.zookeeper.quorum}") String quorum,
                                       @Value("${hbase.zookeeper.port}") String port) {
        HbaseTemplate hbaseTemplate = new HbaseTemplate();
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", quorum);
        conf.set("hbase.zookeeper.port", port);
        hbaseTemplate.setConfiguration(conf);
        hbaseTemplate.setAutoFlush(true);
        return hbaseTemplate;
    }

    @Bean
    public org.apache.hadoop.conf.Configuration hbaseConfiguration(@Value("${hbase.zookeeper.quorum}") String quorum,
                                                                   @Value("${hbase.zookeeper.port}") String port) {
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", quorum);
        conf.set("hbase.zookeeper.port", port);
        return conf;
    }

}
