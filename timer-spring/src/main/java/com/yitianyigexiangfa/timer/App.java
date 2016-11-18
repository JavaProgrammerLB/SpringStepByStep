package com.yitianyigexiangfa.timer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.yitianyigexiangfa.timer.config.AppConfig;

public class App {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String args[]){
		AbstractApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
