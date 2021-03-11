package com.aitrich.order.request.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.Customer;
import com.aitrich.domain.entity.OrderDetails;
import com.aitrich.domain.entity.OrderEntity;
import com.aitrich.domain.entity.Product;
import com.aitrich.order.request.OrderRequest;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
@ApplicationScoped
public  class OrderEntityConverter  {


	public OrderEntity convert(OrderRequest value) {
		// TODO Auto-generated method stub
		List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
		value.getItemList().forEach(item -> {
			orderDetails.add(new OrderDetails(0, new Product(item.getProductId(), null, null), item.getQuantity()));
		});
		return new OrderEntity(0,LocalDateTime.now(),new Customer(value.getCustomerId(),null,null),new HashSet<OrderDetails>(orderDetails));
	}
}
