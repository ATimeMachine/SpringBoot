package com.example.springboot.properties.web;

import com.example.springboot.properties.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("name") String name) {
        System.out.println(name + "----" + user.getUserName());

        return user;
    }
}
