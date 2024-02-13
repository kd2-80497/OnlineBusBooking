package com.app.service;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.BookingDto;

public interface BookingService {

	ApiResponse addNewBooking(@Valid BookingDto dto);

}
