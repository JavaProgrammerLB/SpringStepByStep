package com.yitianyigexiangfa.javax.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class SendHTMLEmailWithTemplate {

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File("settings.properties")));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Session session = Session.getDefaultInstance(props,
				new Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"username", "******");
					}
				});

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress("from@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("to@gmail.com"));
			message.setSubject("Testing Subject");

			BodyPart body = new MimeBodyPart();

			// freemarker stuff.
			Configuration cfg = new Configuration();
			Template template = cfg.getTemplate("html-mail-template.ftl");
			Map<String, String> rootMap = new HashMap<String, String>();
			rootMap.put("to", "liubei");
			rootMap.put("body", "Sample html email using freemarker");
			rootMap.put("from", "liubei");
			Writer out = new StringWriter();
			template.process(rootMap, out);
			// freemarker stuff ends.

			/* you can add html tags in your text to decorate it. */
			body.setContent(out.toString(),	"text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(body);

			body = new MimeBodyPart();

			String filename = "hello.txt";
			DataSource source = new FileDataSource(filename);
			body.setDataHandler(new DataHandler(source));
			body.setFileName(filename);
			multipart.addBodyPart(body);

			message.setContent(multipart, "text/html;charset=utf-8");

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		System.out.println("Done....");
	}
}

