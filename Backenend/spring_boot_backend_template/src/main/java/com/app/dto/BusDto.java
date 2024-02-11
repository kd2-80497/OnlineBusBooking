package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BusDto {
	
	@JsonProperty(access = Access.READ_ONLY) // used during serialization
	private Long id;
	
	@NotBlank
	private String busNo;
	
	@NotNull
	private int  capacity;
	
	@NotBlank
	private String source;
	
	@NotBlank
	private String destination;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate travelDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") 
	private LocalDateTime departureTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") 
	private LocalDateTime arrivalTime;
	
	@NotNull
	private double fare;
	
	@NotNull
	private int availableSeats;
}
