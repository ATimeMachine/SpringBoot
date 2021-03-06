package com.example.springboot.properties.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;


@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	
	    
	    @Override
	    @Bean
	    public KeyGenerator keyGenerator() {
	        return new KeyGenerator() {
	            @Override
	            public Object generate(Object target, Method method, Object... params) {
	                StringBuilder sb = new StringBuilder();
	                sb.append(target.getClass().getName());
	                sb.append(method.getName());
	                for (Object obj : params) {
	                    sb.append(obj.toString());
	                }
	                return sb.toString();
	            }
	        };
	    }

	    @Bean
	    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
	        StringRedisTemplate template = new StringRedisTemplate(factory);
	        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
	        ObjectMapper om = new ObjectMapper();
	        om.setVisibility(com.fasterxml.jackson.annotation.PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	        jackson2JsonRedisSerializer.setObjectMapper(om);
	        template.setValueSerializer(jackson2JsonRedisSerializer);
	        template.afterPropertiesSet();
	        return template;
	    }

	@Bean("rateLimitUseIncr")
	public DefaultRedisScript<Long> rateLimitUseIncr() {
		DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
		redisScript.setLocation(new ClassPathResource("rateLimitUseIncr.lua"));
		redisScript.setResultType(Long.class);
		return redisScript;
	}

	@Bean("rateLimitUseIncr2")
	public DefaultRedisScript<Long> rateLimitUseIncr2() {
		return new DefaultRedisScript<>(this.getScript(), Long.class);
	}

	private String getScript() {
		String script = "local current=0\n" +
				"current = redis.call(\"incr\",KEYS[1])\n" +
				"if tonumber(current) == 1 then\n" +
				"    redis.call(\"expire\",KEYS[1],1)\n" +
				"end\n" +
				"\n" +
				"return current";
		return script;
	}
}
