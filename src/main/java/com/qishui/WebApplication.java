package com.qishui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class WebApplication {

    //程序启动入口
    public static void main(String[] args) {
        multipartConfigElement();
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public static MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大100Mb
        factory.setMaxFileSize(DataSize.ofBytes(100 * 1024 * 1024));
        /// 设置总上传数据总大小500Nb
        factory.setMaxRequestSize(DataSize.ofBytes(500 * 1024 * 1024));

        return factory.createMultipartConfig();
    }

}

