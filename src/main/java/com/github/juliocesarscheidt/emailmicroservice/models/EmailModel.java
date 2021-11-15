package com.github.juliocesarscheidt.emailmicroservice.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.juliocesarscheidt.emailmicroservice.enums.StatusEmail;

import lombok.Data;

@Data
@Entity(name = "MAIL")
@Table(name = "MAIL")
public class EmailModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email_id")
	private Long emailId;
	
	@Column(name = "owner_ref")
	private String ownerRef;
	
	@Column(name = "email_from")
	private String emailFrom;
	
	@Column(name = "email_to")
	private String emailTo;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "text", columnDefinition = "TEXT")
	private String text;
	
	@Column(name = "send_date_email")
	private LocalDateTime sendDateEmail;
	
	@Column(name = "status_email")
	private StatusEmail statusEmail;

	public Long getEmailId() {
		return emailId;
	}

	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}

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

	public LocalDateTime getSendDateEmail() {
		return sendDateEmail;
	}

	public void setSendDateEmail(LocalDateTime sendDateEmail) {
		this.sendDateEmail = sendDateEmail;
	}

	public StatusEmail getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(StatusEmail statusEmail) {
		this.statusEmail = statusEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmailModel [emailId=" + emailId + ", ownerRef=" + ownerRef + ", emailFrom=" + emailFrom + ", emailTo="
			+ emailTo + ", subject=" + subject + ", text=" + text + ", sendDateEmail=" + sendDateEmail
			+ ", statusEmail=" + statusEmail + "]";
	}
}
