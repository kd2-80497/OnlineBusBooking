package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class SignUpRequest {
	
	private String  firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	public SignUpRequest(String firstName, String lastName, String email, String password, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
}

