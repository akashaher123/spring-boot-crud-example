package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Category {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String discription;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="cat_id", referencedColumnName = "id")
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Product> product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}



	public Set<Product> getProduct() {
		return product;
	}

	
	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, String discription, Set<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", discription=" + discription + ", product=" + product + "]";
	}
	
	
	
	
}
