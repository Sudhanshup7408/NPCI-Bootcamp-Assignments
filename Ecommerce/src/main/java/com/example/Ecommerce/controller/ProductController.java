package com.example.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService prodService;
	
	@GetMapping("/prodlist")
	public List<Product> findAll(){
		return prodService.findAll();
	}
	
	@GetMapping("/pro/{id}")
	public Product findById(@PathVariable Integer id)
	{
		return prodService.findById(id);
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Product product)
	{
		prodService.saveOrUpdate(product);
		return "Product Details added successfully";
		
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product)
	{
		prodService.saveOrUpdate(product);
		return "Product updated successfully";
	}
	
	@DeleteMapping("pro/{id}")
	public String deleteById(@PathVariable Integer id)
	{
		prodService.deleteById(id);
		return "Product Deleted successfully";
	}
}