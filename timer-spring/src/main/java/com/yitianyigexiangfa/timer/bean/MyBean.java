package com.yitianyigexiangfa.timer.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class MyBean {

	@Scheduled(fixedRate=1000)
	public void printMessage() {
		System.out.println("I am called by Spring scheduler");
		Date date = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = fmt.format(date);
		System.out.println(now);
	}

}
