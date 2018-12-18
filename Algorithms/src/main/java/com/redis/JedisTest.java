package com.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * 
 * @author zhangbo
 */
@Slf4j
public class JedisTest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("172.18.8.143", 6379);
        String set = jedis.set("test", "test", "NX", "PX", 1000 * 60);
        System.out.println(set);

        String test = jedis.get("test");
        System.out.println(test);

    }
}
