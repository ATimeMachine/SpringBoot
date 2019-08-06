package com.example.springboot.properties.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

@Service("RateLimitClient")
public class RateLimitClient {
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Qualifier("rateLimitUseIncr")
	@Resource
	private RedisScript<Long> rateLimitUseIncr;

	private String getKey(String key) {
		return Constants.RATE_LIMIT_KEY + key;
	}

    /**
     * 每秒只能访问5次
     * @param key key
     * @return
     * @throws Exception
     */
	public Token rateLimitUseIncr(String key) throws Exception{
		//频率
		int rate = 5;
        return this.rateLimitUseIncr(key, rate);
	}

    /**
     *
     * @param key key
     * @param rate //频率
     * @return
     */
    public Token rateLimitUseIncr(String key, Integer rate) throws Exception {
        Token token = Token.FAILED;
        if (key.equals(Constants.JASPER_KEY)){
            rate = 5;
        }
        Long execute = stringRedisTemplate.execute(rateLimitUseIncr, Collections.singletonList(getKey(key)));
        if (execute != null && execute <= rate) {
            token = Token.SUCCESS;
        }
        return token;
    }

}
