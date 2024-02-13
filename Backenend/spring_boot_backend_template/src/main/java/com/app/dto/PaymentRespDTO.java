package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentRespDTO {
	private Long id;
	
	private String transactionNo;

	private String paymentStatus;

	private String paymentDate;
	
	private double totalPayment;

	private Long bookingId;
	
	private Long userId;

}
