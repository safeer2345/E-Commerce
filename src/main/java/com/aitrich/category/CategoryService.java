package com.aitrich.category;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.Category;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public interface CategoryService {

	public Uni<Category> saveCategory(Category category);
	
	public Uni<Category> updateCategory(Category category);

	public Uni<Category> findCategoryById(Long cid);
	
	public Uni<List<Category>> findAllCategory();
	
	public Uni<Boolean> deleteCategoryById(Long cid);
	
	
}
