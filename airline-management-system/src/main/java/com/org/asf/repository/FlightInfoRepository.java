package com.org.asf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.asf.entity.Flight;
import com.org.asf.entity.FlightInfo;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Integer>{

	Optional<Flight> findByFlightNumber(String flightNumber);
}
