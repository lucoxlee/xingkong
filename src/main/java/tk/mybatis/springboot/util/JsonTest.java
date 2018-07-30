package tk.mybatis.springboot.util;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.ImmutableList;
import tk.mybatis.springboot.model.rancher.CreateServiceBean;
import tk.mybatis.springboot.model.rancher.LaunchConfig;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: yule
 * @Description:
 * @Date: Created in 17:43 2018/7/26
 */
public class JsonTest {
    public static void main(String[] args) {
        //生成参数
        CreateServiceBean createServiceBean = new CreateServiceBean();
        createServiceBean.setScale(1);
        createServiceBean.setName("test3");
        createServiceBean.setAssignServiceIpAddress(false);
        createServiceBean.setStartOnCreate(true);
        createServiceBean.setType("service");
        createServiceBean.setStackId("1st5");

        LaunchConfig launchconfig = new LaunchConfig();
        launchconfig.setInstanceTriggeredStop("stop");
        launchconfig.setKind("container");
        launchconfig.setNetworkMode("managed");
        launchconfig.setPrivileged(false);
        launchconfig.setPublishAllPorts(false);
        launchconfig.setReadOnly(false);
        launchconfig.setRunInit(false);
        launchconfig.setStartOnCreate(true);
        launchconfig.setStdinOpen(true);
        launchconfig.setTty(true);
        launchconfig.setPorts(ImmutableList.of("3333:22/tcp","3334:22/tcp"));
        launchconfig.setVcpu(1);
        launchconfig.setDrainTimeoutMs(0);
        launchconfig.setType("launchConfig");
        HashMap label=new HashMap();
        label.put("io.rancher.container.pull_image","always");
        launchconfig.setLabels(label);
        HashMap restartpolicy=new HashMap();
        restartpolicy.put("name","always");
        launchconfig.setRestartPolicy(restartpolicy);
        launchconfig.setImageUuid("docker:alpine");

        createServiceBean.setLaunchConfig(launchconfig);

        System.out.println(JSONUtil.toJsonPrettyStr(createServiceBean));

    }
}
