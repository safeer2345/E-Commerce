package com.aitrich.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orderentity")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long orderId;

	private LocalDateTime date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	@OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL},mappedBy = "order",orphanRemoval = true)
	@JsonIgnore
	//@org.hibernate.annotations.Cascade( {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	//@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonManagedReference
	private Set<OrderDetails> orderDetails=new HashSet<OrderDetails>();

	public OrderEntity() {
		super();
	}

	public OrderEntity(long orderId, LocalDateTime date, Customer customer, Set<OrderDetails> orderDetails) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.customer = customer;
		this.orderDetails = orderDetails;
	}
	
	

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long id) {
		this.orderId = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
		/*
		 * System.out.println("000000000000"+this); orderDetails.forEach(od -> {
		 * od.setOrder(this); }); this.setOrderDetails(orderDetails);
		 */
	}
	
	public void removeOrderDetail(OrderDetails orderDetails )
	{
		getOrderDetails().remove(orderDetails);
		//orderDetails.preRemover();
		orderDetails.setOrder(null);
		//getOrderDetails().remove(orderDetails);
		//orderDetails.setOrder(null);
		//getOrderDetails().clear();
		
	}
	
	public void addOrderDetail(OrderDetails orderDetails )
	{
		orderDetails.setOrder(this);
		this.orderDetails.add(orderDetails);
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", date=" + date + ", customer=" + customer + ", orderDetails="
				+ orderDetails + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (orderId ^ (orderId >>> 32));
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		OrderEntity other = (OrderEntity) obj;
//		if (orderId != other.orderId)
//			return false;
//		return true;
//	}

//	@Override
//	public String toString() {
//		return "OrderEntity [orderId=" + orderId + ", date=" + date + ", customer=" + customer 
//				+ "]";
//	}
	
	
	
	
}
