package com.ibm.hibernate_simple_project.controller.dao;

import com.ibm.hibernate_simple_project.controller.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeDao {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("hibernate");

	EntityManager em=emf.createEntityManager();

	EntityTransaction et = em.getTransaction();

	public Employee saveEmployeeDao(Employee employee) {
		et.begin();
		em.persist(employee);
		et.commit();
		
		return employee;
	}
	

}
