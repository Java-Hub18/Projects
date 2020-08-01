package com.dream.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="is required")
	@Size(min=2,message="is required")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=2,message="is required")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message="is required")
	//@Pattern(regexp="^[a-zA-Z0-9]{5}/^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$/",message="must contain @ and .")
	@Column(name="email",unique=true)
	private String email;

	@NotNull(message="is required")
	@Size(min=2,message="is required")
	@Column(name="password")
	private String password;
	
	public Customer() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

	
	
	
}
