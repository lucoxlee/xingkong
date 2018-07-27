/**
  * Copyright 2018 bejson.com 
  */
package tk.mybatis.springboot.model.rancher;
import java.util.HashMap;
import java.util.List;

/**
 * Auto-generated: 2018-07-26 17:47:58
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class LaunchConfig {

    private String instanceTriggeredStop;
    private String kind;
    private String networkMode;
    private boolean privileged;
    private boolean publishAllPorts;
    private boolean readOnly;
    private boolean runInit;
    private boolean startOnCreate;
    private boolean stdinOpen;
    private boolean tty;
    private int vcpu;
    private int drainTimeoutMs;
    private String type;
    private HashMap<String, String> labels;
    private HashMap<String, String> restartPolicy;
    private List<String> secrets;
    private List<String> dataVolumes;
    private List<String> dataVolumesFrom;
    private List<String> dns;
    private List<String> dnsSearch;
    private List<String> capAdd;
    private List<String> capDrop;
    private List<String> devices;
    private LogConfig logConfig;
    private List<String> dataVolumesFromLaunchConfigs;
    private String imageUuid;
    private List<String> ports;
    private String blkioWeight;
    private String cgroupParent;
    private String count;
    private String cpuCount;
    private String cpuPercent;
    private String cpuPeriod;
    private String cpuQuota;
    private String cpuRealtimePeriod;
    private String cpuRealtimeRuntime;
    private String cpuSet;
    private String cpuSetMems;
    private String cpuShares;
    private String createIndex;
    private String created;
    private String deploymentUnitUuid;
    private String description;
    private String diskQuota;
    private String domainName;
    private String externalId;
    private String firstRunning;
    private String healthInterval;
    private String healthRetries;
    private String healthState;
    private String healthTimeout;
    private String hostname;
    private String ioMaximumBandwidth;
    private String ioMaximumIOps;
    private String ip;
    private String ip6;
    private String ipcMode;
    private String isolation;
    private String kernelMemory;
    private String memory;
    private String memoryMb;
    private String memoryReservation;
    private String memorySwap;
    private String memorySwappiness;
    private String milliCpuReservation;
    private String oomScoreAdj;
    private String pidMode;
    private String pidsLimit;
    private String removed;
    private String requestedIpAddress;
    private String shmSize;
    private String startCount;
    private String stopSignal;
    private String stopTimeout;
    private String user;
    private String userdata;
    private String usernsMode;
    private String uts;
    private String uuid;
    private String volumeDriver;
    private String workingDir;
    private String networkLaunchConfig;

    private boolean system;

    public void setInstanceTriggeredStop(String instanceTriggeredStop) {
         this.instanceTriggeredStop = instanceTriggeredStop;
     }
     public String getInstanceTriggeredStop() {
         return instanceTriggeredStop;
     }

    public void setKind(String kind) {
         this.kind = kind;
     }
     public String getKind() {
         return kind;
     }

    public void setNetworkMode(String networkMode) {
         this.networkMode = networkMode;
     }
     public String getNetworkMode() {
         return networkMode;
     }

    public void setPrivileged(boolean privileged) {
         this.privileged = privileged;
     }
     public boolean getPrivileged() {
         return privileged;
     }

    public void setPublishAllPorts(boolean publishAllPorts) {
         this.publishAllPorts = publishAllPorts;
     }
     public boolean getPublishAllPorts() {
         return publishAllPorts;
     }

    public void setReadOnly(boolean readOnly) {
         this.readOnly = readOnly;
     }
     public boolean getReadOnly() {
         return readOnly;
     }

    public void setRunInit(boolean runInit) {
         this.runInit = runInit;
     }
     public boolean getRunInit() {
         return runInit;
     }

    public void setStartOnCreate(boolean startOnCreate) {
         this.startOnCreate = startOnCreate;
     }
     public boolean getStartOnCreate() {
         return startOnCreate;
     }

    public void setStdinOpen(boolean stdinOpen) {
         this.stdinOpen = stdinOpen;
     }
     public boolean getStdinOpen() {
         return stdinOpen;
     }

    public void setTty(boolean tty) {
         this.tty = tty;
     }
     public boolean getTty() {
         return tty;
     }

    public void setVcpu(int vcpu) {
         this.vcpu = vcpu;
     }
     public int getVcpu() {
         return vcpu;
     }

    public void setDrainTimeoutMs(int drainTimeoutMs) {
         this.drainTimeoutMs = drainTimeoutMs;
     }
     public int getDrainTimeoutMs() {
         return drainTimeoutMs;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setLabels(HashMap<String, String> labels) {
         this.labels = labels;
     }
     public HashMap<String, String> getLabels() {
         return labels;
     }

    public void setRestartPolicy(HashMap<String, String> restartPolicy) {
         this.restartPolicy = restartPolicy;
     }
     public HashMap<String, String> getRestartPolicy() {
         return restartPolicy;
     }

    public void setSecrets(List<String> secrets) {
         this.secrets = secrets;
     }
     public List<String> getSecrets() {
         return secrets;
     }

    public void setDataVolumes(List<String> dataVolumes) {
         this.dataVolumes = dataVolumes;
     }
     public List<String> getDataVolumes() {
         return dataVolumes;
     }

    public void setDataVolumesFrom(List<String> dataVolumesFrom) {
         this.dataVolumesFrom = dataVolumesFrom;
     }
     public List<String> getDataVolumesFrom() {
         return dataVolumesFrom;
     }

    public void setDns(List<String> dns) {
         this.dns = dns;
     }
     public List<String> getDns() {
         return dns;
     }

    public void setDnsSearch(List<String> dnsSearch) {
         this.dnsSearch = dnsSearch;
     }
     public List<String> getDnsSearch() {
         return dnsSearch;
     }

    public void setCapAdd(List<String> capAdd) {
         this.capAdd = capAdd;
     }
     public List<String> getCapAdd() {
         return capAdd;
     }

    public void setCapDrop(List<String> capDrop) {
         this.capDrop = capDrop;
     }
     public List<String> getCapDrop() {
         return capDrop;
     }

    public void setDevices(List<String> devices) {
         this.devices = devices;
     }
     public List<String> getDevices() {
         return devices;
     }

    public void setLogConfig(LogConfig logConfig) {
         this.logConfig = logConfig;
     }
     public LogConfig getLogConfig() {
         return logConfig;
     }

    public void setDataVolumesFromLaunchConfigs(List<String> dataVolumesFromLaunchConfigs) {
         this.dataVolumesFromLaunchConfigs = dataVolumesFromLaunchConfigs;
     }
     public List<String> getDataVolumesFromLaunchConfigs() {
         return dataVolumesFromLaunchConfigs;
     }

    public void setImageUuid(String imageUuid) {
         this.imageUuid = imageUuid;
     }
     public String getImageUuid() {
         return imageUuid;
     }

    public void setPorts(List<String> ports) {
         this.ports = ports;
     }
     public List<String> getPorts() {
         return ports;
     }

    public void setBlkioWeight(String blkioWeight) {
         this.blkioWeight = blkioWeight;
     }
     public String getBlkioWeight() {
         return blkioWeight;
     }

    public void setCgroupParent(String cgroupParent) {
         this.cgroupParent = cgroupParent;
     }
     public String getCgroupParent() {
         return cgroupParent;
     }

    public void setCount(String count) {
         this.count = count;
     }
     public String getCount() {
         return count;
     }

    public void setCpuCount(String cpuCount) {
         this.cpuCount = cpuCount;
     }
     public String getCpuCount() {
         return cpuCount;
     }

    public void setCpuPercent(String cpuPercent) {
         this.cpuPercent = cpuPercent;
     }
     public String getCpuPercent() {
         return cpuPercent;
     }

    public void setCpuPeriod(String cpuPeriod) {
         this.cpuPeriod = cpuPeriod;
     }
     public String getCpuPeriod() {
         return cpuPeriod;
     }

    public void setCpuQuota(String cpuQuota) {
         this.cpuQuota = cpuQuota;
     }
     public String getCpuQuota() {
         return cpuQuota;
     }

    public void setCpuRealtimePeriod(String cpuRealtimePeriod) {
         this.cpuRealtimePeriod = cpuRealtimePeriod;
     }
     public String getCpuRealtimePeriod() {
         return cpuRealtimePeriod;
     }

    public void setCpuRealtimeRuntime(String cpuRealtimeRuntime) {
         this.cpuRealtimeRuntime = cpuRealtimeRuntime;
     }
     public String getCpuRealtimeRuntime() {
         return cpuRealtimeRuntime;
     }

    public void setCpuSet(String cpuSet) {
         this.cpuSet = cpuSet;
     }
     public String getCpuSet() {
         return cpuSet;
     }

    public void setCpuSetMems(String cpuSetMems) {
         this.cpuSetMems = cpuSetMems;
     }
     public String getCpuSetMems() {
         return cpuSetMems;
     }

    public void setCpuShares(String cpuShares) {
         this.cpuShares = cpuShares;
     }
     public String getCpuShares() {
         return cpuShares;
     }

    public void setCreateIndex(String createIndex) {
         this.createIndex = createIndex;
     }
     public String getCreateIndex() {
         return createIndex;
     }

    public void setCreated(String created) {
         this.created = created;
     }
     public String getCreated() {
         return created;
     }

    public void setDeploymentUnitUuid(String deploymentUnitUuid) {
         this.deploymentUnitUuid = deploymentUnitUuid;
     }
     public String getDeploymentUnitUuid() {
         return deploymentUnitUuid;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setDiskQuota(String diskQuota) {
         this.diskQuota = diskQuota;
     }
     public String getDiskQuota() {
         return diskQuota;
     }

    public void setDomainName(String domainName) {
         this.domainName = domainName;
     }
     public String getDomainName() {
         return domainName;
     }

    public void setExternalId(String externalId) {
         this.externalId = externalId;
     }
     public String getExternalId() {
         return externalId;
     }

    public void setFirstRunning(String firstRunning) {
         this.firstRunning = firstRunning;
     }
     public String getFirstRunning() {
         return firstRunning;
     }

    public void setHealthInterval(String healthInterval) {
         this.healthInterval = healthInterval;
     }
     public String getHealthInterval() {
         return healthInterval;
     }

    public void setHealthRetries(String healthRetries) {
         this.healthRetries = healthRetries;
     }
     public String getHealthRetries() {
         return healthRetries;
     }

    public void setHealthState(String healthState) {
         this.healthState = healthState;
     }
     public String getHealthState() {
         return healthState;
     }

    public void setHealthTimeout(String healthTimeout) {
         this.healthTimeout = healthTimeout;
     }
     public String getHealthTimeout() {
         return healthTimeout;
     }

    public void setHostname(String hostname) {
         this.hostname = hostname;
     }
     public String getHostname() {
         return hostname;
     }

    public void setIoMaximumBandwidth(String ioMaximumBandwidth) {
         this.ioMaximumBandwidth = ioMaximumBandwidth;
     }
     public String getIoMaximumBandwidth() {
         return ioMaximumBandwidth;
     }

    public void setIoMaximumIOps(String ioMaximumIOps) {
         this.ioMaximumIOps = ioMaximumIOps;
     }
     public String getIoMaximumIOps() {
         return ioMaximumIOps;
     }

    public void setIp(String ip) {
         this.ip = ip;
     }
     public String getIp() {
         return ip;
     }

    public void setIp6(String ip6) {
         this.ip6 = ip6;
     }
     public String getIp6() {
         return ip6;
     }

    public void setIpcMode(String ipcMode) {
         this.ipcMode = ipcMode;
     }
     public String getIpcMode() {
         return ipcMode;
     }

    public void setIsolation(String isolation) {
         this.isolation = isolation;
     }
     public String getIsolation() {
         return isolation;
     }

    public void setKernelMemory(String kernelMemory) {
         this.kernelMemory = kernelMemory;
     }
     public String getKernelMemory() {
         return kernelMemory;
     }

    public void setMemory(String memory) {
         this.memory = memory;
     }
     public String getMemory() {
         return memory;
     }

    public void setMemoryMb(String memoryMb) {
         this.memoryMb = memoryMb;
     }
     public String getMemoryMb() {
         return memoryMb;
     }

    public void setMemoryReservation(String memoryReservation) {
         this.memoryReservation = memoryReservation;
     }
     public String getMemoryReservation() {
         return memoryReservation;
     }

    public void setMemorySwap(String memorySwap) {
         this.memorySwap = memorySwap;
     }
     public String getMemorySwap() {
         return memorySwap;
     }

    public void setMemorySwappiness(String memorySwappiness) {
         this.memorySwappiness = memorySwappiness;
     }
     public String getMemorySwappiness() {
         return memorySwappiness;
     }

    public void setMilliCpuReservation(String milliCpuReservation) {
         this.milliCpuReservation = milliCpuReservation;
     }
     public String getMilliCpuReservation() {
         return milliCpuReservation;
     }

    public void setOomScoreAdj(String oomScoreAdj) {
         this.oomScoreAdj = oomScoreAdj;
     }
     public String getOomScoreAdj() {
         return oomScoreAdj;
     }

    public void setPidMode(String pidMode) {
         this.pidMode = pidMode;
     }
     public String getPidMode() {
         return pidMode;
     }

    public void setPidsLimit(String pidsLimit) {
         this.pidsLimit = pidsLimit;
     }
     public String getPidsLimit() {
         return pidsLimit;
     }

    public void setRemoved(String removed) {
         this.removed = removed;
     }
     public String getRemoved() {
         return removed;
     }

    public void setRequestedIpAddress(String requestedIpAddress) {
         this.requestedIpAddress = requestedIpAddress;
     }
     public String getRequestedIpAddress() {
         return requestedIpAddress;
     }

    public void setShmSize(String shmSize) {
         this.shmSize = shmSize;
     }
     public String getShmSize() {
         return shmSize;
     }

    public void setStartCount(String startCount) {
         this.startCount = startCount;
     }
     public String getStartCount() {
         return startCount;
     }

    public void setStopSignal(String stopSignal) {
         this.stopSignal = stopSignal;
     }
     public String getStopSignal() {
         return stopSignal;
     }

    public void setStopTimeout(String stopTimeout) {
         this.stopTimeout = stopTimeout;
     }
     public String getStopTimeout() {
         return stopTimeout;
     }

    public void setUser(String user) {
         this.user = user;
     }
     public String getUser() {
         return user;
     }

    public void setUserdata(String userdata) {
         this.userdata = userdata;
     }
     public String getUserdata() {
         return userdata;
     }

    public void setUsernsMode(String usernsMode) {
         this.usernsMode = usernsMode;
     }
     public String getUsernsMode() {
         return usernsMode;
     }

    public void setUts(String uts) {
         this.uts = uts;
     }
     public String getUts() {
         return uts;
     }

    public void setUuid(String uuid) {
         this.uuid = uuid;
     }
     public String getUuid() {
         return uuid;
     }

    public void setVolumeDriver(String volumeDriver) {
         this.volumeDriver = volumeDriver;
     }
     public String getVolumeDriver() {
         return volumeDriver;
     }

    public void setWorkingDir(String workingDir) {
         this.workingDir = workingDir;
     }
     public String getWorkingDir() {
         return workingDir;
     }

    public void setNetworkLaunchConfig(String networkLaunchConfig) {
         this.networkLaunchConfig = networkLaunchConfig;
     }
     public String getNetworkLaunchConfig() {
         return networkLaunchConfig;
     }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }
}