package com.example.springboot.properties.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Program:     com.example.springboot.properties.config
 * <p>
 * ClassName:    SpringConfig
 * <p>
 * Description: Spring设置类
 * <p>
 * Author:      Administrator
 * <p>
 * Create:      2018-11-23 13:41
 **/
@Configuration
//扫描外部包
@ComponentScan("com.example.springboot.scheduling")
public class SpringConfig {

}
