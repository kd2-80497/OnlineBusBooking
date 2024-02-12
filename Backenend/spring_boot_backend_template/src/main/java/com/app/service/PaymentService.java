package com.app.service;

import javax.validation.Valid;

import com.app.dto.ApiResponse;
import com.app.dto.PaymentDto;

public interface PaymentService {
	public boolean isPaymentSucessful(Long paymentid);

	ApiResponse addNewPayment(@Valid PaymentDto dto);

}
