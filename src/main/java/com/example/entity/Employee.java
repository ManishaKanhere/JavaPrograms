package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity    //used to create a table

@Table(name="Employee2")
@NamedQueries({ 
	@NamedQuery(
			name="findBySalary",
			query="select e from Employee e WHERE salary BETWEEN :min and :max"
			)
	
})
public class Employee {
	@Id
	private int empId;
	private String empName;
	private float salary;
	private String deptName;
	private LocalDate joiningDate;
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, float salary, String deptName, LocalDate joiningDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptName = deptName;
		this.joiningDate = joiningDate;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", deptName=" + deptName
				+ ", joiningDate=" + joiningDate + "]";
	}
	
	
	

}

