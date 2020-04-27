package com.study.feign.service.impl;

import com.study.feign.domain.CommonResult;
import com.study.feign.domain.User;
import com.study.feign.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: gaojme
 * @create: 2020-04-27 18:19
 */
@Component
public class UserFallbackService implements UserService {


    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User user = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(user);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User user = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(user);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("调用失败，服务被降级", 500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult("调用失败, 服务被降级", 500);
    }

}
