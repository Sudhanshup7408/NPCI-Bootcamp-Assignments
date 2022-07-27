package com.example.demo.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	
		@Id
		//@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
	    private int id;
		@Column(name="sku")
		private  String sku;
		@Column(name="name")
		private  String name;
		@Column(name="description")
		private  String description;
		@Column(name="unitprice")
		private  Float unitprice;
		@Column(name="imageurl")
		private  String imageurl;
		@Column(name="unitsinstock")
		private  int unitsinstock;
		@Column(name="datecreated")
		private  Date datecreated;
		@Column(name="lastupdated")
		private  Date lastupdated;
		@Column(name="categoryid")
		private  int categoryid;
		
		public Product() {}
		public Product(int id, String sku, String name, String description, Float unitprice, String imageurl,
				int unitsinstock, Date datecreated, Date lastupdated, int categoryid) {
			super();
			this.id = id;
			this.sku = sku;
			this.name = name;
			this.description = description;
			this.unitprice = unitprice;
			this.imageurl = imageurl;
			this.unitsinstock = unitsinstock;
			this.datecreated = datecreated;
			this.lastupdated = lastupdated;
			this.categoryid = categoryid;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getSku() {
			return sku;
		}
		public void setSku(String sku) {
			this.sku = sku;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Float getUnitprice() {
			return unitprice;
		}
		public void setUnitprice(Float unitprice) {
			this.unitprice = unitprice;
		}
		public String getImageurl() {
			return imageurl;
		}
		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}
		public int getUnitsinstock() {
			return unitsinstock;
		}
		public void setUnitsinstock(int unitsinstock) {
			this.unitsinstock = unitsinstock;
		}
		public Date getDatecreated() {
			return datecreated;
		}
		public void setDatecreated(Date datecreated) {
			this.datecreated = datecreated;
		}
		public Date getLastupdated() {
			return lastupdated;
		}
		public void setLastupdated(Date lastupdated) {
			this.lastupdated = lastupdated;
		}
		public int getCategoryid() {
			return categoryid;
		}
		public void setCategoryid(int categoryid) {
			this.categoryid = categoryid;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", sku=" + sku + ", name=" + name + ", description=" + description + ", unitprice="
					+ unitprice + ", imageurl=" + imageurl + ", unitsinstock=" + unitsinstock + ", datecreated="
					+ datecreated + ", lastupdated=" + lastupdated + ", categoryid=" + categoryid + "]";
		}
		
		
		
		
		
		
	}


