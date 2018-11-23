package com.example.springboot.properties.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;

import javax.annotation.PostConstruct;
  
/**  
 * 加载动态配置信息  
 *   
 * @author liaokailin  
 * @version $Id: DynamicConfig.java, v 0.1 2015年10月2日 下午11:12:44 liaokailin Exp $  
 */  
@Configuration
public class DynamicConfig {  
    public static final String DYNAMIC_CONFIG_NAME = "dynamic_config";
  
    @Autowired
    AbstractEnvironment environment;
  
    @PostConstruct  
    public void init() {  
        environment.getPropertySources().addFirst(new DynamicPropertySource(DYNAMIC_CONFIG_NAME));  
    }  
  
} 