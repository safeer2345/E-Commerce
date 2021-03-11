package com.aitrich.order.request;

import java.util.List;

public class OrderRequest {

	private long customerId;
	private List<OrderItemRequest> itemList;

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderRequest(long customerId, List<OrderItemRequest> itemList) {
		super();
		this.customerId = customerId;
		this.itemList = itemList;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public List<OrderItemRequest> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItemRequest> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "OrderDto [customerId=" + customerId + ", itemList=" + itemList + "]";
	}

}
