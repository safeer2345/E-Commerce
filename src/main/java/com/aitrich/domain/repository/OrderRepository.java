package com.aitrich.domain.repository;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.PurchaseOrder;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<PurchaseOrder> {
	
//	public Uni<Long> deleteByOrderDetailsId(Long order_id) {
//	       return delete("orderentity_id", order_id);
//	    }

}
