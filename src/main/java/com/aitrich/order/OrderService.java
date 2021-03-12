package com.aitrich.order;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.Category;
import com.aitrich.domain.entity.OrderDetails;
import com.aitrich.domain.entity.PurchaseOrder;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface OrderService {
	
	public Uni<PurchaseOrder> saveOrder(PurchaseOrder orderEntity);
	
	public Uni<Long> deleteOneOrderItem(long oId,long oDId,Set<OrderDetails> orderDetails);

	public Uni<PurchaseOrder> findOrderById(Long cid);
	
	public Uni<List<PurchaseOrder>> findAllOrders();

	public Uni<Boolean> deleteOrderById(Long cid);

}
