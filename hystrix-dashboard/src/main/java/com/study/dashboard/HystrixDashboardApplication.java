package com.study.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: gaojme
 * @create: 2020-04-27 17:32
 */
@EnableHystrixDashboard //开启监控功能
@SpringBootApplication
@EnableDiscoveryClient
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }


}
