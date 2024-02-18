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
}
