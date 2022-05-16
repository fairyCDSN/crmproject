package com.trkj.crmproject.config;


import com.trkj.crmproject.interceptor.TokenInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private TokenInterceptor tokenInterceptor ;

    public void addInterceptors(InterceptorRegistry registry) {
        log.debug("注册TokenInterceptor");//注册拦截器
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns("/login");//拦截所有路径
    }
}
