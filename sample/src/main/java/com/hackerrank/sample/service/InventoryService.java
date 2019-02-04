package com.hackerrank.sample.service;

import java.util.List;

import com.hackerrank.sample.model.Inventory;



public interface InventoryService {
	
	void deleteAllModels();
    void deleteModelById(Long id);

    void createModel(Inventory inventory);

    Inventory getModelById(Long id);

    List<Inventory> getAllModels();
    
    Inventory updateModelById(Inventory inventory,Long id);

}
