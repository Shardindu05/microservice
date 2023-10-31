package com.ms.proj.entity;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;;

@Entity
@Table(name= "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "order_id")
	private long orderId;
	
	@Column(name= "order_date")
	private String orderDate;
	
	@Column(name= "amount")
	private int amount;
	
//	@JsonManagedReference
//	@ManyToOne
//	@JoinColumn(name= "customer_id")
//	private Customer customer;
	
	public Order() {
		
	}

	public Order(String orderDate, int amount) {
		super();
		this.orderDate = orderDate;
		this.amount = amount;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


}
