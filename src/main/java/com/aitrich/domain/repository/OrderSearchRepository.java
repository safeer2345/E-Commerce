package com.aitrich.domain.repository;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.OrderSearch;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
@ApplicationScoped
public class OrderSearchRepository implements PanacheRepository<OrderSearch>{
	
	

}
