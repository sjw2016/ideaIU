package jedistest;

import java.util.Iterator;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Test01 {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.print("连接成功");
		System.out.println(jedis.set("na","123"));
		System.out.println(jedis.get("na"));
		System.out.println("--------------------------");
//		jedis.rpush("mylist", "1");
//		jedis.rpush("mylist", "2");
//		jedis.rpush("mylist", "3");
//		System.out.println(jedis.get("mylist"));
		
		
		jedis.sadd("myset", "set1");
		jedis.sadd("myset", "set2");
		jedis.sadd("myset", "set3");
		System.out.println(jedis.smembers("myset"));
		Iterator<String> it = jedis.smembers("myset").iterator();
		while(it.hasNext()){
			String str = it.next();
			System.out.println(str);
		}
		System.out.println("------------------------------");
		
//		jedis.hset("myhash", "field1", "1");
//		jedis.hset("myhash", "field2", "2");
//		jedis.hset("myhash", "field3", "2");
//		String str = jedis.hget("myhash", "field2");
//		System.out.println(str);
//		System.out.println(jedis.hgetAll("myhash"));
//		Map<String, String>map = jedis.hgetAll("myhash");
//		for ( string : args) {
//			
//		}
		
		System.out.println("--------------------");
		Transaction t = jedis.multi();
		t.set("test", "abc");
		System.out.println(t.get("text"));
		t.exec();
		System.out.println(jedis.get("text"));
	}
}
