package com.example.controller;

import com.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName TestController
 * @Description
 * @create 2019/8/27/0027 16:18
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private DiscoveryClient client;

    @GetMapping(value = "/info")
    public String info(){
        List<ServiceInstance> instances = client.getInstances("eureka-server");
        ServiceInstance instance = instances.get(0);
        String info = "host:"+ instance.getHost() + "service_id:"+instance.getServiceId();
        log.info(info);
        return info;
    }


    @GetMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }



    @GetMapping("/{id:\\d+}")
    public User get(@PathVariable Long id) {
        log.info("获取用户id为 " + id + "的信息");
        return new User(id, "mrbird", "123456");
    }

    @GetMapping
    public List<User> get() {
        List<User> list = new ArrayList<>();
        list.add(new User(1L, "mrbird", "123456"));
        list.add(new User(2L, "scott", "123456"));
        log.info("获取用户信息 " + list);
        return list;
    }

    @PostMapping
    public void add(@RequestBody User user) {
        log.info("新增用户成功 " + user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        log.info("更新用户成功 " + user);
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable Long id) {
        log.info("删除用户成功 " + id);
    }


}
