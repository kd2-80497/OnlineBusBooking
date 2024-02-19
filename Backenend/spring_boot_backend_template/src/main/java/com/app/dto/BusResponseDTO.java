package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BusResponseDTO {
	
	private String busNo;
	

	private int  capacity;
	
	
	private String source;
	
	
	private String destination;
	
	
	private LocalDate travelDate;
	
	 
	private LocalDateTime departureTime;
	
	private LocalDateTime arrivalTime;

}
