package com.app.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthenticateSigin;
import com.app.dto.SignUpRequest;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.security.JwtUtils;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class SigninAndSignUpController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils utils;
    @Autowired
    private AuthenticationManager mgr;

    Random random = new Random(10000);

    @PostMapping("/signup")
    public ResponseEntity<?> signinUser(@RequestBody @Valid SignUpRequest dto) {
        System.out.println("in auth user " + dto);
        return ResponseEntity.ok(userService.userRegistration(dto));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signupUser(@RequestBody @Valid SigninRequest dto) {
        System.out.println("in auth user " + dto);
        Authentication verifiedAuth = mgr.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        System.out.println(verifiedAuth.getClass());// Custom user details
        // => auth success
        return ResponseEntity.ok(new AuthenticateSigin(utils.generateJwtToken(verifiedAuth), "Successful Authentication!!!"));
    }
}
