package com.yitianyigexiangfa.mail.di.newobject.mail;

public interface MailSender {
	public void send(String to, String subject, String body);
}
