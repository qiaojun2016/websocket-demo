package com.example.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 设置 controller暴露出这些 模板。
     * 或者 为模板 写一个 controller也行。
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
        //registry.addRedirectViewController("/", "/chat.html");

        // 对于访问的 静态页面，一般放到static 都要 urlPath 这样系统才会 知道要给你显示哪个页面。
        // 如果你仅仅在static里面写了一个页面，而为他写对应的 url 路径。那你

        //
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
