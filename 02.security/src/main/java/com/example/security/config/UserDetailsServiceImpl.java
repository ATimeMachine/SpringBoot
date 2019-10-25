package com.example.security.config;

import com.example.security.data.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Program:     com.example.security.config <br/>
 * ClassName:   MyUserDetailService <br/>
 * Description: 自定义用户类 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-10-25 18:11 <br/>
 */
@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //用userName查询数据库,下面直接模拟放回的数据
        MyUser myUser = new MyUser();
        myUser.setUserName(username);
        myUser.setPassword(passwordEncoder.encode("123456"));
        // 输出加密后的密码
        System.out.println(myUser.getPassword());
        //查询出数据后，直接封装
        return new User(myUser.getUserName(), myUser.getPassword(), myUser.isEnabled(), myUser.isAccountNonExpired(),
                myUser.isCredentialsNonExpired(), myUser.isAccountNonLocked(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
