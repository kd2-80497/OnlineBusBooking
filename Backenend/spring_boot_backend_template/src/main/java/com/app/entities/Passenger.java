package com.app.entities;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="passenger")
@Getter
@Setter


public class Passenger extends BaseEntity{

	@Column(length=30)
	private String firstName;
	@Column(length=30)
	private String lastName;

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
	   
	   
	   
	    
	    

}
