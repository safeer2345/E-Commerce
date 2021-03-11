package com.aitrich.category;

import java.util.List;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.aitrich.domain.entity.Category;
import com.aitrich.domain.repository.CategoryRepository;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Inject
	CategoryRepository repo;

	@Override
	public Uni<Category> saveCategory(Category category) {

		return repo.persist(category).chain(repo::flush)
				.onItem().transform(ignore -> category);
	}

	@Override
	public Uni<Category> updateCategory(Category category) {
		// TODO Auto-generated method stub
		//System.out.println("0000000000000000000000000000000"+category);
		Function<Category, Uni<? extends Category>> update = entity ->
		{
			//System.out.println("111111111111111111111111111111111111"+entity);
			entity.setCategoryName(category.getCategoryName());
			return repo.flush().onItem().transform(ignore -> entity);
		};
		return repo.findById(category.getCategoryId()).onItem()
				.ifNotNull().transformToUni(update);
	}

	@Override
	public Uni<Category> findCategoryById(Long cid) {
		// TODO Auto-generated method stub
		return repo.findById(cid);
	}

	@Override
	public Uni<List<Category>> findAllCategory() {
		// TODO Auto-generated method stub
		return repo.findAll().list();
	}

	@Override
	public Uni<Boolean> deleteCategoryById(Long cid) {
		// TODO Auto-generated method stub
		return repo.deleteById(cid).chain(repo :: flush).onItem().transform(ignore -> true);
	}

}
