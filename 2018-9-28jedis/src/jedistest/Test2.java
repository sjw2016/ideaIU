package jedistest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public abstract class Test2 {
	/**
	 * 管道方式
	 */
private static void usePipeline() {
	try{
	Jedis jedis = new Jedis("localhost",6379);
	Pipeline pipeline  = jedis.pipelined();
	for( int i = 0;i<1000;i++){
		pipeline.incr("test1");
	}
	pipeline.sync();
	jedis.disconnect();
	}catch(Exception e){
	e.printStackTrace();
	}
}
/**
 * 普通方式
 */
private static void withou(){
	try {
		Jedis jedis = new Jedis("localhost",6379);
		for (int i = 0; i < 1000; i++) {
			jedis.incr("test2");
		}
		jedis.disconnect();
	} catch (Exception e) {
		// TODO: handle exception
	}
}

public static void main(String[] args) {
	long start = System.currentTimeMillis();
	withou();
	long end = System.currentTimeMillis();
	System.out.println("普通："+(end-start));
	
	 start = System.currentTimeMillis();
	usePipeline();
	 end = System.currentTimeMillis();
	 System.out.println("管道："+(end-start));
}
}