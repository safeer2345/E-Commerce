package com.aitrich.order.search.converter;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.hibernate.internal.CriteriaImpl.OrderEntry;

import com.aitrich.domain.entity.OrderDetails;
import com.aitrich.domain.entity.OrderSearch;
import com.aitrich.domain.entity.PurchaseOrder;

@ApplicationScoped
public class OrderEntityToOrderSearch {

	public List<OrderSearch> convert(PurchaseOrder purchaseOrder)
	{
		System.out.println("PurchaseOrder"+purchaseOrder);
		List<OrderSearch> orderSearchList=new ArrayList<OrderSearch>();
		
		for(OrderDetails od:purchaseOrder.getOrderDetails())
		{
			OrderSearch orderSearch= new OrderSearch(purchaseOrder.getCustomer().getId()
					,purchaseOrder.getCustomer().getName(),purchaseOrder.getCustomer()
					.getAddress(),purchaseOrder.getOrderId(),purchaseOrder.getDate()
					,od.getId(),od.getProduct().getId(),od.getProduct().getProductName()
					,od.getProduct().getCategory().getCategoryId(),od.getProduct()
					.getCategory().getCategoryName(),od.getQuantity());
			orderSearchList.add(orderSearch);
		}
		return orderSearchList;
	}

}
