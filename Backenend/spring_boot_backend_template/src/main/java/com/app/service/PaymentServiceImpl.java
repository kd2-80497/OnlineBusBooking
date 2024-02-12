package com.app.service;

import java.time.LocalDate;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dao.BookingDao;
import com.app.dao.PaymentDao;
import com.app.dto.ApiResponse;
import com.app.dto.PaymentDto;
import com.app.entities.Booking;
import com.app.entities.Payment;

import custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public boolean isPaymentSucessful(Long paymentid) {
		Payment p = paymentDao.findById(paymentid).orElseThrow(()->new ResourceNotFoundException("Invalid id"));
	if(p.isPaymentStatus()) {
		return true;
	}
		return false;
	}

	@Override 
	public ApiResponse addNewPayment(@Valid PaymentDto dto) {
	
		Payment p = paymentDao.save(mapper.map(dto, Payment.class));
		p.setPaymentDate(LocalDate.now());
		p.setPaymentStatus(true);
		Booking booking = bookingDao.findById(dto.getBookingid()).orElseThrow();
		p.setBooking(booking);
		return new ApiResponse("Payment Done ");
	}
	
	
	
}
