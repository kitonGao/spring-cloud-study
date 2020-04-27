package com.study.hystrix.filter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: spring-cloud-study
 * @description:  缓存使用过程中，每次使用缓存的请求前后对HystrixRequestContext进行初始化和关闭。
 *      否则会出现java.lang.IllegalStateException: Request caching is not available. Maybe you need to initialize the HystrixRequestContext?
 * @author: gaojme
 * @create: 2020-04-27 14:21
 */
@Component
@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class HystrixRequestContextFilter implements Filter{


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            chain.doFilter(request, response);
        }finally {
            context.close();
        }


    }


}
