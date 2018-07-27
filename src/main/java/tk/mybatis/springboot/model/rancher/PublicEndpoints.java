package tk.mybatis.springboot.model.rancher;

/**
 * Auto-generated: 2018-07-27 8:59:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class PublicEndpoints {

    private String instanceId;
    private int port;
    private String ipAddress;
    private String hostId;
    private String type;
    private String serviceId;
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
    public String getInstanceId() {
        return instanceId;
    }

    public void setPort(int port) {
        this.port = port;
    }
    public int getPort() {
        return port;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getIpAddress() {
        return ipAddress;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }
    public String getHostId() {
        return hostId;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    public String getServiceId() {
        return serviceId;
    }

}
