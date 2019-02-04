package com.hackerrank.sample.controller;

import com.hackerrank.sample.model.Customer;
import com.hackerrank.sample.model.Model;
import com.hackerrank.sample.model.Vendor;
import com.hackerrank.sample.service.CustomerService;
import com.hackerrank.sample.service.ModelService;
import com.hackerrank.sample.service.VendorService;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private VendorService vendorService;
	
	
	 	@RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = "application/json")
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<Customer> createNewModel(@RequestBody Customer customer) {			
	        customerService.createModel(customer);	        
	        return new ResponseEntity<>(customer, HttpStatus.CREATED);
	    }
	
	 	@DeleteMapping(value = "/erase")
	    @ResponseStatus(HttpStatus.OK)
	    public void deleteAllModels() {
	        customerService.deleteAllModels();
	    }
	 
	 	@DeleteMapping(value = "/customer/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public void deleteModelById(@PathVariable long id) {
		 customerService.deleteModelById(id);
	    }
	 
	 	@GetMapping(value = "/customer")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<List<Customer>> getAllModels() {
		 if(customerService.getAllModels().size()>0)
		 {
			 return new ResponseEntity<List<Customer>>(customerService.getAllModels(),HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<List<Customer>>(customerService.getAllModels(),HttpStatus.NOT_FOUND);
		 }
	       
	    }

	    @GetMapping(value = "/customer/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<Customer> getModelById(@PathVariable long id) {
	    	
	    	if(customerService.getModelById(id) !=null)
	    	{
	    		return new ResponseEntity<Customer>(customerService.getModelById(id),HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<Customer>(customerService.getModelById(id),HttpStatus.NOT_FOUND);
	    	}	    	
	       
	    }
	 
	    @PutMapping(value = "/customer{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<Customer> updateModelByID(@RequestBody Customer customer, @PathVariable Long id)
	    {
	    	Customer respCustomer=customerService.updateModelById(customer,id);
	    	
	    	if(null != respCustomer)
	    	{
	    		return new ResponseEntity<Customer>(respCustomer,HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<Customer>(respCustomer,HttpStatus.NOT_FOUND);
	    	}	    	
	    	
	    }
	    
	    
	    @GetMapping(value = "/vendor")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<List<Vendor>> getAllVendors() {
		 if(vendorService.getAllModels().size()>0)
		 {
			 return new ResponseEntity<List<Vendor>>(vendorService.getAllModels(),HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<List<Vendor>>(vendorService.getAllModels(),HttpStatus.NOT_FOUND);
		 }
	       
	    }
	    
	    @GetMapping(value = "/vendor/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<Vendor> getVendorByID(@PathVariable long id) {
	    	
	    	if(vendorService.getModelById(id) !=null)
	    	{
	    		return new ResponseEntity<Vendor>(vendorService.getModelById(id),HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<Vendor>(vendorService.getModelById(id),HttpStatus.NOT_FOUND);
	    	}	    	
	       
	    }
	    
	    
	    @PostMapping(value = "/vendor", consumes = "application/json")
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<Vendor> createNewVendor(@RequestBody Vendor vendor) {			
	        vendorService.createModel(vendor);	        
	        return new ResponseEntity<>(vendor, HttpStatus.CREATED);
	    }
	    
	    @PutMapping(value = "/vendor{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<Vendor> updateVendorById(@RequestBody Vendor vendor, @PathVariable Long id)
	    {
	    	Vendor respVendor=vendorService.updateModelById(vendor,id);
	    	
	    	if(null != respVendor)
	    	{
	    		return new ResponseEntity<Vendor>(respVendor,HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<Vendor>(respVendor,HttpStatus.NOT_FOUND);
	    	}	    	
	    	
	    }
	    
	    @DeleteMapping(value = "/vendor/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public void deleeVendorByID(@PathVariable long id) {
		 vendorService.deleteModelById(id);
	    }
	 
	    @DeleteMapping(value = "/vendor")
	    @ResponseStatus(HttpStatus.OK)
	    public void deleteAllVendors() {
	        vendorService.deleteAllModels();
	    }
	    
	
   /* @Autowired
    private ModelService modelService;

    @RequestMapping(value = "/model", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewModel(@RequestBody @Valid Model model) {
        modelService.createModel(model);
    }

    @RequestMapping(value = "/erase", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllModels() {
        modelService.deleteAllModels();
    }

    @RequestMapping(value = "/model/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteModelById(@RequestParam Long id) {
        modelService.deleteModelById(id);
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @RequestMapping(value = "/model/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Model getModelById(Long id) {
        return modelService.getModelById(id);
    }*/
}
