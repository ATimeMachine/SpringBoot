package com.example.spring.conditional.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Program:     com.example.spring.bean <br/>
 * ClassName:   User <br/>
 * Description: user测试类 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-09 18:25 <br/>
 */
@Data
@ToString
@AllArgsConstructor
public class UserConditional {

    private String userName;

    private Integer age;
}
