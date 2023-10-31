package com.ms.proj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.proj.entity.Customer;
import com.ms.proj.exception.ResourseNotFoundException;
import com.ms.proj.repository.CustomerRepository;

@Component
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer customer2 = customerRepository.save(customer);
		return customer2;
	}

	@Override
	public Customer updateCustomer(long id, Customer updatedCustomer) {
		// TODO Auto-generated method stub
		Customer existingCustomer = customerRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Resourse not found!!"));
		if (existingCustomer != null) {
			existingCustomer.setFirstName(updatedCustomer.getFirstName());
			existingCustomer.setLastName(updatedCustomer.getLastName());
			existingCustomer.setCity(updatedCustomer.getCity());
			Customer updated = customerRepository.save(existingCustomer);
			return updated;
		}
		else {
			throw new ResourseNotFoundException("Record not found!!");
		}
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	@Override
	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Record not found!!"));
		return customer;
	}

	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub
		customerRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Record not found!!"));
		customerRepository.deleteById(id);
	}

	@Override
	public Customer patchCustomer(long id, Map<String, Object> updates) {
		// Get the existing customer by ID
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Resource not found!!"));

        // Apply partial updates to the existing customer
        if (updates.containsKey("firstName")) {
            existingCustomer.setFirstName((String) updates.get("firstName"));
        }
        if (updates.containsKey("lastName")) {
            existingCustomer.setLastName((String) updates.get("lastName"));
        }
        if (updates.containsKey("city")) {
            existingCustomer.setCity((String) updates.get("city"));
        }

        // Save the updated customer
        Customer patchedCustomer = customerRepository.save(existingCustomer);
        return patchedCustomer;
	}
}