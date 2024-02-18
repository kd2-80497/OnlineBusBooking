package com.app.service;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private OtpService otpservice;
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private ModelMapper mapper;

	@Override
	public SigninResponse userSignIn(@Valid SigninRequest reqDTO) {
		
//	User user = userDao.findByEmailAndPassword(reqDTO.getEmail(),reqDTO.getPassword()).orElseThrow();
	User user=userDao.findByEmailAndPassword(reqDTO.getEmail(),reqDTO.getPassword());
	//	User user=userDao.findByEmailAndPassword(null, null)
		//return  mapper.map(user,SigninResponse.class);
	return new SigninResponse();
}

	@Override
	public SignUpResponse userRegistration(@Valid SignUpRequest dto) {
		
		
		User user = userDao.save(mapper.map(dto,User.class));
		user.setRole("customer");
		user.setPassword(encoder.encode(dto.getPassword()));
		return new SignUpResponse("registration sucessfully");
	}

	@Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public String generateAndSendOTP(String email) {
        User user = userDao.findByEmail(email);
        if (user != null) {
            String otp = otpservice.generateAndSendOTP(email);
            return otp;
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
