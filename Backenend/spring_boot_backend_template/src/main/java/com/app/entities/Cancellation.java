package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cancellation")
@Getter
@Setter
public class Cancellation extends BaseEntity{
	@Column(length=30)
	private String refoundAmount;
	@Column(length=30)
	private String reason;
	@Column(name="canceldate")
	private LocalDate  CancelDate;
	
	public Cancellation(String refoundAmount, String reason, LocalDate cancelDate) {
		super();
		this.refoundAmount = refoundAmount;
		this.reason = reason;
		CancelDate = cancelDate;
	}
	
	
	
	
	
	

}
