package com.yitianyigexiangfa.redis;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver {
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	private CountDownLatch latch;
	
	public Receiver(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void receiveMessage(String message){
		LOGGER.info("RECEIVED <" + message + ">");
		latch.countDown();
	}
}
