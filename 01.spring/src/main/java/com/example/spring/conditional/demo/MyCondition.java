package com.example.spring.conditional.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Program:     com.example.spring.conditional.demo <br/>
 * ClassName:   MyCondition <br/>
 * Description: 自定义条件 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-10 11:17 <br/>
 */
public class MyCondition implements Condition{
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String property = context.getEnvironment().getProperty("os.name");
        //return property != null && property.equals("Window"); //相等的时候就不会添加到容器
        return property != null && property.contains("Window");
    }
}
