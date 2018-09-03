package tk.mybatis.springboot.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 9:14 2018/8/8
 */
public class MathUtil {

    public static boolean getRandomNum(double randomNum) {
        // 7. 产生一个随机数
        Random random = new Random();
        double base = random.nextDouble();
        System.out.println(base);
        // 8. 产生的随机数小于概率数，则失败
        if (base > randomNum) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getRandomNum(0.25));
    }
}
