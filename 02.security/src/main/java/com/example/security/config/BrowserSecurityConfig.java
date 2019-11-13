package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() //  HTTP页面表单方式，有提示错误，会跳转页面 （默认）
                //http.httpBasic() // HTTP Basic方式 弹窗模式，不会跳转页面
                //.loginPage("/login.html") // 登录跳转 URL
                //动态处理，接口访问，返回错误信息，页面访问，跳转到登录页
                .loginPage("/authentication/require")
                .loginProcessingUrl("/login") //处理表单登录 URL,处理登陆验证的url
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/authentication/require","/login.html").permitAll() //登录跳转 URL 无需认证
                .anyRequest()  // 所有请求
                .authenticated()// 都需要认证
                .and().csrf().disable()
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}