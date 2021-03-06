package com.discern.car.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 类描述 :
 *
 * @Author JoeyTsai
 * @Time 10/04/2019
 */
public class StaticResourcesConfig implements WebMvcConfigurer {
    private static final Log log = LogFactory.getLog(StaticResourcesConfig.class);

    @Value("${img.location}")
    private String location;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/hzd/pornhub/online").addResourceLocations(location);
    }
}