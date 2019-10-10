package com.example.spring.profile.demo;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Program:     com.example.spring.bean <br/>
 * ClassName:   User <br/>
 * Description: user测试类 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-09 18:25 <br/>
 */

/**
 * Profile 根据环境文件而加载，如果 spring.profiles.active=dev，且@Profile("test")，这不加载UserProfile
 */
@Data
@ToString
@Component
@Profile("test")
public class UserProfile {

    @Value("${user.userName}")
    private String userName;

    /**
     * #{} 会将String类型转换成Integer类型
     */
    @Value("#{${user.age}}")
    private Integer age;
}
