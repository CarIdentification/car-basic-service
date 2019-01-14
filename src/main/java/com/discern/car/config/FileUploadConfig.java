package com.discern.car.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * Created by Keben on 2019-01-03.
 */

@Configuration
public class FileUploadConfig {

    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${img.location}")
    private String location;


    /**
     * 文件上传配置
     *
     * @return MultipartConfigElement
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(
            @Value("${multipart.maxFileSize}") String maxFileSize,
            @Value("${multipart.maxRequestSize}") String maxRequestSize) {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大
        factory.setMaxFileSize(maxFileSize);
        // 设置总上传数据总大小
        factory.setMaxRequestSize(maxRequestSize);
        return factory.createMultipartConfig();
    }

}
