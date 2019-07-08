package com.testinium.service;

import java.util.List;
import java.util.Optional;

import com.testinium.entity.Category;

public interface CategoryService {

	public List<Category> getCategories();

	public void saveCategory(Category category);

	public Optional<Category> getCategoryById(Long categoryId);

}
