package com.example.spring.profile;

import com.example.spring.profile.demo.UserProfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Program:     com.example.spring.profile <br/>
 * ClassName:   ProfileApplication <br/>
 * Description: 环境注册组件 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-10 11:47 <br/>
 */
@SpringBootApplication
public class ProfileApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProfileApplication.class, args);
        boolean userProfile = context.containsBean("userProfile");
        if (userProfile){
            UserProfile bean = context.getBean(UserProfile.class);
            System.out.println(bean);
        }
        System.out.println(userProfile);
    }
}
