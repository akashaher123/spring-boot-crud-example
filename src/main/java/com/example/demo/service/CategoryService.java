package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository CategoryRepository;
	 
	
	public Category saveCategory(Category category) {
		try
		{
			return	CategoryRepository.save(category);
		}catch(Exception e) {
			Category  C1=new Category();
			System.out.println(e);
			return C1; 
		}
	}
	

	public Page<Category> getCategories(int pageno,int size){
		Pageable page = PageRequest.of(pageno, size);
		return CategoryRepository.findAll(page);
		}

	public Category getCategoriesById(int id){
		return CategoryRepository.findById(id).orElse(null);
		}
	public Category getCategoriesByName(String name){
		return CategoryRepository.findByName(name);
		}
	
	public int deleteCategory(int id) {
		CategoryRepository.deleteById(id);
		return id;
	}
	
	public Category updateCategory(int id,Category category) {
		Category cat=null;
		Optional<Category> optionalcategory=Optional.of(CategoryRepository.findById(id).orElse(null));
		
		   if (!optionalcategory.isPresent()) {
	            return cat;
	        }
		   category.setId(id);
		
		return CategoryRepository.save(category);
	}
	
}
