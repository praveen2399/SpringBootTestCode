package com.hackerrank.sample.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.sample.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
	@Transactional
    Long deleteBySkuId(Long skuID);

}
