package com.yitianyigexiangfa.mail.di.resource.mail;

public interface MailSender {
	public void send(String to, String subject, String body);
}
