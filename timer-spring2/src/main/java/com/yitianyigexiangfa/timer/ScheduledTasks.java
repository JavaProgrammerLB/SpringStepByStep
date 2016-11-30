package com.yitianyigexiangfa.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
	
	public ScheduledTasks() {
	}

	@Scheduled(fixedRate=5000)
	public void mymethod(){
		log.info("Current time is : {}", dateformat.format(new Date()));
	}
}
