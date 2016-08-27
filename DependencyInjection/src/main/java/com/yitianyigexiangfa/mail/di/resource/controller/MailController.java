package com.yitianyigexiangfa.mail.di.resource.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yitianyigexiangfa.mail.di.resource.mail.MailSender;

@RestController
public class MailController {
	
	@Resource(name="mockMailSender")
	private MailSender mailSender;
	
	@RequestMapping("/resource")
	public String sendMail(){
		mailSender.send("admin@yitianyigexiangfa.com", 
				"Subject from resource", "Hello hello hello");
		return "Mail Sent";
	}
}
