package com.hackerrank.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackerrank.sample.excpetion.BadResourceRequestException;
import com.hackerrank.sample.excpetion.NoSuchResourceFoundException;
import com.hackerrank.sample.model.Customer;
import com.hackerrank.sample.model.Inventory;
import com.hackerrank.sample.model.Vendor;
import com.hackerrank.sample.repository.CustomerRepository;
import com.hackerrank.sample.repository.InventoryRepository;

public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryRepository invRepo;
	
	

    @Override
    public void deleteAllModels() {
    	invRepo.deleteAllInBatch();
    }

    @Override
    public void deleteModelById(Long id) {
    	
    	invRepo.deleteBySkuId(id);
    }

    @Override
    public void createModel(Inventory inv) {
        Inventory existingInv = invRepo.findOne(inv.getSkuId());

        if (existingInv != null) {
            throw new BadResourceRequestException("Model with same id exists.");
        }

        invRepo.save(inv);
    }

    @Override
    public Inventory getModelById(Long id) {
        Inventory inv = invRepo.findOne(id);

        if (inv == null) {
            throw new NoSuchResourceFoundException("No model with given id found.");
        }

        return inv;
    }

    @Override
    public List<Inventory> getAllModels() {
        return invRepo.findAll();
    }

	@Override
	public Inventory updateModelById(Inventory inv,Long id) {
		
		Inventory tempInv=invRepo.getOne(id);
			
		if(null != tempInv)
		{
			tempInv.setInventoryOnHand(inv.getInventoryOnHand());
			tempInv.setMinQtyReq(inv.getMinQtyReq());
			tempInv.setPrice(inv.getPrice());
			tempInv.setProductLabel(inv.getProductLabel());
			tempInv.setProductName(inv.getProductName());
			
			invRepo.save(tempInv);
			return tempInv;
		}
		
		return null;
	}
	

    

}
