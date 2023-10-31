package com.ms.proj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.proj.entity.Customer;
import com.ms.proj.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
	        Customer customer = customerService.getCustomerById(id);
	        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	    }

	    @GetMapping("/list")
	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        List<Customer> list = customerService.getAllCustomers();
	        return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	    }

	    @PostMapping("/create")
	    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer Customer) {
	        Customer customer2 = customerService.createCustomer(Customer);
	        return new ResponseEntity<Customer>(customer2, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
	        Customer customer2 = customerService.updateCustomer(id, customer);
	        return new ResponseEntity<Customer>(customer2, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public HttpStatus deleteCustomer(@PathVariable long id) {
	        customerService.deleteCustomer(id);
	        return HttpStatus.OK;
	    }
	    
	    @PatchMapping("/{id}")
	    public ResponseEntity<Customer> patchCustomer(@PathVariable long id, @RequestBody Map<String, Object> updates) {
	        Customer patchedCustomer = customerService.patchCustomer(id, updates);
	        return new ResponseEntity<>(patchedCustomer, HttpStatus.OK);
	    }
}