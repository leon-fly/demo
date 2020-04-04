package com.leon.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author : leonwang
 * @Descpriction redis 事务实现
 * @Date:created 2020/3/20
 */
public class RedisTransactionDemo {
    public static void main(String[] args) throws InterruptedException {
        JedisPool jedisPool = RedisPoolHelper.getJedisPool(args[0], Integer.valueOf(args[1]), args[2]);
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.select(1);
            //开启事务
            Transaction transaction = jedis.multi();
            transaction.set("trans-s1", "s1");
            transaction.set("trans-s2", "s2");
            transaction.set("trans-s3", "s3");
            transaction.getSet("trans-s3", "s3-reset");
            TimeUnit.SECONDS.sleep(10);
            List<Object> objects = transaction.exec();
            //返回的列表为每个redis命令执行结果返回值
            System.out.println("返回结果大小：" + objects.size());
        } finally {
            jedisPool.close();
        }
    }
}
