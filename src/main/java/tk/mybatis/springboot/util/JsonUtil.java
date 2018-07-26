package tk.mybatis.springboot.util;

import com.alibaba.fastjson.JSON;
import tk.mybatis.springboot.hbase.CityNum;
import tk.mybatis.springboot.model.City;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 3:57 PM 7/23/2018
 */
public class JsonUtil {

    /**
     * 初始化User对象
     * @return user
     */
    private static CityNum initUser(){
        return new CityNum("hello", "1");
    }

    public static void main(String[] args) throws Exception {
        // fastjson用法
        fastjson();
    }

    private static void fastjson(){
        // 将Java对象序列化为Json字符串
        String objectToJson = JSON.toJSONString(initUser());
        System.out.println(objectToJson);
        // 将Json字符串反序列化为Java对象
        CityNum city = JSON.parseObject(objectToJson, CityNum.class);
        System.out.println(city);
    }

}
