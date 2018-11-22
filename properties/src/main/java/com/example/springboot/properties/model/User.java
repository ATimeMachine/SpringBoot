package com.example.springboot.properties.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * FileName: User
 * Author:   SunEee
 * Date:     2018/6/25 14:01
 * Description: 用户的bean
 */
@Component //方便其他模块通过@Autowired注入使用
//@ConfigurationProperties(prefix = "com.user") //加了前缀，可以去掉@Value
@PropertySource(value = "classpath:my.properties")
@ConfigurationProperties(prefix = "com.user")
public class User {

    @Value("${com.my.userName}")
    private String userName;
    @Value("${com.my.age}")
    private int age;

    //这里去掉了value
    private String address;

    //这里去掉value,并且注入了一个对象
    private Address defaultAddress;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Address defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}
