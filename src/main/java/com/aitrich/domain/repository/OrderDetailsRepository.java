package com.aitrich.domain.repository;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.OrderDetails;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class OrderDetailsRepository implements PanacheRepository<OrderDetails>{
	
	public Uni<Long> deleteByOrderId(Long order_id) {
       return delete("order_id", order_id);
    }

}
