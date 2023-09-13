package com.org.asf.serviceImpl;

import org.springframework.stereotype.Service;

import com.org.asf.dto.FareDTO;
import com.org.asf.entity.Fare;
import com.org.asf.repository.FareRepository;
import com.org.asf.service.FareService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FareServiceImpl implements FareService {

	private final FareRepository fareRepository;

	@Override
	public int addFare(FareDTO fare) {
		return fareRepository.save(Fare.builder().amount(fare.getAmount()).currency(fare.getCurrency()).build())
				.getFareId();
	}

}
