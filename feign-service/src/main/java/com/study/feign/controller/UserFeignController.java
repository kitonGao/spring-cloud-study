package com.study.feign.controller;

import com.study.feign.domain.CommonResult;
import com.study.feign.domain.User;
import com.study.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: gaojme
 * @create: 2020-04-27 18:22
 */
@RestController
@RequestMapping(value = "/user")
public class UserFeignController {

    @Autowired
    private UserService userService;



    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable(value = "id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam(value = "username") String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable(value = "id") Long id) {
        return userService.delete(id);
    }


}
