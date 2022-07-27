package com.example.Ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "unitprice")
	private Integer unitprice;
	
	@Column(name = "imageurl")
	private String imageurl;
	
	@Column(name = "unitsinstock")
	private Integer unitsinstock;
	
	@Column(name = "datecreated")
	private Date datecreated;
	
	@Column(name = "lastcreated")
	private Date lastcreated;
	
	@Column(name = "category")
	private Integer category;
	
	
	public Product() {
		
	}


	public Product(Integer id, String sku, String name, String description, Integer unitprice, String imageurl,
			Integer unitsinstock, Date datecreated, Date lastcreated, Integer category) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unitprice = unitprice;
		this.imageurl = imageurl;
		this.unitsinstock = unitsinstock;
		this.datecreated = datecreated;
		this.lastcreated = lastcreated;
		this.category = category;
	}


	protected Integer getId() {
		return id;
	}


	protected void setId(Integer id) {
		this.id = id;
	}


	protected String getSku() {
		return sku;
	}


	protected void setSku(String sku) {
		this.sku = sku;
	}


	protected String getName() {
		return name;
	}


	protected void setName(String name) {
		this.name = name;
	}


	protected String getDescription() {
		return description;
	}


	protected void setDescription(String description) {
		this.description = description;
	}


	protected Integer getUnitprice() {
		return unitprice;
	}


	protected void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}


	protected String getImageurl() {
		return imageurl;
	}


	protected void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}


	protected Integer getUnitsinstock() {
		return unitsinstock;
	}


	protected void setUnitsinstock(Integer unitsinstock) {
		this.unitsinstock = unitsinstock;
	}


	protected Date getDatecreated() {
		return datecreated;
	}


	protected void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}


	protected Date getLastcreated() {
		return lastcreated;
	}


	protected void setLastcreated(Date lastcreated) {
		this.lastcreated = lastcreated;
	}


	protected Integer getCategory() {
		return category;
	}


	protected void setCategory(Integer category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", description=" + description + ", unitprice="
				+ unitprice + ", imageurl=" + imageurl + ", unitsinstock=" + unitsinstock + ", datecreated="
				+ datecreated + ", lastcreated=" + lastcreated + ", category=" + category + "]";
	}	
	
}
