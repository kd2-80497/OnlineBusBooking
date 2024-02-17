package com.app.service;

import java.time.LocalDate;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BookingDao;
import com.app.dao.BusDao;
import com.app.dao.PaymentDao;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.BookingDto;
import com.app.dto.BusDto;
import com.app.entities.Booking;
import com.app.entities.Bus;
import com.app.entities.Payment;
import com.app.entities.User;

import custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private BusDao busDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PaymentDao paymentdao;
	@Autowired
	private ModelMapper mapper;
	@Autowired 
	private BusService busService;

	@Override
	public ResponseEntity<?> addNewBooking(@Valid BookingDto dto) {

		
		Booking booking = new Booking();
		
		booking.setNoOfSeats(dto.getNoOfSeats());
		
		Bus bus = busDao.findById(dto.getBusid())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Bus Id !!!!"));
		
		User user = userDao.findById(dto.getUserid()).orElseThrow(() -> new ResourceNotFoundException("Invalid Bus Id !!!!"));
		
		
		
		if(bus.getAvailableSeats()<=0) {
			return new ResponseEntity<String>("Seats are not available.", HttpStatus.BAD_REQUEST);
		}
		else if (booking.getNoOfSeats()>bus.getAvailableSeats()) {
			return new ResponseEntity<String>("Only "+ bus.getAvailableSeats()+ " are available.", HttpStatus.BAD_REQUEST);
		}
		else {
			int remainingSeat = bus.getAvailableSeats()-booking.getNoOfSeats();
			bus.setAvailableSeats(remainingSeat);
			
			BusDto busdto = new BusDto(bus.getId(),bus.getBusNo(),bus.getCapacity(),
					bus.getSource(),bus.getDestination(),bus.getTravelDate(),bus.getDepartureTime(),
					bus.getArrivalTime(),bus.getFare(),bus.getAvailableSeats());
			
			busService.updateBus(dto.getBusid(), busdto);
			
		
			
			booking.setBusType(dto.getBusType());
			booking.setBookingDate(LocalDate.now());
			booking.setBus(bus);
			booking.setUser(user);
		booking.setBookingStatus(false);
		booking.setPaymentStatus(false);
		return new ResponseEntity<>(mapper.map(booking, BookingDto.class), HttpStatus.OK);
			
			
		}
		
//		Bus bus = busDao.findById(dto.getBusid())
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid Bus Id !!!!"));
//		if (dto.getNoOfSeats() <= bus.getAvailableSeats()) {
//			Payment payment = paymentdao.findById(dto.getPaymentid())
//					.orElseThrow(() -> new ResourceNotFoundException("Invalid id"));
//			if (paymentService.isPaymentSucessful(dto.getPaymentid())) {
//				Booking book = bookingDao.save(mapper.map(dto, Booking.class));
//				book.setBookingDate(LocalDate.now());
//				book.setBookingStatus(true);
//				book.setPaymentStatus(true);
//				book.setBus(bus);
//				book.setPayment(payment);
//				book.setUser(userDao.findById(dto.getUserid()).orElseThrow(() -> new ResourceNotFoundException("Invalid Bus Id !!!!")));
//
//			} else {
//
//				return new ApiResponse("Payment Not Sucessfull.... ");
//			}
//
//		} else {
//
//			return new ApiResponse("Seats Not Available ");
//		}
//
//		return new ApiResponse("Booking Done ");
	}
	
	
	
}
