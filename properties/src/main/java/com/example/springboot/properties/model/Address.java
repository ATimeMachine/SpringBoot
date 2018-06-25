package com.example.springboot.properties.model;

/**
 * FileName: Address
 * Author:   SunEee
 * Date:     2018/6/25 14:49
 * Description: 默认地址
 */
public class Address {
    private String country;
    private String province;
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
