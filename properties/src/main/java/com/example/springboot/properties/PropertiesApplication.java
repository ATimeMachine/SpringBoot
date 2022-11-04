package com.example.springboot.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * 挎包自动注入，需要添加扫描，详细见{@link com.example.springboot.properties.web.UserController}
 * {@link com.example.springboot.properties.config.SpringConfig}
 * --原理，想办法加入到spring 容器中即可
 */
//@ComponentScan(value = {"com.example.springboot.scheduling","com.example.springboot.properties"})
public class PropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertiesApplication.class, args);
		System.out.println("当前分配内存大小:" + Runtime.getRuntime().totalMemory() / (1 * 1024 * 1024) + " M");
		System.out.println("当前可用内存大小:"+ Runtime.getRuntime().freeMemory() / (1 * 1024 * 1024) + " M");
		System.out.println("可分配总内存大小:"+ Runtime.getRuntime().maxMemory() / (1 * 1024 * 1024) + " M");
		System.out.println("当前服务核心数量:" + Runtime.getRuntime().availableProcessors());

		System.out.println("第一次提交");
		System.out.println("第二次提交");
		System.out.println("第三次提交");
		System.out.println("第4次提交");

	}
}
