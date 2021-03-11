package com.aitrich.category;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import com.aitrich.domain.entity.Category;

import io.smallrye.mutiny.Uni;

@GraphQLApi
public class CategoryResourceEndpoint {

	@Inject
	CategoryService service;

	@Query
	public Uni<Category> getCategoryById(@Name(value = "cId") long cId) {
		return service.findCategoryById(cId);
	}

	@Mutation
	public Uni<Category> saveCategory(Category category) {
		return service.saveCategory(category);
	}

	
	  @Mutation public Uni<Category> updateCategory(Category category) { return
	  service.updateCategory(category); }
	 

	@Mutation
	public Uni<Boolean> deleteCategoryById(@Name(value = "cId") long cId) {
		return service.deleteCategoryById(cId);
	}

	@Query
	public Uni<List<Category>> findAllCategory() {
		return service.findAllCategory();
	}

}
