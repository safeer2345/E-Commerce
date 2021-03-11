package com.aitrich.order.response;

import com.aitrich.domain.entity.Product;

public class OrderResponse {

	private int orderId;
	private Product product;
	private int quantity;

	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderResponse(int orderId, Product product, int quantity) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderResponse [orderId=" + orderId + ", product=" + product + ", quantity=" + quantity + "]";
	}

}
