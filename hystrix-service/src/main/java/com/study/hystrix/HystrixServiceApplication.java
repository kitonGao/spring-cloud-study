package com.study.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: gaojme
 * @create: 2020-04-27 14:13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker   //开启断路器功能
public class HystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixServiceApplication.class, args);
    }


}
