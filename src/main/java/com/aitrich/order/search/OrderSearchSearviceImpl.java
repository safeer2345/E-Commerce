package com.aitrich.order.search;

import java.util.List;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.reactive.mutiny.Mutiny;

import com.aitrich.domain.entity.Customer;
import com.aitrich.domain.entity.OrderSearch;
import com.aitrich.domain.repository.OrderRepository;
import com.aitrich.domain.repository.OrderSearchRepository;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Transactional
public class OrderSearchSearviceImpl implements OrderSearchService{
	
	@Inject
	OrderSearchRepository orderSearchRepository;
	
//	@Inject
//	Mutiny.Session session;

	@Override
	public Uni<Boolean> saveOrderIntoOrderSearch(List<OrderSearch> orderSearch) {
		// TODO Auto-generated method stub
		System.out.println("entered");
		return orderSearchRepository.persist(orderSearch).chain(orderSearchRepository :: flush).onItem().transform(ignore -> true);
	}

	@Override
	public Uni<OrderSearch> updateoOrderSearchOrder(OrderSearch orderSearch) {
		// TODO Auto-generated method stub
		Function<OrderSearch, Uni<? extends OrderSearch>> update = entity -> {
			entity.setCategoryName(entity.getCategoryName());
			entity.setCustomerAddress(entity.getCustomerAddress());
			entity.setCustomerName(entity.getCustomerName());
			entity.setProductName(entity.getProductName());
			return orderSearchRepository.flush().onItem().transform(ignore -> entity);
		};
		
		return orderSearchRepository.findById(orderSearch.getPurchaseOrderId()).onItem().ifNotNull().transformToUni(update);
	}

	@Override
	public Uni<Boolean> deleteOrderSearchOrder(long orderId) {
		// TODO Auto-generated method stub
		return orderSearchRepository.deleteById(null).onItem().transform(ignore -> true);
	}

	@Override
	public Uni<List<OrderSearch>> findAllOrderFromOrderSearch() {
		// TODO Auto-generated method stub
		return orderSearchRepository.findAll().list();
	}
	
	

}
