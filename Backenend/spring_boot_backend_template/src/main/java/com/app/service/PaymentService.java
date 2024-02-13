package com.app.service;

import java.util.List;

import com.app.dto.PaymentRespDTO;
import com.app.entities.Payment;

public interface PaymentService {
	   public PaymentRespDTO getPaymentById(Long paymentId);
	    

	    public List<Payment> getAllPayments();
	    

	    public Payment savePayment(Payment payment) ;
	     

	    public void deletePayment(Long paymentId);


		String cancelBooking(Long bookingid);

}
