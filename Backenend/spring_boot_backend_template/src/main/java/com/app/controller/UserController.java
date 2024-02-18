package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.UserResponseDTO;
import com.app.service.UserService;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	UserService use;

	@GetMapping
	public List<UserResponseDTO> listAllPassenger() {
		System.out.println("in list all passenger");
		return use.getAllUsers();
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse deleteUserDetails(@PathVariable Long id) {
		System.out.println("in del USER dtls " + id);
		return new ApiResponse(use.deleteUserDetails(id));
	}
}
