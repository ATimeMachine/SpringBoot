package com.example.springboot.properties.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.MapPropertySource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DynamicPropertySource extends MapPropertySource {

    private static Logger log = LoggerFactory.getLogger(DynamicPropertySource.class);

    //延迟执行线程池
    private static ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);

    private static Map<String, Object> map = new ConcurrentHashMap<String, Object>(64);

    static {
        //延迟执行线程方法
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                map = dynamicLoadMapInfo();
            }

        }, 1, 10, TimeUnit.SECONDS);
        //scheduled.scheduleAtFixedRate(() -> map = dynamicLoadMapInfo(),1,10,TimeUnit.SECONDS);
    }

    public DynamicPropertySource(String name) {
        super(name, map);
    }

    @Override
    public Object getProperty(String name) {
        return map.get(name);
    }

    //动态获取资源信息  
    private static Map<String, Object> dynamicLoadMapInfo() {
        //通过http或tcp等通信协议获取配置信息  
        return mockMapInfo();
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private static Map<String, Object> mockMapInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        int randomData = new Random().nextInt(100000);
        log.info("random data{};currentTime:{}", randomData, sdf.format(new Date()));
        map.put("dynamic-info", randomData);
        return map;
    }
}  