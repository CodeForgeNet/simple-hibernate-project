package com.ibm.hibernate_simple_project.controller.dao;

import java.util.List;

import com.ibm.hibernate_simple_project.controller.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeDao {
//	persistence exception if the "hibernate" name is not matching to persistence.xml file
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");

	EntityManager em = emf.createEntityManager();

	EntityTransaction et = em.getTransaction();

	public Employee saveEmployeeDao(Employee employee) {
		et.begin();
		em.persist(employee); // to insert data
		et.commit();

		return employee;
	}

//	How to fetch the data by Id (primary key)
//	IllegalArgumentException if empId is not the primary that we passing
	public Employee getEmployeeByIdDao(int empId) {

		Employee employee = em.find(Employee.class, empId);

		return employee;

	}

//	Remove
	public boolean deleteEmployeeByIdDao(int empId) {

		Employee employee = getEmployeeByIdDao(empId);

		if (employee != null) {
			et.begin();
			em.remove(employee);
			et.commit();
			return true;
		} else {
			return false;
		}

	}
	
	
//	Update
	
	public Employee updateEmployeeByIdDao(int empId, String name, String email, long phone) {

		Employee employee = getEmployeeByIdDao(empId);

		if (employee != null) {
			
			employee.setName(name);
			employee.setEmail(email);
			employee.setPhone(phone);
			
			et.begin();
			em.merge(employee);
			et.commit();
			
			return employee;
		} else {
			return null;
		}

	}	
	
	
//	Display  all emp
	public List<Employee> displayAllEmployeeDao(){
		return em.createQuery("FROM Employee").getResultList();
	}
	

}
