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

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.springboot.model.rancher.CreateServiceBean;
import tk.mybatis.springboot.model.rancher.LaunchConfig;

import java.util.HashMap;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@RestController
@RequestMapping("/rancher")
public class RancherController {


    @RequestMapping(value = "/add")
    public JSONObject add() {
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


        String result = HttpRequest.post("http://106.15.58.63:8080/v2-beta/projects/1a5/services")
                .header("23B52EF320D702860BC5", "FV7FxAx5rnQ32zDCsAeCpoTaQG3YQZqWJiRhQqVS")
                .body(JSONUtil.toJsonPrettyStr(createServiceBean))
                .timeout(20000)
                .execute().body();

        return null;
    }

}
