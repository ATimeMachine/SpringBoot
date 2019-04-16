package com.example.springboot.properties.Thread;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Program:     com.sohan.sever.util.sms <br/>
 * ClassName:   CallJasper <br/>
 * Description:  <br/>
 * Author:      陈建 <br/>
 * Create:      2019-04-12 18:17 <br/>
 */
@Component
public class CallJasper {



    @CallJasperThreadManager
    public void a(){
        try {
            long start = System.currentTimeMillis();
            Thread.sleep(100);
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + ":a," + "睡眠时间：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @CallJasperThreadManager
    public String b(){
        try {
            long start = System.currentTimeMillis();
            Thread.sleep(100);
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + ":b+++b," + "睡眠时间：" + (end - start));
            return "b";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @CallJasperThreadManager
    public void c(int c){
        try {
            long start = System.currentTimeMillis();
            Thread.sleep(100);
            long end = System.currentTimeMillis();
            System.out.println( Thread.currentThread().getName() + ":c-" + c + ",睡眠时间：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
