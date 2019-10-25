package com.example.security.data;

import lombok.Data;

/**
 * Program:     com.example.security.data <br/>
 * ClassName:   MyUser <br/>
 * Description: 模拟数据库数据 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-25 18:07 <br/>
 */
@Data
public class MyUser {
    private String userName;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}
