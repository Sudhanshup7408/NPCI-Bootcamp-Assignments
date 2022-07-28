package com.example.emp.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Employee")
public class Employee {
	
		@Id
		@Column(name="empno")
		public Integer empno;
		
		@Column(name="ename")
		public String ename;
		
		@Column(name="job")
		public String job;
		
		@Column(name="hiredate")
		//@DateTimeFormat(pattern = "yyyy-MM-dd")
		public Date hiredate;
		
		@Column(name="managerid")
		public Integer managerid;
		
		@Column(name="salary")
		public Integer salary;
		
		@Column(name="commission")
		public Integer commission;
		
		@Column(name ="deptno")
		public Integer deptno;
		
		public Employee() {
			
		}

		public Employee(Integer empno, String ename, String job, Date hiredate, Integer managerid, Integer salary,
				Integer commission, Integer deptno) {
			super();
			this.empno = empno;
			this.ename = ename;
			this.job = job;
			this.hiredate = hiredate;
			this.managerid = managerid;
			this.salary = salary;
			this.commission = commission;
			this.deptno = deptno;
		}

		public Integer getEmpno() {
			return empno;
		}

		public void setEmpno(Integer empno) {
			this.empno = empno;
		}

		public String getEname() {
			return ename;
		}

		public void setEname(String ename) {
			this.ename = ename;
		}

		public String getJob() {
			return job;
		}

		public void setJob(String job) {
			this.job = job;
		}

		public Date getHiredate() {
			return hiredate;
		}

		public void setHiredate(Date hiredate) {
			this.hiredate = hiredate;
		}

		public Integer getManagerid() {
			return managerid;
		}

		public void setManagerid(Integer managerid) {
			this.managerid = managerid;
		}

		public Integer getSalary() {
			return salary;
		}

		public void setSalary(Integer salary) {
			this.salary = salary;
		}

		public Integer getCommission() {
			return commission;
		}

		public void setCommission(Integer commission) {
			this.commission = commission;
		}

		public Integer getDeptno() {
			return deptno;
		}

		public void setDeptno(Integer deptno) {
			this.deptno = deptno;
		}
		
		
}
		 
		