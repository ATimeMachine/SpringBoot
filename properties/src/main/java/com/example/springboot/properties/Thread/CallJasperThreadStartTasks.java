package com.example.springboot.properties.Thread;

import com.example.springboot.properties.redis.Constants;
import com.example.springboot.properties.redis.RateLimitClient;
import com.example.springboot.properties.redis.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Program:     com.sohan.sever.thread <br/>
 * ClassName:   CallJasperThreadStart <br/>
 * Description: 定时检查是否消费第一个线程 <br/>
 * Author:      陈建 <br/>
 * Create:      2019-04-16 15:32 <br/>
 */
@Component
public class CallJasperThreadStartTasks {

    //排队最大容量
    public final static ArrayBlockingQueue<CountDownLatch> queue = new ArrayBlockingQueue<>(20000);

    private static final Logger logger = LoggerFactory.getLogger(CallJasperThreadStartTasks.class);

    @Autowired
    RateLimitClient rateLimitClient;

    private static final int RANDOM_SEED = 200;
    private Random randomInstance = new Random();

    private long start = System.currentTimeMillis();

    private int cout = 0;
    // 随机打印，数越小打印得越多
    private static final int PRINT_FREQUENCY = 50;

    @Scheduled(fixedRate = 200)
    @Async
    public void startFirstCountDownLatch() {
        try {
            ArrayBlockingQueue<CountDownLatch> queue = CallJasperThreadStartTasks.queue;
            if (queue.size() == 0) {
                return;
            }
            try {
                Token token = rateLimitClient.rateLimitUseIncr(Constants.JASPER_KEY);
                if (token.isSuccess()) {
                    this.doAction(queue);
                    cout++;
                }
                long end = System.currentTimeMillis();
                long time = end - start;
                if (time > 960) {
                    if (cout > 5) {
                        logger.error("时间：" + time + ";次数：" + cout);
                    }
                    start = System.currentTimeMillis();
                    cout = 0;
                }
            } catch (Exception e) {
                logger.error("队列执行异常", e);
                this.doAction(queue);
            }
        } catch (Exception e) {
            logger.error("队列执行异常", e);
        }
    }

    private void doAction(ArrayBlockingQueue<CountDownLatch> queue) {
        CountDownLatch poll = queue.poll();
        if (null != poll) {
            poll.countDown();
            boolean doLog = randomInstance.nextInt(RANDOM_SEED) % PRINT_FREQUENCY == 0;
            if (doLog) {
                logger.error("队列情况：" + queue.size());
            }
        }
    }
}
