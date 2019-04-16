package com.example.springboot.properties.Thread;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Program:     com.sohan.core.util <br/>
 * ClassName:   CallJasperThreadAspect <br/>
 * Description: 调用jasper平台AOP <br/>
 * Author:      陈建 <br/>
 * Create:      2019-04-12 17:44 <br/>
 */
@Aspect
@Component
public class CallJasperThreadAspect {


    private static final Logger logger = LoggerFactory.getLogger(CallJasperThreadAspect.class);
    // 开始时间
    private ThreadLocal<Long> startTime = new ThreadLocal<>();


    @Pointcut("@annotation(com.example.springboot.properties.Thread.CallJasperThreadManager)")
    public void annotationPointCut() {

    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("------------------------------------------------------------");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            ArrayBlockingQueue<CountDownLatch> queue = CallJasper.queue;
            queue.put(countDownLatch);
            countDownLatch.await();
            // 记录方法开始执行的时间
            startTime.set(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @After("annotationPointCut()")
    public void after() {
        // 记录方法执行完成的时间
        try {
            long endTime = System.currentTimeMillis();
            if (startTime.get() != null) {
                long time = endTime - startTime.get();
                if (time < 200) {
                    Thread.sleep(200 - time);
                }
                time = System.currentTimeMillis() - startTime.get();
                System.out.println("执行时间：" + time);
            }
            CountDownLatch countDownLatch = CallJasper.queue.poll();
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (Exception e) {
            logger.error("线程睡眠失败", e);
        }
        startTime.remove();
    }
}
