package com.study.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: spring-cloud-study
 * @description:
 * @author: gaojme
 * @create: 2020-04-27 10:54
 */
@EnableDiscoveryClient
@SpringBootApplication
public class StudyRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyRibbonApplication.class, args);
    }


}
