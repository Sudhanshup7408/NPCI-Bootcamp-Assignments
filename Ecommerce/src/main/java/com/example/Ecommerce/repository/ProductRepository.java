package com.example.Ecommerce.repository;

import java.util.List;

import com.example.Ecommerce.entity.Product;

public interface ProductRepository {
	
	public List<Product> findAll();

	public Product findById(Integer id);
	public void saveOrUpdate(Product product);
	
	public void deleteById(Integer id);

}
