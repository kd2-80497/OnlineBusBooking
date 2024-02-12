package com.app.controller;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookingDto;
import com.app.service.BookingService;
@RestController
@RequestMapping("/booking")
@CrossOrigin(origins="http://localhost:3000")
public class BookingController {
	
	@Autowired
  private BookingService bookingService;
	
	
	//add New Booking
	//http://host:port/bookings
	@PostMapping
	public ResponseEntity<?> addNewBooking(@RequestBody @Valid BookingDto dto){
		
		System.out.println("in add dept " + dto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(bookingService.addNewBooking(dto));	
		
	}
	





}
