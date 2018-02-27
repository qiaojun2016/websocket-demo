package com.example.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration

public class MvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 设置 controller 暴露出这些 模板
     * 或者 为模板 写一个 controller也行。
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
