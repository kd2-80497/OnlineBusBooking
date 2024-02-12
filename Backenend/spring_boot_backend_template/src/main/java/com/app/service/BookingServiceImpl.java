package com.app.service;

import java.time.LocalDate;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookingDao;
import com.app.dao.BusDao;
import com.app.dao.PaymentDao;
import com.app.dto.ApiResponse;
import com.app.dto.BookingDto;
import com.app.entities.Booking;
import com.app.entities.Bus;
import com.app.entities.Payment;

import custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private BusDao busDao;

	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PaymentDao paymentdao;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addNewBooking(@Valid BookingDto dto) {

		Bus bus = busDao.findById(dto.getBusid())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Bus Id !!!!"));
		if (dto.getNoOfSeats() <= bus.getAvailableSeats()) {
      Payment payment = paymentdao.findById(dto.getPaymentid()).orElseThrow(()->new ResourceNotFoundException("Invalid id"));
			if (paymentService.isPaymentSucessful(dto.getPaymentid())) {
				Booking book = bookingDao.save(mapper.map(dto, Booking.class));
				book.setBookingDate(LocalDate.now());
				book.setBookingStatus(true);
				book.setPaymentStatus(true);
				book.setBus(bus);
				book.setPayment(payment);
				

			} else {

				return new ApiResponse("Payment Not Sucessfull.... ");
			}

		} else {

			return new ApiResponse("Seats Not Available ");
		}

		return new ApiResponse("Booking Done ");
	}
}
