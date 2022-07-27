package com.example.Ecommerce.service;

import java.util.List;

import com.example.Ecommerce.entity.Product;

public interface ProductService {

	public List<Product> findAll();
	public Product findById(Integer id);
	public void saveOrUpdate(Product product);
	public void deleteById(Integer id);

}
