package com.org.asf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.asf.entity.CheckIn;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer>{

}
