package com.hsbc.caller;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.hsbc.dao.EmployeeDaoImpl;
import com.hsbc.model.Employee;

public class Caller {

	public static void main(String[] args) {
		
		ArrayList<Employee> cal=new ArrayList<Employee>();
		EmployeeDaoImpl impl=new EmployeeDaoImpl();
		
		LocalDate doj=LocalDate.of(2018, 10, 9);
		Employee e1=new Employee(100,"Aman",55000f,doj); 
		LocalDate doj1=LocalDate.of(2018, 10, 8);
		Employee e2=new Employee(101,"Bob",45000f,doj1);
		LocalDate doj2=LocalDate.of(2019, 6, 7);
		Employee e3=new Employee(102,"Drake",95000f,doj2);
		LocalDate doj3=LocalDate.of(2019, 3, 3);
		Employee e4=new Employee(103,"Camila",35000f,doj3);
		
		System.out.println("enter 1 for storing and 2 for sorted output 3 to exit...");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		do {
		switch(choice)
		{
		case 1: impl.store(e1);
				impl.store(e2);
				impl.store(e3);
				impl.store(e4);
				System.out.println("Exiting store method....");
				
				break;
		case 2: cal=impl.getEmployee();
		
				System.out.println("Ascending order of ID");
				Collections.sort(cal,(o1,o2) -> o1.getId() - o2.getId());
				int count=0;
				for(Employee emp : cal)
				{
					if(count<2)
					{
						System.out.println(emp);
						count++;
					}
					else
					{
						count=0;
						break;
					}
				}
				
				System.out.println("Descending order of ID");
				
				Collections.sort(cal,(o1,o2) -> o2.getId() - o1.getId());
				
				for(Employee emp : cal)
				{
					if(count<2)
					{
						System.out.println(emp);
						count++;
					}
					else
					{
						count=0;
						break;
					}
				}
				
				System.out.println("Ascending order of ID");
				
				Collections.sort(cal,(o1,o2) -> (int)o1.getSalary()- (int)o2.getSalary());
				
				for(Employee emp : cal)
				{
					if(count<2)
					{
						System.out.println(emp);
						count++;
					}
					else
					{
						count=0;
						break;
					}
				}
				
				System.out.println("Descending order of ID");
				
				Collections.sort(cal,(o1,o2) -> (int)o2.getSalary()- (int)o1.getSalary());
				
				for(Employee emp : cal)
				{
					if(count<2)
					{
						System.out.println(emp);
						count++;
					}
					else
					{
						count=0;
						break;
					}
				}
				
				break;
				
		}
	}while(choice!=3);
		
		sc.close();
	


	}

}
