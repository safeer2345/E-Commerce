package com.aitrich.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderSearch {
	
	@Id
	@GeneratedValue
	private long orderSearchId;
	private long customerId;
	private String customerName;
	private String customerAddress;
	private long purchaseOrderId;
	private LocalDateTime purchaseOrderDate;
	private long orderDetailsId;
	private long productId;
	private String productName;
	private long categoryId;
	private String categoryName;
	private int quantity;
	
	public OrderSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderSearch(long customerId, String customerName, String customerAddress,
			long purchaseOrderId, LocalDateTime purchaseOrderDate, long orderDetailsId, long productId,
			String productName, long categoryId, String categoryName, int quantity) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.purchaseOrderId = purchaseOrderId;
		this.purchaseOrderDate = purchaseOrderDate;
		this.orderDetailsId = orderDetailsId;
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.quantity = quantity;
	}

	public long getOrderSearchId() {
		return orderSearchId;
	}

	public void setOrderSearchId(long orderSearchId) {
		this.orderSearchId = orderSearchId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public LocalDateTime getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(LocalDateTime purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

	public long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderSearch [orderSearchId=" + orderSearchId + ", customerId=" + customerId + ", customerName="
				+ customerName + ", customerAddress=" + customerAddress + ", purchaseOrderId=" + purchaseOrderId
				+ ", purchaseOrderDate=" + purchaseOrderDate + ", orderDetailsId=" + orderDetailsId + ", productId="
				+ productId + ", productName=" + productName + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", quantity=" + quantity + "]";
	}
}
