package tk.mybatis.springboot.hbase;

import org.apache.hadoop.hbase.client.Result;

import java.io.IOException;
import java.util.List;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 9:38 AM 7/24/2018
 */
public interface HbaseService {
    /**
     * 查询全表的数据
     * @param tablename
     * @return
     */
    public List<Result> scaner(String tablename);
    /**
     * 根据rowKey查询单条记录
     * @param tableName
     * @param rowKey
     * @return
     */
    public Result getRow(String tableName, String rowKey);
    /**
     * 根据regxKey正则匹配数据
     * @param tableName
     * @param regxKey
     * @return
     */
    public List<Result> getRegexRow(String tableName,String regxKey);
    /**
     * 根据regxKey正则匹配数据,取出num条
     * @param tableName
     * @param regxKey
     * @param num
     * @return
     */
    public List<Result> getRegexRow(String tableName,String regxKey,int num);
    /**
     * 根据startKey和endKey的范围匹配数据
     * @param tableName
     * @param startKey
     * @param stopKey
     * @return
     */
    public List<Result> getStartRowAndEndRow(String tableName, String startKey, String stopKey);
    /**
     * 确定startKey和endKey的范围，根据regKey匹配数据
     * @param tableName
     * @param startKey
     * @param stopKey
     * @param regxKey
     * @return
     */
    public List<Result> getRegexRow(String tableName, String startKey, String stopKey, String regxKey);
    /**
     * 确定startKey和endKey的范围，根据regKey匹配数据,取出num条
     * @param tableName
     * @param startKey
     * @param stopKey
     * @param regxKey
     * @param num
     * @return
     */
    public List<Result> getRegexRow(String tableName, String startKey, String stopKey, String regxKey,int num);
    /**
     * 添加数据
     * @param rowKey
     * @param tableName
     * @param column
     * @param value
     */
    public void addData(String rowKey, String tableName, String[] column, String[] value);
    /**
     * 删除记录
     * @param tableName
     * @param rowKeys
     */
    public void delRecord(String tableName, String... rowKeys);
    /**
     * 修改一条数据
     * @param tableName
     * @param rowKey
     * @param familyName
     * @param column
     * @param value
     * @throws IOException
     */
    public void updateTable(String tableName, String rowKey,String familyName, String column[], String value[]) throws IOException;
    /**
     * 查找最新的一条数据,或者说倒序查询
     * @param tableName
     * @return
     */
    public Result getNewRow(String tableName);
    /**
     * 正则查出所有匹配的key
     * @param tableName
     * @param regxKey
     * @return
     */
    public List<String> queryKeys(String tableName, String regxKey);
    /**
     * 增加表中对应字段的值
     * @param tableName
     * @param cf
     * @param rowKey
     * @param column
     * @param num
     * @return
     */
    long incrQualifier(String tableName, String cf, String rowKey, String column, long num);
    Result getNewRow(String tableName, String regxKey);

}
