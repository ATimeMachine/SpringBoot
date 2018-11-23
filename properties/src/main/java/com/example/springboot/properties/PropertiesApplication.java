package com.example.springboot.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

/**
 * 挎包自动注入，需要添加扫描，详细见{@link com.example.springboot.properties.web.UserController}
 * 原理，加入到spring 容器中即可
 */
@ComponentScan(value = {"com.example.springboot.scheduling","com.example.springboot.properties"})
public class PropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertiesApplication.class, args);
	}
}
