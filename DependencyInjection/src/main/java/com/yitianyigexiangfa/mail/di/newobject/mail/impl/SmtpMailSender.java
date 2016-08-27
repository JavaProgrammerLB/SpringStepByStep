package com.yitianyigexiangfa.mail.di.newobject.mail.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yitianyigexiangfa.mail.di.newobject.mail.MailSender;

public class SmtpMailSender implements MailSender {

	private static final Log log = LogFactory.getLog(SmtpMailSender.class);
	
//	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending Smtp mail to: " + to);
		log.info("The Smtp mail subject: " + subject);
		log.info("The Smtp mail body: " + body);
	}

}
