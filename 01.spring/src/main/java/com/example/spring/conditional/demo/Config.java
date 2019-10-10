package com.example.spring.conditional.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Program:     com.example.spring.conditional.demo <br/>
 * ClassName:   Config <br/>
 * Description: 配置 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-10 11:19 <br/>
 */
@Configuration
public class Config {

    @Bean
    @Conditional(value = MyCondition.class)
    public UserConditional userConditional() {
        return new UserConditional("条件", 20);
    }
}
