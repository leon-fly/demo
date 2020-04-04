package com.leon.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author : leonwang
 * @Descpriction 该方式类似于乐观锁，当并发量大时失败大概率很大，浪费计算资源。
 * @Date:created 2020/3/20
 */
public class RedisTransactionWithWatchDemo {
    public static void main(String[] args) throws InterruptedException {
        JedisPool jedisPool = RedisPoolHelper.getJedisPool(args[0], Integer.valueOf(args[1]), args[2]);
        Jedis jedis = jedisPool.getResource();
        jedis.select(1);

        //开启事务前watch
        jedis.watch("trans-s1", "trans-s2", "trans-s3");
        //开启事务
        Transaction transaction = jedis.multi();
        try {
            transaction.set("trans-s1", "s1");
            transaction.set("trans-s2", "s2");
            System.out.println("sleep...");
            TimeUnit.SECONDS.sleep(10);
            transaction.set("trans-s3", "s3");
            transaction.getSet("trans-s3", "s3-reset");
            List<Object> objects = transaction.exec();
            //返回的列表为每个redis命令执行结果返回值
            System.out.println("返回结果大小：" + objects.size());
            jedis.unwatch();
        } catch (Exception e){
            jedis.unwatch();
            transaction.discard();  //事务队列不清空有什么问题??? TODO
        } finally{
            jedisPool.close();
        }
    }
}
