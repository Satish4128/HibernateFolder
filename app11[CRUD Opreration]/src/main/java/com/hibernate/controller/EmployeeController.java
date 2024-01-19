package com.hibernate.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.hibernate.entities.Employee;
import com.hibernate.factory.EmployeeServiceFactory;
import com.hibernate.service.EmployeeService;

public class EmployeeController {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	EmployeeService employeeService=EmployeeServiceFactory.getEmployeeService();
	public void addEmployee()
	{
		try {
			
			System.out.println("Employee Number :");
			int eno=Integer.parseInt(br.readLine());
			Employee emp=employeeService.searchEmployee(eno);
			if(emp==null)
			{
			System.out.println("Employee Name :");
			String ename=br.readLine();
			System.out.println("Employee Salary :");
			float esal=Float.parseFloat(br.readLine());
			System.out.println("Employee Address :");
			String eaddr=br.readLine();
			
			Employee employee=new Employee();
			employee.setEno(eno);
			employee.setEname(ename);
			employee.setEsal(esal);
			employee.setEaddr(eaddr);
			
			String status=employeeService.addEmployee(employee);
			System.out.println("Status :"+ status);
		}
			else
			{
				System.out.println("Employee Existed Already");
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void searchEmployee()
	{
		try {
		System.out.print("Employee Number :");
		int eno=Integer.parseInt(br.readLine());
		Employee employee=employeeService.searchEmployee(eno);
		if(employee==null)
		{
			System.out.println("Employee Doesnot Exist");
		}
		else
		{
			System.out.println("Employee Details");
			System.out.println("===================");
			System.out.println("Employee Number :"+employee.getEno());
			System.out.println("Employee Name :"+employee.getEname());
			System.out.println("Employee salary  :"+employee.getEsal());
			System.out.println("Employee Address :"+employee.getEaddr());
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void updateEmployee()
	{
		try {
			System.out.println("Employee Number :");
			int eno=Integer.parseInt(br.readLine());
			Employee employee=employeeService.searchEmployee(eno);
			if(employee==null)
			{
				System.out.println("Status  : Employee Doesnot existed");
			}
			else
			{
				System.out.println("Employee Name : Old :"+employee.getEname()+" New : ");
				String ename_New=br.readLine();
				if(ename_New==null||ename_New.equals(""))
				{
					ename_New=employee.getEname();
				}
				System.out.println("Employee Salary : Old :"+employee.getEsal()+" New :");
				String sal=br.readLine();
				float esal_New=0.0f;
				if(sal==null||sal.equals(""))
				{
					esal_New=employee.getEsal();
				}
				else
				{
					esal_New=Float.parseFloat(sal);
				}
				System.out.println("Employee Address : Old :"+employee.getEaddr()+" New :");
				String eaddr_New=br.readLine();
				if(eaddr_New==null||eaddr_New.equals(""))
				{
					eaddr_New=employee.getEaddr();
				}
				
				Employee employee_New=new Employee();
				employee_New.setEno(eno);
				
				employee_New.setEname(ename_New);
				employee_New.setEsal(esal_New);
				employee_New.setEaddr(eaddr_New);
				
				
				String status=employeeService.updateEmployee(employee_New);
				System.out.println("Status :"+status);
				
				
				
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void deleteEmployee()
	{
		try {
			System.out.println("Employee Number :");
			int eno=Integer.parseInt(br.readLine());
			Employee employee=employeeService.searchEmployee(eno);
			if(employee==null)
			{
				System.out.println("Status : Employee Does not Exist");
			}
			else
			{
			String status=employeeService.deleteEmployee(eno);
			System.out.println("Status :"+status);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
			

}
