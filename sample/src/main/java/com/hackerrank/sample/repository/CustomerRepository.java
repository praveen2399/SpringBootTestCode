package com.hackerrank.sample.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.sample.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Transactional
    Long deleteByCustomerID(Long customerID);

}
