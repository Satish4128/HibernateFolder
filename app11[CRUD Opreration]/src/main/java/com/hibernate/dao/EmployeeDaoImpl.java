package com.hibernate.dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import com.hibernate.entities.Employee;
import com.hibernate.factory.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public String add(Employee employee) {
		String status = "";
		try {
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			int eno = (Integer) session.save(employee);
			transaction.commit();
			if (eno == employee.getEno()) {
				status = "SUCESS";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public Employee search(int eno) {
		Employee employee = null;
		try {
			Session session = sessionFactory.openSession();
			employee = (Employee) session.get("com.hibernate.entities.Employee", eno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public String update(Employee employee) {
		String status = "";
		try {
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
			status = "SUCESS";
		} catch (Exception e) {
			status = "FAILURE";
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String delete(int eno) {
		String status = "";
		try {
			Session session = sessionFactory.openSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			Employee employee = new Employee();
			employee.setEno(eno);
			session.delete(employee);
			transaction.commit();
			status = "SUCCESS";
		} catch (Exception e) {
			status = "FAILURE";
			e.printStackTrace();
		}

		return status;
	}

}
