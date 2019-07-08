package com.testinium.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testinium.entity.Category;
import com.testinium.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Category> getCategories() {

		List<Category> categories = categoryService.getCategories();
		return categories;

	}

	@GetMapping("/{categoryId}")
	public Optional<Category> getCategoriesById(@PathVariable(name = "categoryId") Long categoryId) {

		Optional<Category> category = categoryService.getCategoryById(categoryId);

		return category;

	}

	@PostMapping
	public void saveCategory(@Valid @RequestBody Category category) {

		categoryService.saveCategory(category);

	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
