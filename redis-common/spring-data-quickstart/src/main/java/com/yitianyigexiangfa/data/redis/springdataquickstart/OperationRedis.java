package com.yitianyigexiangfa.data.redis.springdataquickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.net.URL;

/**
 * @author Bill Lau
 * @date 2018-04-17
 */
public class OperationRedis {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    public void addLink(String userId, URL url) {
        listOps.leftPush(userId, url.toExternalForm());
        // or use template directly
        redisTemplate.boundListOps(userId).leftPush(url.toExternalForm());
    }

    public static void main(String[] args) {
        OperationRedis operationRedis = new OperationRedis();
        ValueOperations<String, String> valueOperations =  operationRedis.redisTemplate.opsForValue();
        valueOperations.set("liubei", "yuanmengchen");
        String result = valueOperations.get("liubei");
        System.out.println(result);
    }
}
