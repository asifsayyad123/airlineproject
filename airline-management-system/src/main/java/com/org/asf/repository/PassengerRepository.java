package com.org.asf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.asf.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
