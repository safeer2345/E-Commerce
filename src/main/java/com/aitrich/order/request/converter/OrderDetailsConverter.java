package com.aitrich.order.request.converter;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.OrderDetails;

import com.aitrich.domain.entity.Product;
import com.aitrich.order.request.OrderRequest;


@ApplicationScoped
public class OrderDetailsConverter {

	public List<OrderDetails> convert(OrderRequest value, long orderId) {
		
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
		value.getItemList().forEach(item -> {
			orderDetails.add(new OrderDetails(0, new Product(item.getProductId(), null, null), item.getQuantity()));
		});
		return orderDetails;
	}

}
