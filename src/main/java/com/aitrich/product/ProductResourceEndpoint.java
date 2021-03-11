package com.aitrich.product;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import com.aitrich.domain.entity.Product;

import io.smallrye.mutiny.Uni;

@GraphQLApi
public class ProductResourceEndpoint {

	@Inject
	ProductService service;

	@Mutation
	public Uni<Product> saveProduct(Product product) {
		return service.saveProduct(product);
		//return product.persist().chain(product :: flush).onItem().transform(ignrore -> product);
	}

	@Mutation
	public Uni<Product> updateProduct(Product product) {
		return service.updateProduct(product);
	}

	@Mutation
	public Uni<Boolean> deleteProductById(@Name(value = "pId") long pId) {
		return service.deleteProductById(pId);
	}

	@Query
	public Uni<Product> findProductById(@Name(value = "pId") long pId) {

		return service.findProductById(pId);
	}

	@Query
	public Uni<List<Product>> findAllProduct() {

		return service.findAllProduct();
	}
}
