package com.org.asf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.asf.entity.AirlineInfo;

public interface AirlineInfoRepository extends JpaRepository<AirlineInfo, Integer>{

	Optional<AirlineInfo> findByAirlineName(String name);
}
