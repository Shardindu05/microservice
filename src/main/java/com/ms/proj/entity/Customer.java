package com.ms.proj.entity;

//import java.util.List;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name= "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "customer_id")
	private long customerId;
	
	@Size(min= 2)
	@Column(name= "first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Size(min= 2)
	@Column(name= "city")
	private String city;
	
//	@JsonManagedReference
//	@OneToMany(fetch= FetchType.LAZY, mappedBy= "customer", cascade = {CascadeType.ALL})
//	private List<Order> orders;

	public Customer() {
		
	}

	public Customer(String firstName, String lastName, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}