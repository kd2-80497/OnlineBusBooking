package com.app.entities;
import javax.persistence.*;

<<<<<<< HEAD
import lombok.Getter;
=======
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
>>>>>>> main
import lombok.Setter;

@Entity
@Table(name="passenger")
<<<<<<< HEAD
@Getter
@Setter


public class Passenger extends BaseEntity{

=======

@Getter
@Setter
@NoArgsConstructor
public class Passenger extends BaseEntity {
	
>>>>>>> main
	@Column(length=30)
	private String firstName;
	@Column(length=30)
	private String lastName;
<<<<<<< HEAD

     private String gender;
	 private int age;
	 private int seatNo;
		
	 public Passenger(String firstName, String lastName, String gender, int age, int seatNo) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.age = age;
			this.seatNo = seatNo;
		}
	   
	   
	   
	    
	    
=======
	@Column(length=30)
	private String gender;
	
	private int age;
	
	@Column(name="seat_number")
	private int seatNumber;
	
	
	
	@OneToOne
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	public Passenger(String firstName, String lastName, String gender, int age, int seatNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.seatNumber = seatNumber;
	}
	
	
	
>>>>>>> main

}
