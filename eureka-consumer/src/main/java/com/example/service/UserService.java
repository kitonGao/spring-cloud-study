package com.example.service;

import com.example.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName UserService
 * @Description
 * @create 2019/8/27/0027 17:33
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Service(value = "userService")
public class UserService {

    private Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/info")
    public String getInfo(){
        return this.restTemplate.getForEntity("http://server-provider/info", String.class).getBody();
    }



    @GetMapping(value = "user/{id:\\d+}")
    public User getUser(@PathVariable Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        URI uri = UriComponentsBuilder.fromUriString("http://server-provider/user/{id}")
                .build().expand(params).encode().toUri();

        return this.restTemplate.getForEntity(uri, User.class).getBody();
    }



    /*增加服务熔断*/
    //表示当被调用的方法不可用的时候的回调方法
    /*ignoreExceptions  表示某个异常不触发服务降级*/
    @HystrixCommand(fallbackMethod = "getUserDefault", ignoreExceptions = {NullPointerException.class})
    public User getUserForHystrix(@PathVariable Long id) {
        return restTemplate.getForObject("http://server-provider/user/{id}", User.class, id);
    }

    /**
     * 毁掉方法， 必须和getUser方法的参数和返回值类型一致
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "getUserDefault2")  //如果这个方法也出现错误，再次降级
    public User getUserDefault(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUserName("defaultUser");
        user.setPassWord("123");
        return user;
    }


    /**
     * @param id
     * @param e  可以 在服务降级的方法中使用Throwable对象获取抛出的异常信息
     * @return
     */
    public User getUserDefault2(Long id, Throwable e){
        User user = new User();
        user.setId(-2L);
        user.setUserName("defaultUser2");
        user.setPassWord("123");
        return user;
    }



    @GetMapping(value = "user")
    public List<User> getUsers(){
        return this.restTemplate.getForObject("http://server-provider/user", List.class);
    }


    @GetMapping(value = "user/add")
    public String addUser(){
        User user = new User(1L, "mibird", "123");
        HttpStatus status = this.restTemplate.postForEntity("http://server-provider/user", user, null).getStatusCode();
        if (status.is2xxSuccessful()) {
            return "新增用户成功";
        } else  {
            return "新增用户失败";
        }
    }


    @GetMapping(value = "user/update")
    public void updateUser(){
        User user = new User(1L, "mrbird", "123");
        this.restTemplate.put("http://server-provider/user", user);

    }


    @GetMapping(value = "user/delete/{id:\\d+}")
    public void deleteUser(@PathVariable Long id) {
        this.restTemplate.delete("http://servier-provider/user/{1}",id);
    }






}
