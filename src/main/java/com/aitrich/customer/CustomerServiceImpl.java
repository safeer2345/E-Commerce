package com.aitrich.customer;

import java.util.List;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.aitrich.domain.entity.Customer;
import com.aitrich.domain.repository.CustomerRepository;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Inject
	CustomerRepository repo;

	@Override
	public Uni<Customer> saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.persist(customer).chain(repo::flush).onItem().transform(ignore -> customer);
	}

	@Override
	public Uni<Customer> updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Function<Customer, Uni<? extends Customer>> update = entity -> {
			entity.setName(customer.getName());
			entity.setAddress(customer.getAddress());
			return repo.flush().onItem().transform(ignore -> entity);
		};
		return repo.findById(customer.getId()).onItem().ifNotNull().transformToUni(update);
	}

	@Override
	public Uni<Customer> findCustomerById(Long cid) {
		// TODO Auto-generated method stub
		return repo.findById(cid);
	}

	@Override
	public Uni<List<Customer>> findAllCustomer() {
		// TODO Auto-generated method stub
		return repo.findAll().list();
	}

	@Override
	public Uni<Boolean> deleteCustomerById(Long cid) {
		// TODO Auto-generated method stub
		return repo.deleteById(cid).chain(repo::flush).onItem().transform(ignore ->true);
	}

}
