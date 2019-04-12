package com.example.springboot.properties.Thread;

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
public class CallJasper {
    public static ArrayBlockingQueue<CountDownLatch> queue = new ArrayBlockingQueue<>(50);


    public List<Thread> creadThread() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(this::a,String.valueOf(i));
        }
        for (int i = 6; i < 10; i++) {
            Thread thread = new Thread(this::b,String.valueOf(i));
        }
        for (int i = 11; i < 15; i++) {
            int j = i;
            Thread thread = new Thread(() -> c(j),String.valueOf(i));
        }
        return threads;
    }

    public void startThread(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    @CallJasperThreadManager()
    private void a() {
        System.out.println("a");
    }

    @CallJasperThreadManager()
    private String b() {
        System.out.println("b");
        return "b";
    }

    @CallJasperThreadManager()
    public void c(int c) {
        System.out.println( "c" + c);
    }
}
