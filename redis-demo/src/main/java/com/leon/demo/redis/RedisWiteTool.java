package com.leon.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author : leonwang
 * @Descpriction 用于测试redis生成数据
 * @Date:created 2020/3/21
 */
public class RedisWiteTool {
    public static void main(String[] args) {
        JedisPool pool = RedisPoolHelper.getJedisPool(args[0], (Integer.valueOf(args[1])), args[2]);
        Jedis jedis = pool.getResource();
        int i = 0;
        while (true) {
            jedis.set("Generate" + i, "V" + i);
            i++;
        }
    }
}
