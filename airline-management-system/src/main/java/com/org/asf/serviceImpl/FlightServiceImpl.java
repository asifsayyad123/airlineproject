package com.org.asf.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.asf.dto.FareDTO;
import com.org.asf.dto.FlightDTO;
import com.org.asf.dto.InventoryDTO;
import com.org.asf.entity.Flight;
import com.org.asf.repository.FareRepository;
import com.org.asf.repository.FlightInfoRepository;
import com.org.asf.repository.FlightRepository;
import com.org.asf.repository.InventoryRepository;
import com.org.asf.service.FlightService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightServiceImpl implements FlightService {

	private final FlightRepository flightRepository;

	private final FlightInfoRepository flightInfoRepository;

	private final FareRepository fareRepository;

	private final InventoryRepository inventoryRepository;

	@Override
	public int addFlight(FlightDTO flightDTO, int flightInfoId, int fareId, int inventoryId) {

		return flightRepository
				.save(Flight.builder().currentCity(flightDTO.getCurrentCity()).destination(flightDTO.getDestination())
						.duration(flightDTO.getDuration()).flightDate(flightDTO.getFlightDate())
						.flightNumber(flightInfoRepository.findById(flightInfoId).get().getFlightNumber())
						.flightTime(flightDTO.getFlightTime()).fare(fareRepository.findById(fareId).get())
						.inventory(inventoryRepository.findById(inventoryId).get())
						.flightInfo(flightInfoRepository.findById(flightInfoId).get()).build())
				.getFlightId();
	}

	public List<FlightDTO> getAllFlights() {
		return flightRepository.findAll().stream()
				.map(flightDb -> FlightDTO.builder().currentCity(flightDb.getCurrentCity())
						.destination(flightDb.getDestination()).duration(flightDb.getDuration())
						.flightDate(flightDb.getFlightDate()).flightTime(flightDb.getFlightTime())
						.flightNumber(flightDb.getFlightNumber())
						.fare(FareDTO.builder().amount(flightDb.getFare().getAmount())
								.currency(flightDb.getFare().getCurrency()).build())
						.inventory(InventoryDTO.builder().count(flightDb.getInventory().getCount()).build()).build())
				.toList();
	}

	@Override
	public List<FlightDTO> searchByFlightNumber(String FlightNumber) {
		log.info("Info of flights {} " + flightRepository.findAll());
		return getAllFlights().stream().filter(flight -> flight.getFlightNumber().equals(FlightNumber)).toList();
	}

	public List<FlightDTO> searchByCurrentCityAndDestinationAndDate(FlightDTO flightDTO) {

		return getAllFlights().stream()
				.filter(flight -> flight.getCurrentCity().equals(flightDTO.getCurrentCity())
						&& flight.getDestination().equals(flightDTO.getDestination())
						&& flight.getFlightDate().equals(flightDTO.getFlightDate()))
				.toList();
	}
    
	@Override
	public List<FlightDTO> searchByCurrentCityAndDestinationAndDateAndTime(FlightDTO flightDTO) {
		return getAllFlights().stream()
				.filter(flight -> flight.getCurrentCity().equals(flightDTO.getCurrentCity())
						&& flight.getDestination().equals(flightDTO.getDestination())
						&& flight.getFlightDate().equals(flightDTO.getFlightDate())
						&& flight.getFlightTime().equals(flightDTO.getFlightTime()))
				.toList();
	}

}


















