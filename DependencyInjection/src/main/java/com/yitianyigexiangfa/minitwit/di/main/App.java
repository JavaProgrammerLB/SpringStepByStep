package com.yitianyigexiangfa.minitwit.di.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.yitianyigexiangfa.minitwit.di.config.WebConfig;
import com.yitianyigexiangfa.minitwit.di.service.MiniTwitService;

@Configuration
@Component("com.yitianyigexiangfa.minitwit.di")
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		new WebConfig(ctx.getBean(MiniTwitService.class));
		ctx.registerShutdownHook();
	}
}
