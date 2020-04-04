package com.leon.demo.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author : leonwang
 * @Descpriction 获取链接池，非工业代码，仅展示逻辑，串联流程
 * @Date:created 2020/3/20
 */
public class RedisPoolHelper {
    public static JedisPool getJedisPool(String host, int port, String password) {
        System.out.println(String.format("host:%s,port:%d, password:%s", host, port, password));
        JedisPoolConfig poolConfig;
        JedisPool pool;

        poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(2);
        // 最大空闲数
        poolConfig.setMaxIdle(2);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);
        pool = new JedisPool(poolConfig, host, port, 0, password);
        return pool;
    }
}
