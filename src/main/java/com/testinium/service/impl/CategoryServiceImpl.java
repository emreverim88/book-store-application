package com.testinium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testinium.entity.Category;
import com.testinium.repository.CategoryRepository;
import com.testinium.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategories() {

		List<Category> categories = categoryRepository.findAll();
		return categories;
	}

	@Override
	public Optional<Category> getCategoryById(Long categoryId) {

		Optional<Category> category = categoryRepository.findById(categoryId);
		return category;
	}

	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

}
