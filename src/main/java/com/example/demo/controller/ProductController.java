package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	
	@GetMapping("/product/{page_no}/{size}")
	public Page<Product> findAllProducts(@PathVariable("page_no") int pageNo,@PathVariable("size") int size ){
		return  service.getProduct(pageNo,size);
	}
	
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable("id") int id ,@RequestBody Product product) {
		return service.updateProduct(id,product);
	}
	@DeleteMapping("/product/{id}")
	public String deleteProduct(int id) {
		return service.deleteProduct(id);
	}
}

