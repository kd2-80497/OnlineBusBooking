package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="payment")
@Getter
@Setter
public class Payment extends BaseEntity {
	@Column(length = 50)
	 private Long transactionId;
	@Column(length=50)
	 private String paymentStatus;
      private LocalDate date;
      
	  private double totalAmount;

		public Payment(Long transactionId, String paymentStatus, LocalDate date, double totalAmount) {
			super();
			this.transactionId = transactionId;
			this.paymentStatus = paymentStatus;
			this.date = date;
			this.totalAmount = totalAmount;
		}
	    

}
