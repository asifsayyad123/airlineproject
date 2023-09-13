package com.org.asf.service;

import java.util.List;
import java.util.Optional;

import com.org.asf.dto.FlighInfoDTO;

public interface FlightInfoService {

	Optional<FlighInfoDTO> addFlightInformation(FlighInfoDTO flightInfo, int airlineId);
	
	int removeFlightInfo(String flightNumber);
	
	FlighInfoDTO modifyFlightInformation(FlighInfoDTO flightInfoDto);
	
	List<FlighInfoDTO> getAllFlightInfo();
	
	List<FlighInfoDTO> getFlightInfoBasedOnAirlineName(String airlineName);
}
