package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@PostMapping("/category")
	public Category addCategory(@RequestBody Category category) {
		return service.saveCategory(category);
	}
	
	@GetMapping("/category/{page_no}/{size}")
	public Page<Category> findAllCategories(@PathVariable("page_no") int pageNo,@PathVariable("size") int size ){
		return  service.getCategories(pageNo,size);
	}
	@GetMapping("/category/{id}")
	public Category findCategoryById(@PathVariable int id) {
		return service.getCategoriesById(id);
	}

	@PutMapping("/category/{id}")
	public Category updateCategory(@PathVariable("id") int id,@RequestBody Category category) {
		return service.updateCategory(id,category);
	}
	@DeleteMapping("/category/{id}")
	public int deleteCategory(@PathVariable("id") int id) {
		return service.deleteCategory(id);
	}
	
}
