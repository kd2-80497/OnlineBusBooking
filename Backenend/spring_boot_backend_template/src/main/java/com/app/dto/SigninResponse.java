package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SigninResponse {
//	public SigninResponse(String generateJwtToken, String string) {
//		// TODO Auto-generated constructor stub
//	}
    private String jwt;
	private String mess;

	private Long id;
	private String firstName;
	
	private String lastName;
	private String email;
	
	private String password;
	private String phoneNumber;
	private String role;

	
	public SigninResponse(String jwt , String mess) {
		this.jwt = jwt;
		this.mess = mess;
	}
}
