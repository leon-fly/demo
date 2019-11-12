package com.leon.demo.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisDemo {
    static JedisPoolConfig poolConfig;
    static JedisPool pool;

    static {
        poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(2);
        // 最大空闲数
        poolConfig.setMaxIdle(2);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);
        pool = new JedisPool(poolConfig, "localhost", 6379, 0, null);
    }

    public static void main(String[] args) {
        Jedis jedis = null;
        jedis = pool.getResource();
        try {
//			delAll(jedis);
//            testString(jedis);
//			testHash(jedis);
            testList(jedis);
//			testSortedSet(jedis);
//			testSet(jedis);
        } finally {
            jedis.close();
            pool.close();
        }
    }

    /**
     * 测试字符串的读写
     */
    public static void testString(Jedis jedis) {
        /**
         * 写入
         */
        for (int i = 0; i < 500000; i++) {
            String rtn = jedis.set("foo-new" + i, "bar" + i);
//			jedis.expire("foo" + i, 300);  //设置过期时间
            System.out.println("第" + (i + 1) + "个存入结果:" + rtn);
        }
        /**
         * 读取
         */
        System.out.println("读取。。。。");
        for (String str : jedis.keys("foo*")) {
            System.out.println(str + ":" + jedis.get(str));
        }
    }

    public static void testHash(Jedis jedis) {
        /**
         * 方式一 ：一个一个写入
         */
        for (int i = 0; i < 50000; i++) {
            for (int j = 0; j < 5; j++) {
                Long rtn = jedis.hset("hash" + i, "key" + j, "value" + j);
                System.out.println("第" + (i + 1) + "个set存入第" + (j + 1) + "结果:" + rtn);
            }
        }
        /**
         * 方式二 ： 通过map全部写入
         */
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("name", "leon");
        hm.put("age", "18");
        hm.put("sex", "男");
        jedis.hmset("hash-leon-19890316", hm);


        /**
         * 读取方式一
         */
        System.out.println("读取。。。。");
        for (String key : jedis.keys("hash*")) {
            System.out.print(key + "：");
            Map<String, String> map = jedis.hgetAll(key);
            map.forEach((k, v) -> System.out.print(k + ":" + v + "\t"));
            System.out.println();
        }
        /**
         * 读取方式二
         */
//		jedis.hmget(key, fields)；
    }

    public static void testList(Jedis jedis) {
        String listKey = "student";
        jedis.lpush(listKey, "leon");
        jedis.lpush(listKey, "jin");
        jedis.lpush(listKey, "wang");

        long length = jedis.llen(listKey);
        jedis.lrange(listKey, 0, length - 1).forEach(value -> {
            System.out.println(value);
        });
    }

    /**
     * 测试set，结构： key value,
     *
     * @param jedis
     */
    public static void testSet(Jedis jedis) {
        jedis.sadd("setKey", "setValue0", "setValue1", "setValue2", "setValue3");
        Set<String> set = jedis.smembers("setKey");
        System.out.println("setKey的值为：");
        set.forEach((String val) -> System.out.print(val + "\t"));
    }

    /**
     * 测试有序set，结构：  key score member
     *
     * @param jedis
     */
    public static void testSortedSet(Jedis jedis) {
        Random random = new Random();
        for (int i = 0; i < 2000; i++) {
            float score = random.nextInt(100);
            jedis.zadd("sortedKey", score, "sortedValue" + i);
            System.out.println("插入第" + i + "个sorted元素，score=" + score + ",sortedValue:" + "sortedValue" + i);
        }
        Set<String> sortedSet = jedis.zrange("sortedKey", -90, 99);
        sortedSet.forEach((String val) -> System.out.print(val + "\t"));

    }

    /**
     * 删除所有的存储数据
     *
     * @param jedis
     */
    public static void delAll(Jedis jedis) {
        jedis.keys("*").forEach((String key) -> {
            jedis.del(key);
            System.out.println("删除key：" + key);
        });
    }

}
