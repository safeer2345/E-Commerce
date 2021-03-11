package com.aitrich.customer;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import com.aitrich.domain.entity.Customer;

import io.smallrye.mutiny.Uni;

@GraphQLApi
public class CustomerResourceEndpoint {

	@Inject
	CustomerService service;

	@Mutation
	public Uni<Customer> saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return service.saveCustomer(customer);
	}

	@Mutation
	public Uni<Customer> updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return service.updateCustomer(customer);
	}

	@Mutation
	public Uni<Boolean> deleteCustomer(@Name(value = "cId") long cId) {
		// TODO Auto-generated method stub
		return service.deleteCustomerById(cId);
	}

	@Query
	public Uni<Customer> findCustomerById(@Name(value = "cId") long cId) {
		// TODO Auto-generated method stub
		return service.findCustomerById(cId);
	}

	@Query
	public Uni<List<Customer>> fimdAllCustomer() {
		// TODO Auto-generated method stub
		return service.findAllCustomer();
	}

}
