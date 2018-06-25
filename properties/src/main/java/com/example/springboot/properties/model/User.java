package com.example.springboot.properties.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * FileName: User
 * Author:   SunEee
 * Date:     2018/6/25 14:01
 * Description: 用户的bean
 */
@Component
@ConfigurationProperties(prefix = "com.user") //去掉@Value
public class User {

    @Value("${com.my.userName}")
    private String userName;
    @Value("${com.my.age}")
    private int age;

    private String address;

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
