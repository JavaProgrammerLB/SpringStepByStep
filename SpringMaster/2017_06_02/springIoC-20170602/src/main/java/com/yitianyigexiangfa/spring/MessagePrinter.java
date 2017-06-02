package com.yitianyigexiangfa.spring;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	private final MessageService service;
	private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	public MessagePrinter(MessageService service){
		this.service = service;
	}
	
	public void printMessage(){
//		System.out.println(this.service.getMessage());
		logger.error(this.service.getMessage());
		logger.info(this.service.getMessage());
	}
}
