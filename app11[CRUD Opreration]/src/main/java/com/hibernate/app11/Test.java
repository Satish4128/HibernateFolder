package com.hibernate.app11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.hibernate.controller.EmployeeController;
import com.hibernate.factory.EmployeeControllerFactory;
import com.hibernate.factory.HibernateUtil;

/**
 * Hello world!
 *
 */
public class Test 
{
	static {
		HibernateUtil.getSessionFactory();
	}
    public static void main( String[] args)throws Exception
    {
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	 EmployeeController employeeController=EmployeeControllerFactory.getEmployeeController();
        System.out.println("Employee Management Application");
        System.out.println("=================================");
        while(true)
        {
        	System.out.println();
        	System.out.println("1.ADD Employee");
        	System.out.println("2.SEARCH Employee");
        	System.out.println("3.Update Employee");
        	System.out.println("4.DELETE Employee");
        	System.out.println("5.EXIT");
        	System.out.println("Your Option :");
        	int userOption=Integer.parseInt(br.readLine());
        	switch(userOption)
        	{
        	case 1:
        		System.out.println("ADD Employee Module");
        		System.out.println("======================");
        		employeeController.addEmployee();
        		break;
        	case 2:
        		System.out.println("SEARCH Employee");
        		System.out.println("========================");
        		employeeController.searchEmployee();
        		break;
        	case 3:
        		System.out.println("UPDATE Employee Module");
        		System.out.println("=========================");
        		employeeController.updateEmployee();
        		break;
        	case 4:
        		System.out.println("Delete Employee Module");
        		System.out.println("===========================");
        		employeeController.deleteEmployee();
        		break;
        	case 5:
        		System.out.println("***********Thank You for using this Employee Management Application**********");
        		System.exit(0);
        		break;
        	default:
        		System.out.println("Invalid Entry please provide option between 1 2 3 4 5");
        		break;
        	
        	}
        	
        }
       
        
    }
}
