package com.hackerrank.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.sample.excpetion.BadResourceRequestException;
import com.hackerrank.sample.excpetion.NoSuchResourceFoundException;
import com.hackerrank.sample.model.Customer;
import com.hackerrank.sample.model.Vendor;
import com.hackerrank.sample.repository.CustomerRepository;
import com.hackerrank.sample.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorRepository vendorRepo;
	
	

    @Override
    public void deleteAllModels() {
    	vendorRepo.deleteAllInBatch();
    }

    @Override
    public void deleteModelById(Long id) {
    	
    	vendorRepo.deleteByVendorId(id);
    }

    @Override
    public void createModel(Vendor vendor) {
        Vendor existingVendor = vendorRepo.findOne(vendor.getVendorId());

        if (existingVendor != null) {
            throw new BadResourceRequestException("Model with same id exists.");
        }

        vendorRepo.save(vendor);
    }

    @Override
    public Vendor getModelById(Long id) {
        Vendor vendor = vendorRepo.findOne(id);

        if (vendor == null) {
            throw new NoSuchResourceFoundException("No model with given id found.");
        }

        return vendor;
    }

    @Override
    public List<Vendor> getAllModels() {
        return vendorRepo.findAll();
    }

	@Override
	public Vendor updateModelById(Vendor vendor,Long id) {
		
		Vendor tempVendor=vendorRepo.getOne(id);
			
		if(null != tempVendor)
		{
			tempVendor.setVendorAddress(vendor.getVendorAddress());
			tempVendor.setVendorContactNo(vendor.getVendorContactNo());
			tempVendor.setVendorEmail(vendor.getVendorEmail());
			tempVendor.setVendorUsername(vendor.getVendorUsername());
			tempVendor.setVendorName(vendor.getVendorName());
			vendorRepo.save(tempVendor);
			return tempVendor;
		}
		
		return null;
	}

}
