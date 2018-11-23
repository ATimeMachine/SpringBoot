package com.example.springboot.scheduling.service;

import org.springframework.stereotype.Service;

/**
 * Program:     com.example.springboot.scheduling.service
 * <p>
 * ClassName:    Akdkdlaldlddjdj
 * <p>
 * Description:
 * <p>
 * Author:      Administrator
 * <p>
 * Create:      2018-11-23 10:46
 **/
@Service
/**
 * 接口和实现类的名字一样，一样通过Autowired注入,详细见{@link com.example.springboot.properties.web.UserController}
 */
public class DifferentNameForInterfaceImpl implements ITest{
    @Override
    public String getString() {
        return "yeyeyeyeeyeyeeyeyey";
    }
}
