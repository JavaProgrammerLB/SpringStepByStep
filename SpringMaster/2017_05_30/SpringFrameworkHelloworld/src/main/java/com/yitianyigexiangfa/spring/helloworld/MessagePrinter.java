package com.yitianyigexiangfa.spring.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	private final MessageService service;
	
	@Autowired
	public MessagePrinter(MessageService service){
		this.service = service;
	}
	
	public void PrintMessage(){
		System.out.println(this.service.getMessage());
	}
	
}
