package com.springproject.Spring4MVC.mail;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springproject.Spring4MVC.mail.emailAPI;

public class Emailinputs {
	
	public void automail() {
				
		String emailConfFile = "appconfig-mail.xml";
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(emailConfFile);
 
		emailAPI emailEmailAPI = (emailAPI) context.getBean("requestMail");
		String toAddr = "udaydutttatikonda@gmail.com";
		String fromAddr = "udaydutttatikonda@gmail.com";
		// email subject
		String subject = "Book Request";
 
		// email body
		String body = "You got a book request from uday";
		emailEmailAPI.emailReadyToSendEmail(toAddr, fromAddr, subject, body);
	}
}
