package com.ms.proj.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ms.proj.entity.Customer;

@Service
public interface CustomerService {
	
	Customer createCustomer(Customer customer);

    Customer updateCustomer(long id, Customer updatedCustomer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(long id);

    void deleteCustomer(long id);
    
    Customer patchCustomer(long id, Map<String, Object> updates);
}