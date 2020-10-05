package com.hsbc.dao;

import java.util.ArrayList;

import com.hsbc.model.Employee;

public class EmployeeDaoImpl {
	
	ArrayList<Employee> al=new ArrayList<Employee>();
	public void store(Employee e)
	{
		al.add(e);
	}
	
	public ArrayList<Employee> getEmployee()
	{
		return al;
	}

	
}
