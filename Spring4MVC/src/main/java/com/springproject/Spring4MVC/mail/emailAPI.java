package com.springproject.Spring4MVC.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service("requestMail")
public class emailAPI {
	@Autowired
	private MailSender requestmail; // MailSender interface defines a strategy
										// for sending simple mails
	public void emailReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
		System.out.println("Now in emailapi class..................");
		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setFrom(fromAddress);
		emailMsg.setTo(toAddress);
		emailMsg.setSubject(subject);
		emailMsg.setText(msgBody);
		System.out.println(requestmail);
		requestmail.send(emailMsg);		
	}

}
