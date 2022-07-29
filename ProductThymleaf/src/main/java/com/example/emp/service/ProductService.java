package com.example.emp.service;

import java.util.List;


import com.example.emp.entity.Product;

public interface ProductService {
	
	public void save(Product prod);
	public List<Product> findAll();
	public Product findById(Integer id);
	public void deleteById(Integer id);
	public void findByNameContainsAllIgnoreCase(String name);
	public List<Product> searchBy(String name);
	

	

}
