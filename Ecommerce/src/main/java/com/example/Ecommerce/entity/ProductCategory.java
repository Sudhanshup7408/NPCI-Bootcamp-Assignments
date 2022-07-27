package com.example.Ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory {
	
	@Column(name = "categoryid")
	private Integer categoryid;
	
	@Column(name = "categoryname")
	private Integer categoryname;
	
	public ProductCategory() {
		
	}

	public ProductCategory(Integer categoryid, Integer categoryname) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}

	protected Integer getCategoryid() {
		return categoryid;
	}

	protected void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	protected Integer getCategoryname() {
		return categoryname;
	}

	protected void setCategoryname(Integer categoryname) {
		this.categoryname = categoryname;
	}
	
	

}
