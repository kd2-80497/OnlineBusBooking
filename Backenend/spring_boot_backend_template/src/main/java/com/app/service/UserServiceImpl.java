package com.app.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.dto.SignUpRequest;
import com.app.dto.SignUpResponse;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public SigninResponse userSignIn(SigninRequest reqDTO) {
		
	User user = userDao.findByEmailAndPassword(reqDTO.getEmail(),reqDTO.getPassword()).orElseThrow();
	return  mapper.map(user,SigninResponse.class);
	}

	@Override
	public SignUpResponse userRegistration(@Valid SignUpRequest dto) {
		
		
		User user = userDao.save(mapper.map(dto,User.class));
		return new SignUpResponse("registration sucessfully");
	}

	
}