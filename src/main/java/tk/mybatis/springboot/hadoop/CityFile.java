package tk.mybatis.springboot.hadoop;

import cn.hutool.core.io.file.FileWriter;
import com.alibaba.fastjson.JSON;
import tk.mybatis.springboot.hbase.CityNum;
import tk.mybatis.springboot.model.City;

import java.util.ArrayList;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 12:35 PM 7/23/2018
 */
public class CityFile {
    public static void main(String[] args) {
        FileWriter writer = new FileWriter("F:\\hadooptest\\input\\data.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append(JSON.toJSONString(new CityNum("city" + i, "state" + i))+"\n");
        }
        writer.write(stringBuilder.toString());
    }
}
