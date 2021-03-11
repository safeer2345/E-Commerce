package com.aitrich.product;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.Product;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface ProductService {
	
	public Uni<Product> saveProduct(Product product);
	
	 public Uni<Product> updateProduct(Product product); 

	public Uni<Product> findProductById(Long pid);
	
	public Uni<List<Product>> findAllProduct();
	
	public Uni<Boolean> deleteProductById(Long pid);

}
