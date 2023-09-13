package com.org.asf.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.org.asf.dto.AirlineInfoDTO;
import com.org.asf.entity.AirlineInfo;
import com.org.asf.repository.AirlineInfoRepository;
import com.org.asf.service.AirlineService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AirlineInfoServiceImple implements AirlineService {

	private final AirlineInfoRepository airlineInfoRepository;

	@Override
	public AirlineInfoDTO addAirlineInfo(AirlineInfoDTO airline) {
		log.info("Airline name {} " + airline.getAirlineName());
		AirlineInfo airlineInfo = airlineInfoRepository
				.save(AirlineInfo.builder().airlineName(airline.getAirlineName()).build());
		return AirlineInfoDTO.builder().airlineName(airlineInfo.getAirlineName()).build();
	}

	@Override
	public int removeAirlineInfo(String name) {
		Optional<AirlineInfo> airline = airlineInfoRepository.findByAirlineName(name);
		if(airline.isPresent()) {
			airlineInfoRepository.delete(airline.get());
			return 1;	
		}
		return 0;
	}

	@Override
	public List<AirlineInfoDTO> getAllAirlines() {
		return airlineInfoRepository.findAll().stream()
				.map(t -> AirlineInfoDTO.builder().airlineName(t.getAirlineName()).airlineId(t.getAirlineId()).build()).toList();
	}

}














