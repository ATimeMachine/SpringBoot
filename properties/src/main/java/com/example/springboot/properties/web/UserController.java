package com.example.springboot.properties.web;

import com.example.springboot.properties.Thread.CallJasper;
import com.example.springboot.properties.Thread.TheadCreate;
import com.example.springboot.properties.model.User;
import com.example.springboot.scheduling.service.ITest;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;


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

    //挎包注入
    @Autowired
    ITest test;

    @Autowired
    TheadCreate threadCreate;

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("name") String name) {
        System.out.println(name + "----" + user.getUserName());
        user.setUserName(test.getString());
        return user;
    }

    @RequestMapping(value = "/properties", method = RequestMethod.GET)
    @ResponseBody
    public String getProperties(String properties) {
        System.out.println(properties);
        return environment.getProperty(properties);
    }

    @RequestMapping(value = "/thead", method = RequestMethod.GET)
    @ResponseBody
    public String thead() {
        threadCreate.create();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CountDownLatch countDownLatch = CallJasper.queue.poll();
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        return "1234";
    }
}
