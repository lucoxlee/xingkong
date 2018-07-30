/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package tk.mybatis.springboot.controller;

import cn.hutool.core.io.file.FileWriter;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.ToolRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.springboot.hadoop.CityCount;
import tk.mybatis.springboot.hadoop.ImpHBaseFormHDFS;
import tk.mybatis.springboot.hbase.CityNum;
import tk.mybatis.springboot.hbase.CityNumRepository;
import tk.mybatis.springboot.hbase.HbaseService;
import tk.mybatis.springboot.hbase.UserRepository;
import tk.mybatis.springboot.model.City;
import tk.mybatis.springboot.service.CityService;
import tk.mybatis.springboot.util.Client;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@RestController
@RequestMapping("/hadoop")
public class HadoopController {
    long start, end;
    @Autowired
    CityNumRepository cityNumRepository;
    @Autowired
    private HbaseService hbaseService;

    @RequestMapping("makeFile")
    public String makeFile() {
        start = System.currentTimeMillis();

        FileWriter writer = new FileWriter("/root/data.txt");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append(JSON.toJSONString(new CityNum("city" + i, "state" + i)) + "\n");
        }
        writer.write(stringBuilder.toString());
        end = System.currentTimeMillis();
        return "Fileinfo：/root/data.txt   time{" + "start time:" + start + "; end time:" + end + "; Run Time:" + (end - start) + "(ms)}";
    }

    @RequestMapping("copyFile")
    public String copyFile() throws IOException {
        start = System.currentTimeMillis();
        //获取配置文件信息
        Configuration conf = new Configuration();
        conf.addResource(new Path("core-site.xml"));
        //获取文件系统
        FileSystem hdfs = FileSystem.get(conf);
        //文件名称
        Path src = new Path("/root/data.txt");
        Path dst = new Path("hdfs://106.15.58.63:9000/input");
        if (!hdfs.exists(dst)) {
            hdfs.mkdirs(dst);
        }
        hdfs.copyFromLocalFile(src, dst);
        end = System.currentTimeMillis();
        return "Upload to " + conf.get("fs.default.name") + "time{" + "start time:" + start + "; end time:" + end + "; Run Time:" + (end - start) + "(ms)}";
    }

    @RequestMapping("doJob")
    public String doJob(City city) throws Exception {
        start = System.currentTimeMillis();
        CityCount.CityCount();
        end = System.currentTimeMillis();
        return "success" + "time{" + "start time:" + start + "; end time:" + end + "; Run Time:" + (end - start) + "(ms)}";
    }


    @RequestMapping("cityNumAll")
    public List<CityNum> cityNumList() throws Exception {
        ArrayList<Result> results = (ArrayList<Result>) hbaseService.scaner("cityNum");
        ArrayList<CityNum> arrayList = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            CityNum city = new CityNum();
            Result result = results.get(i);
            city.setName(Bytes.toString(result.getValue(Bytes.toBytes("content"), Bytes.toBytes("name"))));
            city.setNum(Bytes.toString(result.getValue(Bytes.toBytes("content"), Bytes.toBytes("num"))));
            arrayList.add(city);
        }
        return arrayList;
    }

    @RequestMapping("getRowByKey")
    public CityNum getRowByKey(CityNum city) throws Exception {
        Result result = hbaseService.getRow("cityNum", city.getName());
        city.setName(Bytes.toString(result.getValue(Bytes.toBytes("content"), Bytes.toBytes("name"))));
        city.setNum(Bytes.toString(result.getValue(Bytes.toBytes("content"), Bytes.toBytes("num"))));
        return city;
    }


    @RequestMapping("getRegexRowByKey")
    public List<CityNum> getRegexRowByKey(String regex) throws Exception {
        ArrayList<Result> results = (ArrayList<Result>) hbaseService.getRegexRow("cityNum", regex, 100);
        ArrayList<CityNum> arrayList = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            CityNum city = new CityNum();
            Result result = results.get(i);
            city.setName(Bytes.toString(result.getValue(Bytes.toBytes("content"), Bytes.toBytes("name"))));
            city.setNum(Bytes.toString(result.getValue(Bytes.toBytes("content"), Bytes.toBytes("num"))));
            arrayList.add(city);
        }

        return arrayList;
    }


    @RequestMapping("inputData")
    public Map inputData(CityNum city) throws Exception {
        Result result = hbaseService.getRow("cityNum", city.getName());
        city.setName(Bytes.toString(result.getValue(Bytes.toBytes("content"), Bytes.toBytes("name"))));
        city.setNum(Bytes.toString(result.getValue(Bytes.toBytes("content"), Bytes.toBytes("num"))));

        Map map = new HashMap();
        map.put("input", JSON.toJSONString(city));
        map.put("output", Client.sentData(JSON.toJSONString(city)));
        return map;
    }



}
