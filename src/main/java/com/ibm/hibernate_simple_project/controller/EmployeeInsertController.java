package com.ibm.hibernate_simple_project.controller;

import com.ibm.hibernate_simple_project.controller.dao.EmployeeDao;
import com.ibm.hibernate_simple_project.controller.entity.Employee;


public class EmployeeInsertController {
    public static void main(String[] args) {
       
    	EmployeeDao dao = new EmployeeDao();
    	
    	Employee employee = new Employee(1, "karan", "karan@gmail.com", 98776688);
    	
    	dao.saveEmployeeDao(employee);
    	
    }
}
