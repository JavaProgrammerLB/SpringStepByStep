package com.yitianyigexiangfa.mail.di.newobject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yitianyigexiangfa.mail.di.newobject.mail.MailSender;
import com.yitianyigexiangfa.mail.di.newobject.mail.impl.MockMailSender;

@RestController
public class MailController {
	
	private MailSender mailSender = new MockMailSender();
	
	@RequestMapping("/newobject")
	public String sendMail(){
		mailSender.send("admin@yitianyigexiangfa.com", "Hello admin,"
				+ " this is a fan of "
				+ "yitianyigexiangfa.", "Hello hello hello hello");
		return "Mail sent";	
	}
	
}
