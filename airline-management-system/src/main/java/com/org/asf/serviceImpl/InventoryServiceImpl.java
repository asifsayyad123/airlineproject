package com.org.asf.serviceImpl;

import org.springframework.stereotype.Service;

import com.org.asf.dto.InventoryDTO;
import com.org.asf.entity.Inventory;
import com.org.asf.repository.InventoryRepository;
import com.org.asf.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

	private final InventoryRepository inventoryRepository;

	@Override
	public int addInventory(InventoryDTO inventory) {
		return inventoryRepository.save(Inventory.builder().count(inventory.getCount()).build()).getInventoryId();
	}

}
