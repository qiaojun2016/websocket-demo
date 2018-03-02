package com.example.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
        /**
         * 无论用户是localhost:8080/ 还是 localhost:/login
         * 都要打开 templates/login.html 这个页面
         */
        registry.addViewController("/login").setViewName("login");
        // registry.addViewController("/").setViewName("forward:/chat.html");
        registry.addRedirectViewController("/", "/chat.html");

        registry.addViewController("/testlogin/login").setViewName("/testlogin/login");
        registry.addViewController("/testlogin/login.htm").setViewName("/testlogin/login");
        registry.addViewController("/testlogin/login.html").setViewName("/testlogin/login");
        // 仅仅针对 templates里面的设置？
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
        registry.addResourceHandler("/dictaphone/**").addResourceLocations("classpath:/dictaphone/");
        super.addResourceHandlers(registry);
    }

}
