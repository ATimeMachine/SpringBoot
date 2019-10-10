package com.example.spring.conditional;

import com.example.spring.conditional.demo.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Program:     com.example.spring.conditional <br/>
 * ClassName:   ConditionalApplication <br/>
 * Description: 条件注册 ,比如在测试环境，不需要启动定时器，就不需要将定时器添加到容器里面<br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-10 11:15 <br/>
 */
public class ConditionalApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}
