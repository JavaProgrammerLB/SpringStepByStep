package com.yitianyigexiangfa.mail;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.junit.Test;

public class JavaMailDemo {

	public JavaMailDemo() {
	}
	
//	@Test
	public void sendSimpleTextMail(){
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("username", "password"));
			email.setSSLOnConnect(true);
			email.setFrom("username");
			email.setSubject("TestMail");
			email.setMsg("This is a test mail ... :-)");
			email.addTo("foo@bar.com");
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void sendEmailWithAttachment(){
		  try {
			  // Create the attachment
			  EmailAttachment attachment = new EmailAttachment();
			  System.out.println(System.getProperty("user.dir"));
			  attachment.setPath("src/main/resources/john.jpg");
//			  attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
			  attachment.setDisposition(EmailAttachment.ATTACHMENT);
			  attachment.setDescription("Picture of John");
			  attachment.setName("John.jpg");
			// Create the email message
			  MultiPartEmail email = new MultiPartEmail();
			  email.setHostName("smtp.googlemail.com");
			  email.setSmtpPort(465);
			  email.setSSLOnConnect(true);
			  email.setFrom("username", "LIUBEI");
			  email.addTo("admin@yitianyigexiangfa.com", "ADMIN");
			  email.setAuthentication("username", "password");
			  email.setSubject("The picture");
			  email.setMsg("Here is the picture you wanted");
			  // add the attachment
			  email.attach(attachment);
			  // send the email
			  email.send();
			  System.out.println("finished!!!");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void sendEmailWithHtml(){
		  try {
			// Create the email message
			  HtmlEmail email = new HtmlEmail();
			  email.setHostName("smtp.googlemail.com");
			  email.setSmtpPort(465);
			  email.setSSLOnConnect(true);
			  email.setFrom("username", "LIUBEI");
			  email.addTo("admin@yitianyigexiangfa.com", "ADMIN");
			  email.setAuthentication("username", "password");
			  
			  // embed the image and get the content id
			  URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
			  String cid = email.embed(url, "Apache logo");
			  
			  // set the html message
			  email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

			  // set the alternative message
			  email.setTextMsg("Your email client does not support HTML messages");

			  // send the email
			  email.send();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (EmailException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@Test
	public void test(){
		 try {
			// load your HTML email template
			  String htmlEmailTemplate = "....hello how are you <img src=\"http://www.apache.org/images/feather.gif\"> ....";

			  // define you base URL to resolve relative resource locations
			  URL url = new URL("http://www.apache.org");

			  // create the email message
			  ImageHtmlEmail email = new ImageHtmlEmail();
			  email.setDataSourceResolver(new DataSourceUrlResolver(url));
			  email.setHostName("smtp.googlemail.com");
			  email.setSmtpPort(465);
			  email.setSSLOnConnect(true);
			  email.setFrom("username", "LIUBEI");
			  email.addTo("admin@yitianyigexiangfa.com", "ADMIN");
			  email.setAuthentication("username", "password");
			  email.setSubject("Test email with inline image");
			  
			  // set the html message
			  email.setHtmlMsg(htmlEmailTemplate);

			  // set the alternative message
			  email.setTextMsg("Your email client does not support HTML messages");

			  // send the email
			  email.send();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (EmailException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
}
