package com.app.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.app.dto.ApiResponse;
import com.app.dto.BookingDto;

public interface BookingService {

	ResponseEntity<?> addNewBooking(@Valid BookingDto dto);

}
