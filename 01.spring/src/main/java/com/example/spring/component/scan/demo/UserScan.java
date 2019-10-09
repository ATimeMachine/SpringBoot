package com.example.spring.component.scan.demo;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Program:     com.example.spring.component.scan.demo <br/>
 * ClassName:   UserScan <br/>
 * Description: 扫描的测试类 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-09 19:00 <br/>
 */
@Data
@ToString
@Component
public class UserScan {
    private String userName;
    private Integer age;
}
