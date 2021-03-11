package com.aitrich.domain.repository;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.Product;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

}
