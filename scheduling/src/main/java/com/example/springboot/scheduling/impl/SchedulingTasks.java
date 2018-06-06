package com.example.springboot.scheduling.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * FileName: SchedulingTasks
 * Author:   SunEee
 * Date:     2018/6/6 15:16
 * Description: 定时任务
 */
@Component
public class SchedulingTasks {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" +LocalTime.now());
    }
}
