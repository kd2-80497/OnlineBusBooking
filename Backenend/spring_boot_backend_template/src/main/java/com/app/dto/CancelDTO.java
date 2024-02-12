package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CancelDTO {
	@NotBlank
	private String refoundAmount;
	@NotBlank
    private String reason;
	
    private LocalDate cancelDate;
    private Long bookingId; // Assuming you need the booking id in the DTO


}
