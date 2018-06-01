package com.yitianyigexiangfa.data.redis.springdataquickstart.controller;

import com.yitianyigexiangfa.data.redis.springdataquickstart.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bill Lau
 * @date 2018-04-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "setIdAndName")
    @ResponseBody
    public String insertId2Name(@RequestParam String key,@RequestParam String val){
        try {
            redisService.setStr(key, val);
        } catch (Exception e){
            e.printStackTrace();
            return ("Error: " + e.getMessage());
        }
        return "结果为：" + "Success";
    }

    @RequestMapping(value = "getName")
    @ResponseBody
    public String getNameWithId(@RequestParam String key){
        String result = null;
        try {
            result = redisService.getStr(key);
        } catch (Exception e){
            e.printStackTrace();
            result = "Error: " + e.getMessage();
        }
        return "结果为：" +  result;
    }

}
