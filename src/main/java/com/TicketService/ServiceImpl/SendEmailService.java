package com.TicketService.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.TicketService.Service.IEmailSenderService;

@Service
public class SendEmailService implements IEmailSenderService {
	@Autowired
	private MailSender mailSender;
	// MailSender interface defines a strategy for sending simple mails

	public void sendEmail(String toAddress, String subject, String msgBody) {

		SimpleMailMessage mailMsg = new SimpleMailMessage();
		mailMsg.setTo(toAddress);
		mailMsg.setSubject(subject);
		mailMsg.setText(msgBody);
		mailSender.send(mailMsg);
	}
}
