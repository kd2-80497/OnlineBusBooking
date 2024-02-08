package com.app.service;

import javax.validation.Valid;

import com.app.dto.SignUpRequest;
import com.app.dto.SignUpResponse;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;

public interface UserService {

	SigninResponse userSignIn(SigninRequest reqDTO);

	SignUpResponse userRegistration(@Valid SignUpRequest dto);

	

}
