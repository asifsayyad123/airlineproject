package com.org.asf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.asf.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{

}
