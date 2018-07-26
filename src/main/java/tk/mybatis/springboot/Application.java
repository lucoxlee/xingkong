package tk.mybatis.springboot;

//特别注意，下面的是 tk.MapperScan

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.hadoop.fs.FsShell;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;
import tk.mybatis.springboot.hadoop.ImpHBaseFormHDFS;
import tk.mybatis.springboot.hbase.User;
import tk.mybatis.springboot.hbase.UserRepository;
import tk.mybatis.springboot.hbase.UserUtils;
import tk.mybatis.springboot.model.City;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzh
 * @since 2015-12-12 18:22
 */
@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "tk.mybatis.springboot.mapper")
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
        logger.info("服务启动完成!");

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

    @RequestMapping("/")
    String home() {
        return "redirect:countries";
    }
}
