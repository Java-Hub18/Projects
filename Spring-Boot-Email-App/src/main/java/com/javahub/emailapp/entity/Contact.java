package com.javahub.emailapp.entity;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class Contact {

	@NotNull(message = "Name can't be blank.")
	private String name;
	
	@NotNull(message = "Name can't be blank.")
	private String phone;
	
	@NotNull(message = "Email can't be blank.")
	private String email;
	
	@NotNull(message = "Subject can't be blank.")
	private String subject;
	
	@NotNull(message = "Comment can't be blank.")
	private String comment;
	
	private MultipartFile attachment;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public MultipartFile getAttachment() {
		return attachment;
	}
	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", email=" + email + ", subject=" + subject + ", comment="
				+ comment + ", attachment=" + attachment + ", getName()=" + getName() + ", getPhone()=" + getPhone()
				+ ", getEmail()=" + getEmail() + ", getSubject()=" + getSubject() + ", getComment()=" + getComment()
				+ ", getAttachment()=" + getAttachment() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
