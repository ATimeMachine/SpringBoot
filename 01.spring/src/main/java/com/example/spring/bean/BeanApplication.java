package com.example.spring.bean;

import com.example.spring.bean.demo.User;
import com.example.spring.bean.demo.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Program:     com.example.spring.bean.demo <br/>
 * ClassName:   BeanApplication <br/>
 * Description: bean的测试类 <br/>
 * @author:      陈建 <br/>
 * Create:      2019-10-09 18:33 <br/>
 */
@SpringBootApplication
public class BeanApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BeanApplication.class, args);
        // 返回 IOC 容器，使用注解配置，传入配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
