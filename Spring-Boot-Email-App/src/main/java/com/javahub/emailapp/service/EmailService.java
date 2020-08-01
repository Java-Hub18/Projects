package com.javahub.emailapp.service;

import javax.mail.MessagingException;

import org.springframework.web.multipart.MultipartFile;

import com.javahub.emailapp.entity.Contact;

public interface EmailService {

	public void sendSimpleEmail(Contact contact) throws MessagingException;
	
	public void sendAttachmentEmail(Contact contact, MultipartFile file) throws MessagingException;
	
}
