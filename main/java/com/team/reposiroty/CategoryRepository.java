package com.team.reposiroty;

import org.springframework.data.repository.CrudRepository;

import com.team.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
