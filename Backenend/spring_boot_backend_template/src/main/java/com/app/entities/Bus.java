package com.app.entities;

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

public class Bus extends BaseEntity {
	
	
	@Column(length = 20, unique = true)
	private String busNo;
//	@Column(length = 20, unique = true)
//	private String busTypeId;
	@Column(length = 20, unique = true)
	private String  capacity;
	@Column(length=30)
	private String source;
	@Column(length=30)
	private String destination;
	public Bus(String busNo,  String capacity, String source, String destination) {
		super();
		this.busNo = busNo;
//		this.busTypeId = busTypeId;
		this.capacity = capacity;
		this.source = source;
		this.destination = destination;
	}
	
	
	
	
	

}
