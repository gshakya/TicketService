package com.TicketService.Service;

import org.springframework.stereotype.Service;

@Service
public interface IEmailSenderService {

	public void sendEmail(String toAddr, String subject, String body);
}
