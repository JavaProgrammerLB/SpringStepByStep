package com.yitianyigexiangfa.mail.di.newobject.mail.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yitianyigexiangfa.mail.di.newobject.mail.MailSender;

public class MockMailSender implements MailSender{

	private static final Log log = LogFactory.getLog(MockMailSender.class);
	
//	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending mail to" + to);
		log.info("Subject is: " + subject);
		log.info("Body is: " + body);
	}
	
}
