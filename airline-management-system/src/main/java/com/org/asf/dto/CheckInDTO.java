package com.org.asf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CheckInDTO {

	private String seatNumber;
	private String gateNumber;
	private PassengerDTO passengerDTO;
}
