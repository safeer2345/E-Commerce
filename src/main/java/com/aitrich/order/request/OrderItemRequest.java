package com.aitrich.order.request;

public class OrderItemRequest {

	private long productId;
	private int quantity;

	public OrderItemRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItemRequest(long productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItemDto [productId=" + productId + ", quantity=" + quantity + "]";
	}
}
