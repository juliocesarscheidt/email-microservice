package com.github.juliocesarscheidt.emailmicroservice.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.github.juliocesarscheidt.emailmicroservice.dtos.EmailDTO;
import com.github.juliocesarscheidt.emailmicroservice.enums.StatusEmail;
import com.github.juliocesarscheidt.emailmicroservice.models.EmailModel;
import com.github.juliocesarscheidt.emailmicroservice.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;

	public EmailModel sendEmail(EmailDTO emailDTO) {
		EmailModel emailModel = new EmailModel();
	    BeanUtils.copyProperties(emailDTO, emailModel);
	    emailModel.setSendDateEmail(LocalDateTime.now());

	    try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailDTO.getEmailFrom());
			message.setTo(emailDTO.getEmailTo());
			message.setSubject(emailDTO.getSubject());
			message.setText(emailDTO.getText());

			emailSender.send(message);
			emailModel.setStatusEmail(StatusEmail.SENT);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			emailModel.setStatusEmail(StatusEmail.ERROR);
		} finally {
			this.emailRepository.save(emailModel);
		}

		System.out.println(emailModel.toString());

	    return emailModel;
	}
}
