package com.hibernate.factory;

import com.hibernate.controller.EmployeeController;

public class EmployeeControllerFactory {
	private static EmployeeController employeeController;
	
	static {
		employeeController=new EmployeeController();
	}
	public static EmployeeController getEmployeeController()
	{
		return employeeController;
	}
	

}
