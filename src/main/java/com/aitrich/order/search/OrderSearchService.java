package com.aitrich.order.search;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.OrderSearch;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface OrderSearchService {
	
	public Uni<Boolean> saveOrderIntoOrderSearch(List<OrderSearch> orderSearch);
	
	public Uni<OrderSearch> updateoOrderSearchOrder(OrderSearch orderSearch);
	
	public Uni<Boolean> deleteOrderSearchOrder(long orderId);
	
	public Uni<List<OrderSearch>> findAllOrderFromOrderSearch();
}
