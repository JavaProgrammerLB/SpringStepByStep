package com.yitianyigexiangfa.data.redis.springdataquickstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Bill Lau
 * @date 2018-04-18
 */
@Service
public class RedisService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOpsObj;

    public String getStr(String key) {
        return valOpsStr.get(key);
    }

    public void setStr(String key, String val) {
        valOpsStr.set(key, val);
    }

    public Boolean delStr(String key) {
        return stringRedisTemplate.delete(key);
    }
}
