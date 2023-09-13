package com.org.asf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.asf.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
