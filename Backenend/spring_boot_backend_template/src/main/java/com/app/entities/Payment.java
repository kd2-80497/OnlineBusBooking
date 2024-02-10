package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="payment")
@Getter
@Setter
@NoArgsConstructor
public class Payment  extends BaseEntity{

	@Column(name="transaction_no" , unique = true,nullable = false)
	private String transactionNo;
	@Column(name="payment_status")
	private String paymentStatus;
	@Column(name="payment_date")
	private String paymentDate;
	
	@Column(name="total_payment")
	private double totalPayment;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	public Payment(String transactionNo, String paymentStatus, String paymentDate, double totalPayment) {
		super();
		this.transactionNo = transactionNo;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.totalPayment = totalPayment;
	}
	
	
}
