package com.aitrich.domain.repository;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.Customer;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

}
