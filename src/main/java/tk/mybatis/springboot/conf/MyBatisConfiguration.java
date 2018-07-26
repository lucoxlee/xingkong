package tk.mybatis.springboot.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 8:21 PM 7/16/2018
 */
//@Configuration
public class MyBatisConfiguration {
    @Bean
    public SqlStatsInterceptor sqlStatsInterceptor(){
        SqlStatsInterceptor sqlStatsInterceptor = new SqlStatsInterceptor();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        sqlStatsInterceptor.setProperties(properties);
        return sqlStatsInterceptor;
    }
}
