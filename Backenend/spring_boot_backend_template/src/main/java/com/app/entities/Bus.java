package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bus")
@Getter
@Setter
@NoArgsConstructor
public class Bus extends BaseEntity {
	
	
	@Column(length = 20, unique = true)
	private String busNo;


	private int  capacity;
	@Column(length=30)
	private String source;
	@Column(length=30)
	private String destination;
	
	@Column(name="travel_date")
	private LocalDate travelDate;
	
	@Column(name="departure_time")
	private LocalTime departureTime;
	@Column(name="arrival_time")
	private LocalTime arrivalTime;
	
	

	private  double fare;
	
	@Column(name="available_seats")
	private int availableSeats;

	public Bus(String busNo, int capacity, String source, String destination, LocalDate travelDate,
			LocalTime departureTime, LocalTime arrivalTime, double fare, int availableSeats) {
		super();
		this.busNo = busNo;
		this.capacity = capacity;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.fare = fare;
		this.availableSeats = availableSeats;
	}
	

	
	
}
