package com.org.asf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.asf.entity.BookingInfo;

public interface BookingInfoRepository extends JpaRepository<BookingInfo, Integer>{

}
