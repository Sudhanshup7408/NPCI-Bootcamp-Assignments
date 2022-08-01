package com.npci.rest.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Department")
public class Department {

	@Id
	@Column(name = "deptno")
	private Integer deptno;
	
	@Column(name = "deptname")
	private String deptname;
	
	@Column(name = "location")
	private String location;
	
	public Department() {
		super();
	}

	public Department(Integer deptno, String deptname, String location) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.location = location;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public String getLocation() {
		return location;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptname=" + deptname + ", location=" + location + "]";
	}
	
	
}
