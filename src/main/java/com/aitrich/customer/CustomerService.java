package com.aitrich.customer;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.Customer;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface CustomerService {

	public Uni<Customer> saveCustomer(Customer customer);

	public Uni<Customer> updateCustomer(Customer customer);

	public Uni<Customer> findCustomerById(Long cid);

	public Uni<List<Customer>> findAllCustomer();

	public Uni<Boolean> deleteCustomerById(Long cid);

}
