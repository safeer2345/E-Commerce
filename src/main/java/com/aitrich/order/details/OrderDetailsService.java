package com.aitrich.order.details;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.OrderDetails;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface OrderDetailsService {
	
	public Uni<List<OrderDetails>> saveOrderDetails(List<OrderDetails> orderDetailsList );
	
	public Uni<List<OrderDetails>> findAll();
	
	public Uni<Long> deleteByOrderId(Long orderId);
	
	//pulbi

}
