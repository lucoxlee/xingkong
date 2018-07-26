package tk.mybatis.springboot.hbase;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 4:31 PM 7/23/2018
 */
public class CityNum {
    private String name;
    private String num;

    public CityNum() {
    }

    public CityNum(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
