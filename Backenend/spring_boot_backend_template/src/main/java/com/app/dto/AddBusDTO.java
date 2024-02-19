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
public class AddBusDTO {
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
	

}
