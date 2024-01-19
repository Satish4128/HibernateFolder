
package com.hibernate.factory;

import com.hibernate.dao.EmployeeDao;
import com.hibernate.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
	
	private static EmployeeDao employeeDao;
	static {
		employeeDao=new EmployeeDaoImpl();
	}
	
	public static EmployeeDao getEmployeeDao()
	{
		return employeeDao;
	}
	

}
