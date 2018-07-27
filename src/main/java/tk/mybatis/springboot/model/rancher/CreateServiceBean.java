/**
  * Copyright 2018 bejson.com 
  */
package tk.mybatis.springboot.model.rancher;
import java.util.List;

/**
 * Auto-generated: 2018-07-26 17:47:58
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class CreateServiceBean {

    private int scale;
    private boolean assignServiceIpAddress;
    private boolean startOnCreate;
    private String type;
    private String stackId;
    private LaunchConfig launchConfig;
    private List<String> secondaryLaunchConfigs;
    private String name;
    private String createIndex;
    private String created;
    private String description;
    private String externalId;
    private String healthState;
    private String kind;
    private String removed;
    private String selectorContainer;
    private String selectorLink;
    private String uuid;
    private String vip;
    private String fqdn;

    private long createdTS;
    private int currentScale;
    private String baseType;
    private List<String> instanceIds;
    private Links links;
    private String id;
    private String state;
    private List<PublicEndpoints> publicEndpoints;
    private String accountId;
    private boolean system;
    private String transitioning;
    private Actions actions;

    public void setScale(int scale) {
         this.scale = scale;
     }
     public int getScale() {
         return scale;
     }

    public void setAssignServiceIpAddress(boolean assignServiceIpAddress) {
         this.assignServiceIpAddress = assignServiceIpAddress;
     }
     public boolean getAssignServiceIpAddress() {
         return assignServiceIpAddress;
     }

    public void setStartOnCreate(boolean startOnCreate) {
         this.startOnCreate = startOnCreate;
     }
     public boolean getStartOnCreate() {
         return startOnCreate;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setStackId(String stackId) {
         this.stackId = stackId;
     }
     public String getStackId() {
         return stackId;
     }

    public void setLaunchConfig(LaunchConfig launchConfig) {
         this.launchConfig = launchConfig;
     }
     public LaunchConfig getLaunchConfig() {
         return launchConfig;
     }

    public void setSecondaryLaunchConfigs(List<String> secondaryLaunchConfigs) {
         this.secondaryLaunchConfigs = secondaryLaunchConfigs;
     }
     public List<String> getSecondaryLaunchConfigs() {
         return secondaryLaunchConfigs;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
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

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setExternalId(String externalId) {
         this.externalId = externalId;
     }
     public String getExternalId() {
         return externalId;
     }

    public void setHealthState(String healthState) {
         this.healthState = healthState;
     }
     public String getHealthState() {
         return healthState;
     }

    public void setKind(String kind) {
         this.kind = kind;
     }
     public String getKind() {
         return kind;
     }

    public void setRemoved(String removed) {
         this.removed = removed;
     }
     public String getRemoved() {
         return removed;
     }

    public void setSelectorContainer(String selectorContainer) {
         this.selectorContainer = selectorContainer;
     }
     public String getSelectorContainer() {
         return selectorContainer;
     }

    public void setSelectorLink(String selectorLink) {
         this.selectorLink = selectorLink;
     }
     public String getSelectorLink() {
         return selectorLink;
     }

    public void setUuid(String uuid) {
         this.uuid = uuid;
     }
     public String getUuid() {
         return uuid;
     }

    public void setVip(String vip) {
         this.vip = vip;
     }
     public String getVip() {
         return vip;
     }

    public void setFqdn(String fqdn) {
         this.fqdn = fqdn;
     }
     public String getFqdn() {
         return fqdn;
     }

    public boolean isAssignServiceIpAddress() {
        return assignServiceIpAddress;
    }

    public boolean isStartOnCreate() {
        return startOnCreate;
    }

    public long getCreatedTS() {
        return createdTS;
    }

    public void setCreatedTS(long createdTS) {
        this.createdTS = createdTS;
    }

    public int getCurrentScale() {
        return currentScale;
    }

    public void setCurrentScale(int currentScale) {
        this.currentScale = currentScale;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public List<String> getInstanceIds() {
        return instanceIds;
    }

    public void setInstanceIds(List<String> instanceIds) {
        this.instanceIds = instanceIds;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PublicEndpoints> getPublicEndpoints() {
        return publicEndpoints;
    }

    public void setPublicEndpoints(List<PublicEndpoints> publicEndpoints) {
        this.publicEndpoints = publicEndpoints;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public String getTransitioning() {
        return transitioning;
    }

    public void setTransitioning(String transitioning) {
        this.transitioning = transitioning;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }
}