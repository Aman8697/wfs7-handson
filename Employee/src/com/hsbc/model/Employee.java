package com.hsbc.model;

import java.time.LocalDate;

public class Employee {
	
	private int id;
	private String name;
	private float salary;
	private LocalDate dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dob=" + dob + "]";
	}
	public Employee(int id, String name, float salary, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
	}
	
	
	
	
	

}
