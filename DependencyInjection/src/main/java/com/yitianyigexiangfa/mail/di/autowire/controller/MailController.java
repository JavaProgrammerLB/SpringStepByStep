package com.yitianyigexiangfa.mail.di.autowire.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yitianyigexiangfa.mail.di.autowire.mail.MailSender;



@RestController
public class MailController {
	
	private MailSender mailSender;
	
	@Autowired
	public MailController(@Qualifier("mock")MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/autowire")
	public String sendMail(){
		mailSender.send("admin@yitianyigexiangfa.com", 
				"Subject from autowire", "Hello hello hello");
		return "Mail Sent";
	}
}
