package tk.mybatis.springboot.hbase;

import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityNumRepository {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    private String tableName = "cityNum";

    public static byte[] CF_INFO = Bytes.toBytes("content");

    private byte[] qName = Bytes.toBytes("name");
    private byte[] qNum = Bytes.toBytes("num");

    public List<CityNum> findAll() {
        return hbaseTemplate.find(tableName, "content", new RowMapper<CityNum>() {
            @Override
            public CityNum mapRow(Result result, int rowNum) throws Exception {
                return new CityNum(Bytes.toString(result.getValue(CF_INFO, qName)),
                        Bytes.toString(result.getValue(CF_INFO, qNum))
                );
            }
        });
    }

    public CityNum save(final Text name, final int num) {
        return hbaseTemplate.execute(tableName, new TableCallback<CityNum>() {
            @Override
            public CityNum doInTable(HTableInterface table) throws Throwable {
                CityNum user = new CityNum(name.toString(), ""+num);
                Put p = new Put(Bytes.toBytes(user.getName()));
                p.add(CF_INFO, qName, Bytes.toBytes(user.getName()));
                p.add(CF_INFO, qNum, Bytes.toBytes(user.getNum()));
                table.put(p);
                return user;

            }
        });
    }


}
