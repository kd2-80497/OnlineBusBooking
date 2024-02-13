package com.app.entities;

import java.time.LocalDate;

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
import lombok.ToString;

@Entity
@Table(name="payment")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Payment  extends BaseEntity{

	@Column(name="transaction_no" , unique = true,nullable = false)
	private String transactionNo;
	
// <<<<<<< prerna
// 	@Column(name="payment_status")
// 	private String paymentStatus;
// =======
	
	@Column(name="payment_status")
	private boolean paymentStatus;

	
	@Column(name="payment_date")
	private LocalDate paymentDate;
	
	@Column(name="total_payment")
	private double totalPayment; 
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;

	public Payment(String transactionNo, boolean paymentStatus, LocalDate paymentDate, double totalPayment) {
		super();
		this.transactionNo = transactionNo;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
		this.totalPayment = totalPayment;
	}
	
	
}
