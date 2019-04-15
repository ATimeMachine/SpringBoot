package com.example.springboot.properties.Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Program:     com.example.springboot.properties.Thread <br/>
 * ClassName:   TheadCread <br/>
 * Description:  <br/>
 * Author:      陈建 <br/>
 * Create:      2019-04-15 18:04 <br/>
 */
@Service
public class TheadCreate {
    @Autowired
    CallJasper callJasper;

    public void create() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {callJasper.a();callJasper.b();},String.valueOf(i));
            threads.add(thread);
        }
        for (int i = 5; i < 10; i++) {
            Thread thread = new Thread(() -> callJasper.b(),String.valueOf(i));
            threads.add(thread);
        }
        for (int i = 10; i < 15; i++) {
            int j = i;
            Thread thread = new Thread(() -> callJasper.c(j),String.valueOf(i));
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

}
