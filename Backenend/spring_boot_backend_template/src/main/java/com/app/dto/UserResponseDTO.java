package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponseDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String role;
}
