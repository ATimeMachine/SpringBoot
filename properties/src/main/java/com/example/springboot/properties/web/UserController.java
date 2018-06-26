package com.example.springboot.properties.web;

import com.example.springboot.properties.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;


/**
 * FileName: UserController
 * Author:   SunEee
 * Date:     2018/6/25 14:09
 * Description: 用户页面
 */
@RestController
@RequestMapping("springboot")
public class UserController {

    @Autowired
    User user;

    @Autowired
    Environment environment;//注入获取值

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("name") String name) {
        System.out.println(name + "----" + user.getUserName());

        return user;
    }

    @RequestMapping(value = "/properties", method = RequestMethod.GET)
    @ResponseBody
    public String getProperties(String properties) {
        System.out.println(properties);
        return environment.getProperty(properties);
    }
}
