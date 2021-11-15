package com.github.juliocesarscheidt.emailmicroservice.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.juliocesarscheidt.emailmicroservice.dtos.EmailDTO;
import com.github.juliocesarscheidt.emailmicroservice.models.EmailModel;
import com.github.juliocesarscheidt.emailmicroservice.services.EmailService;

@RestController
@RequestMapping("/v1/email")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping(value = "/send", consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
		EmailModel emailModel = emailService.sendEmail(emailDTO);
	    return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
  	}
}
