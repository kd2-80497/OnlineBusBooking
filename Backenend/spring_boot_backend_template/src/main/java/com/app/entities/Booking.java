package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booking")
@Getter
@Setter
public class Booking extends BaseEntity {
	@Column(length = 20, unique = true)
	private int bookingId;
	@Column(length=30)
	private String source;
	@Column(length=30)
	private String destination;
	@Column(length=30)
	private String noOfSeats;
	@Column(length=30)
	private String BookingDate;
	public Booking(int bookingId, String source, String destination, String noOfSeats, String bookingDate) {
		super();
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.noOfSeats = noOfSeats;
		BookingDate = bookingDate;
	}
	
	
	

}
