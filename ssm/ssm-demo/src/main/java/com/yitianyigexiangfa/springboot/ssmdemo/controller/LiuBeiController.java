package com.yitianyigexiangfa.springboot.ssmdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bill Lau
 * @date 2018-02-05
 */
@RestController
public class LiuBeiController {

    @RequestMapping("/hi")
    public String test() {
        return "Hello world";
    }
}
