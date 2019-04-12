package com.example.springboot.properties.Thread;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

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

    private ThreadLocal<Long> startTime = new ThreadLocal<>(); // 开始时间
    private ThreadLocal<Long> endTime = new ThreadLocal<>(); // 结束时间

    @Pointcut("@annotation(CallJasperThreadManager)")
    public void annotationPointCut() {

    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){

        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            CallJasper.queue.put(countDownLatch);
            countDownLatch.await();
            startTime.set(System.currentTimeMillis());// 记录方法开始执行的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Around("annotationPointCut()")
    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object retmsg = joinPoint.proceed();
        endTime.set(System.currentTimeMillis());// 记录方法执行完成的时间
        if (endTime.get() != null && startTime.get() != null) {
            long time = endTime.get() - startTime.get();
            System.out.println("执行时间：" + time);
        }
        CountDownLatch countDownLatch = CallJasper.queue.poll();
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        return retmsg;
    }

    @After("annotationPointCut()")
    public void after() {
        startTime.remove();
        endTime.remove();
        System.out.println("after方法执行后");
    }
}
