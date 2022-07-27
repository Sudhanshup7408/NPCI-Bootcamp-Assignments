package com.example.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.entity.Product;


@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryController procatService;
	
	@GetMapping("/procatlist")
	public List<Product> findAll(){
		return procatService.findAll();
	}
}