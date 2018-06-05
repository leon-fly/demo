package com.leon.demo.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/**
 * 哨兵模式测试
 * @author leonwang
 *
 */
public class SentinelsModelTest {
	public static void main(String[] args) {
		Set<String> sentinels = new HashSet<String>();  
	    sentinels.add(new HostAndPort("127.0.0.1", 9001).toString());  
	    
	    sentinels.add(new HostAndPort("127.0.0.1", 9002).toString());  
	    sentinels.add(new HostAndPort("127.0.0.1", 9003).toString());  
	    JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster",  
	        sentinels);  
	    System.out.println("Current master: "  
	        + sentinelPool.getCurrentHostMaster().toString());  
	  
	    Jedis master = sentinelPool.getResource(); 
	    master.auth("123456");
	    master.set("master", "123456");  
	    System.out.println("set->master:123456");  
	  
	    // 这里休眠60秒 ,将主redis杀掉，按哨兵机制，将发现主redis状态down  
	    // 重新选举新的slave为主master  
	    try {  
	        System.out.println("sleep 60s  begin");  
	        Thread.sleep(30000);  
	        System.out.println("sleep 60s  end!!!");  
	    } catch (Exception Exc) {  
	  
	        Exc.printStackTrace();  
	        System.exit(0);  
	    }  
	  
	    // 重新获得jedis  
	    System.out.println("Current master: "  
		        + sentinelPool.getCurrentHostMaster().toString());  
	    Jedis master2 = sentinelPool.getResource();  
	    master2.auth("123456");
	    String value = master2.get("username1");  
	    System.out.println("get->username1: " + value);  
	  
	    master2.set("username2", "newland");  
	    System.out.println("set->username2:newland ");  
	  
	    String value2 = master2.get("username2");  
	    System.out.println("get->username2: " + value2);  
	  
	    master2.close();  
	    sentinelPool.close();
	    sentinelPool.destroy();  
	}
}
