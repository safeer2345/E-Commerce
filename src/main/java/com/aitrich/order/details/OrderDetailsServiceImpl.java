package com.aitrich.order.details;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.aitrich.domain.entity.OrderDetails;
import com.aitrich.domain.repository.OrderDetailsRepository;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Inject
	OrderDetailsRepository orderDetailsRepo;
	@Override
	public Uni<List<OrderDetails>> findAll() {
		// TODO Auto-generated method stub
		return orderDetailsRepo.findAll().list();
	}
	@Override
	public Uni<List<OrderDetails>> saveOrderDetails(List<OrderDetails> orderDetailsList) {
		// TODO Auto-generated method stub
		return orderDetailsRepo.persist(orderDetailsList).chain(orderDetailsRepo :: flush).onItem().transform(ignore -> orderDetailsList);
	}
	@Override
	public Uni<Long> deleteByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		return orderDetailsRepo.deleteByOrderId(orderId);
	}
	
	

}
