package com.yitianyigexiangfa.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
	
	private final MessageService service;
	
	@Autowired
	public MessagePrinter(MessageService service){
		this.service = service;
	}

	public void printMessage(){
		System.out.println(service.getMessage());
	}
}
