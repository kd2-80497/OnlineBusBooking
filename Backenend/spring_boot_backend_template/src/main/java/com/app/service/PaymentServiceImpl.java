package com.app.service;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.BookingDao;
import com.app.dao.PaymentDao;
import com.app.dto.PaymentRespDTO;
import com.app.entities.Booking;
import com.app.entities.Payment;
import com.app.entities.User;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	  @Autowired
    private final PaymentDao paymentRepository;
    @Autowired
    private BookingDao bookingDao;
    @Autowired
	private ModelMapper mapper;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentRespDTO getPaymentById(Long paymentId) {
    	
    	Payment payment=paymentRepository.findById(paymentId).orElseThrow(null);
    	
    	System.out.println(payment);
    	
    	Booking booking=payment.getBooking();
    	//User user=payment.getUser();
    	PaymentRespDTO paymentRespDTO=mapper.map(payment,PaymentRespDTO.class);
    	//paymentRespDTO.setUserId(user.getId());
    	paymentRespDTO.setBookingId(booking.getId());

        return paymentRespDTO;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
    @Override
	public String cancelBooking(@NotNull Long bookingid) 
	{
		//System.out.println(bookingDao.findById(bookingid));
		Booking booking=bookingDao.findById(bookingid).orElseThrow(() -> new ResourceNotFoundException("Booking not found"));		
      System.out.println(booking);
				booking.setBookingStatus("cancelled");
		Booking cancelledBooking = bookingDao.save(booking);
		if (cancelledBooking != null)
			return "Booking Cancelled Successfully " + cancelledBooking;
		return "Booking Cant be Cancelled";
	}

}
