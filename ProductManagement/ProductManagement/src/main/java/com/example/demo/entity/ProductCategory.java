package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Productcatagory")
public class ProductCategory {

	@Id
	@Column(name="categoryid")
	private int categoryid;
	@Column(name="categoryname")
	private String categoryname;
	
	public ProductCategory() {}
	public ProductCategory(int categoryid, String categoryname) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}
	



	}


