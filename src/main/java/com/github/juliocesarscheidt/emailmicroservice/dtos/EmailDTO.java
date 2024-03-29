package com.github.juliocesarscheidt.emailmicroservice.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDTO {
	
	@NotBlank
	private String ownerRef;
	
	@Email
	@NotBlank
	private String emailFrom;
	
	@Email
	@NotBlank
	private String emailTo;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String text;

	public String getOwnerRef() {
		return ownerRef;
	}

	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "EmailDTO [ownerRef=" + ownerRef + ", emailFrom=" + emailFrom + ", emailTo=" + emailTo + ", subject="
			+ subject + ", text=" + text + "]";
	}
}
