package com.aitrich.product;

import java.util.List;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.reactive.mutiny.Mutiny;

import com.aitrich.category.CategoryService;
import com.aitrich.domain.entity.Category;
import com.aitrich.domain.entity.Product;
import com.aitrich.domain.repository.ProductRepository;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Transactional
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductRepository repo;
	@Inject
	CategoryService categoryService;
//	@Inject
//	Mutiny.Session session;
//	
//	@Inject
//	EntityManager session;

	@Override
	public Uni<Product> saveProduct(Product product) {
		// TODO Auto-generated method stub
		//product.setCategory(null);
		Uni<Category> categoryUni=categoryService.findCategoryById(product.getCategory().getCategoryId());
		Category category= categoryUni.await().indefinitely();
		product.setCategory(category);
		System.out.println("saveProduct "+ product);
		//repo.persist(product);
		//session.persist(product);
		return repo.persist(product).chain(repo::flush).onItem().transform(Ignore -> product);
		//return Uni.createFrom().item(product);
	}

	@Override
	public Uni<Product> updateProduct(Product product) {
		// TODO Auto-generated method stub

		Function<Product, Uni<? extends Product>> update = entity -> {
			entity.setProductName(product.getProductName());
			entity.setCategory(product.getCategory());

			return repo.flush().onItem().transform(ignore -> entity);
		};

		return repo.findById(product.getId()).onItem().ifNotNull().transformToUni(update);
	}

	@Override
	public Uni<Product> findProductById(Long pid) {
		// TODO Auto-generated method stub
		return repo.findById(pid);
	}

	@Override
	public Uni<List<Product>> findAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll().list();
	}

	@Override
	public Uni<Boolean> deleteProductById(Long pid) {
		// TODO Auto-generated method stub
		return repo.deleteById(pid).chain(repo::flush).onItem().transform(ignore -> true);
	}

}
