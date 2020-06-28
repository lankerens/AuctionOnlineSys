package com.lankeren.auction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lankeren
 * @ClassName MyWebConfig
 * @Deacription:
 * @create: 2020-06-22 11:04
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    /**
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/picFiles/**").addResourceLocations("file:E:/JavaWorkPlace/School/auctiononlinesys/src/main/resources/static/imgs/goods/");
    }

}
