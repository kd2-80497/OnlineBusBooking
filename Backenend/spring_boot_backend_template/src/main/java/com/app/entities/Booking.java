package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor

public class Booking  extends BaseEntity{
	@Column(name="no_of_seats")
	private int noOfSeats;
	
	@Column(name="booking_status")
	private String bookingStatus;
	
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@Enumerated(EnumType.STRING) // col : varchar => enum constant name
	@Column(length = 30)
	private BusType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bus_id")
	private Bus bus; 
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_id")
	private Payment payment; 


	public Booking(int noOfSeats, String bookingStatus, String paymentStatus, LocalDate bookingDate, BusType type) {
		super();
		this.noOfSeats = noOfSeats;
		this.bookingStatus = bookingStatus;
		this.paymentStatus = paymentStatus;
		this.bookingDate = bookingDate;
		this.type = type;
	}

	
}
