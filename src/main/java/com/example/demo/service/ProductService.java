package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired	
	private ProductRepository repository;
	@Autowired
	private CategoryService categoryService;
	public Product saveProduct(Product product) {
		Product Product=null;
		Optional<Category> optionalCategory = Optional.of(categoryService.getCategoriesById(product.getCategory().getId()));
		if (!optionalCategory.isPresent()) {
			return Product;
		}
		
		product.setCategory(optionalCategory.get());
			return repository.save(product);
			
			
	
	}

	public Page<Product> getProduct(int pageNo,int size){
		Pageable page = PageRequest.of(pageNo, size);
		return repository.findAll(page);
		
	}
	
	public Product getProductById(int id){
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name){
		return repository.findByName(name);
		
	}
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "delete product.."+id;
	}
	public Product updateProduct(int id ,Product product) {

		
		
		Product Product=null;
		Optional<Category> optionalCategory = Optional.of(categoryService.getCategoriesById(product.getCategory().getId()));
		if (!optionalCategory.isPresent()) {
			return Product;
		}
		product.setId(id);
		product.setCategory(optionalCategory.get());
			return repository.save(product);
			
			
		
	}
}
