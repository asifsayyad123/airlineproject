package com.org.asf.service;

import java.util.List;

import com.org.asf.dto.AirlineInfoDTO;

public interface AirlineService {

	AirlineInfoDTO addAirlineInfo(AirlineInfoDTO airline);
	
	int removeAirlineInfo(String name);
	
	List<AirlineInfoDTO> getAllAirlines();
}
