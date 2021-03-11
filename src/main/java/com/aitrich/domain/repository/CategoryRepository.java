package com.aitrich.domain.repository;

import javax.enterprise.context.ApplicationScoped;

import com.aitrich.domain.entity.Category;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category>{

}
