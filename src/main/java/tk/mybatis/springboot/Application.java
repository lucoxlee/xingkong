package tk.mybatis.springboot;

//特别注意，下面的是 tk.MapperScan

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.hadoop.fs.FsShell;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;
import tk.mybatis.springboot.hbase.UserRepository;
import tk.mybatis.springboot.hbase.UserUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzh
 * @since 2015-12-12 18:22
 */
@Controller
@EnableWebMvc
@EnableCaching
@SpringBootApplication
@MapperScan(basePackages = "tk.mybatis.springboot.mapper" )
public class Application extends WebMvcConfigurerAdapter implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(Application.class);

	// 用于执行hdfs shell命令的对象
	@Autowired
	FsShell fsShell;
	@Autowired
	UserUtils userUtils;
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		logger.info("服务启动完成!" );

		// 查看根目录下的所有文件
//        for (FileStatus fileStatus : fsShell.ls("/")) {
//            System.out.println("> " + fileStatus.getPath());
//        }
//        if (!fsShell.test("/input")) {
//            fsShell.mkdir("/input");
//        }
//        fsShell.copyFromLocal("F:\\hadooptest\\input\\data.txt","/input");


//        userUtils.initialize();
//        userUtils.addUsers();
//
//        List<User> users = userRepository.findAll();
//        System.out.println("Number of users = " + users.size());
//        System.out.println(users);

	}

	@RequestMapping("/" )
	String home() {
		return "redirect:demo";
	}

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		//1、定义一个convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//2、添加fastjson的配置信息
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//2-1 处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaTypes);
		//3、在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		//4、将convert添加到converters中
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
}
