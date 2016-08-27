package com.yitianyigexiangfa.mail.di.autowire.mail.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.yitianyigexiangfa.mail.di.newobject.mail.MailSender;

@Component
@Qualifier("mock")
public class MockMailSender implements MailSender{

	private static final Log log = LogFactory.getLog(MockMailSender.class);
	
//	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending mail to" + to);
		log.info("Subject is: " + subject);
		log.info("Body is: " + body);
	}
	
}
