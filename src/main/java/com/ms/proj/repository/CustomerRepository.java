package com.ms.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.proj.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}