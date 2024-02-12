package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.PaymentDao;
import com.app.dto.BusDto;
import com.app.dto.PaymentDto;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins="http://localhost:3000")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	//1.add Payment
	//http://host:port/payment  , method = post
	@PostMapping
	public ResponseEntity<?> addNewPayment(@RequestBody @Valid PaymentDto dto){
		System.out.println("in add Bus " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.addNewPayment(dto));
	}
}
