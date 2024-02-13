package com.app.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentReqDTO {
	@NotNull(message ="Booking Id required!!!!")
	private Long BookId;
	private String paymentStatus;
	private String paymentDate;
	private double totalPayment;
	
	

}
