package com.yitianyigexiangfa.mail.di.autowire.mail;

public interface MailSender {
	public void send(String to, String subject, String body);
}
