package com.example.spring.bean.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Program:     com.example.spring.bean <br/>
 * ClassName:   WebConfig <br/>
 * Description:  <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-09 18:28 <br/>
 */
@Configuration
public class WebConfig {

    @Bean
    //@Bean("myUser") Bean名称默认为方法名，我们也可以通过@Bean("myUser")方式来将组件名称指定为myUser
    public User user(){
        return new User("测试bean", 28);
    }

}
