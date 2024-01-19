package com.hibernate.factory;

import com.hibernate.service.EmployeeService;
import com.hibernate.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
	private static EmployeeService employeeService;
	static {
		employeeService=new EmployeeServiceImpl();
	}
	
	public static EmployeeService getEmployeeService()
	{
		return employeeService;
	}
	

}
