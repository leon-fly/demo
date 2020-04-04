package com.leon.demo.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/3/21
 */
@Service
public class RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    public void test(String key, String value) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key == null ? "springboot-set" : key, value == null ? "s1" : value);
        Object k1 = ops.get(key == null ? "springboot-set" : key);
        System.out.println(k1);
    }

}
