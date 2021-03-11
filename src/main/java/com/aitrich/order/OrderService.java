package com.aitrich.order;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.Category;
import com.aitrich.domain.entity.OrderDetails;
import com.aitrich.domain.entity.OrderEntity;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface OrderService {
	
	public Uni<OrderEntity> saveOrder(OrderEntity orderEntity);
	
	public Uni<Long> deleteOneOrderItem(long oId,long oDId,Set<OrderDetails> orderDetails);

	public Uni<OrderEntity> findOrderById(Long cid);
	
	public Uni<List<OrderEntity>> findAllOrders();

	public Uni<Boolean> deleteOrderById(Long cid);

}
