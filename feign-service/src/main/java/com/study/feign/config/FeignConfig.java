package com.study.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-cloud-study
 * @description:  配置Feign打印最详细的Http请求日志信息
 * @author: gaojme
 * @create: 2020-04-27 18:13
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
