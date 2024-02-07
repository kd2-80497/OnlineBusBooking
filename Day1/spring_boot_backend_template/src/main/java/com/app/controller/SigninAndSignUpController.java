package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SignUpRequest;
import com.app.dto.SigninRequest;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class  SigninAndSignUpController {
	@Autowired
 private UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signinUser(@RequestBody @Valid SigninRequest dto){
		System.out.println("in auth user "+ dto);
		return ResponseEntity.ok(userService.userSignIn(dto));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signupUser(@RequestBody @Valid SignUpRequest dto){
		System.out.println("in auth user "+ dto);
		return ResponseEntity.ok(userService.userRegistration(dto));
	}
	
}
