package com.example.spring.component.scan;

import com.example.spring.component.scan.demo.Confige;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Program:     com.example.spring.component.scan <br/>
 * ClassName:   ScanApplication <br/>
 * Description: 扫描测试类 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-09 18:58 <br/>
 */
public class ScanApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Confige.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}
