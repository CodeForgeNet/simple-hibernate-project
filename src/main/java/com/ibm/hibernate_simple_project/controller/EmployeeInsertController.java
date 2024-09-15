package com.ibm.hibernate_simple_project.controller;

import java.util.List;
import java.util.Scanner;

import com.ibm.hibernate_simple_project.controller.dao.EmployeeDao;
import com.ibm.hibernate_simple_project.controller.entity.Employee;

public class EmployeeInsertController {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		EmployeeDao dao = new EmployeeDao();

		char ch;

		do {
			System.out.println(
					"\n\nEnter 'i/I' to insert data \nEnter 's/S' to display data\nEnter 'd/D' for delete\nEnter 'u/U' to update\nEnter 'x/X to exit");
			ch = sc.next().charAt(0);

			if (ch == 'i' || ch == 'I') {
//    	    	Insert

				System.out.print("Enter id: ");
				int id = sc.nextInt();

				System.out.print("Enter name: ");
				String name = sc.next();

				System.out.print("Enter email: ");
				String email = sc.next();

				System.out.print("Enter phone: ");
				long phone = sc.nextLong();

				Employee employee = new Employee(id, name, email, phone);
				dao.saveEmployeeDao(employee);

			} else if (ch == 's' || ch == 'S') {
//    	    	Fetch

				System.out.println("Enter '1' to display single emp\nEnter '2' to display all emp");
				int inp = sc.nextInt();

				if (inp == 1) {

					int id;
					System.out.print("Enter id to display data : ");
					id = sc.nextInt();
					Employee emp = dao.getEmployeeByIdDao(id);

					if (emp != null) {
						System.out.println(emp);
					} else {
						System.out.println("something went wrong check id");
					}
				} else if (inp == 2) {
					List<Employee> employees = dao.displayAllEmployeeDao();
					employees.forEach(e -> System.out.println(e));
				} else {
					System.out.println("Enter valid input ");
				}

			} else if (ch == 'd' || ch == 'D') {
//    		Delete
				
				int id;
				System.out.print("Enter id to delete data : ");
				id = sc.nextInt();
				boolean b = dao.deleteEmployeeByIdDao(id);

				if (b) {
					System.out.println("data deleted");
				} else {
					System.out.println("something went wrong check id");
				}

			} else if (ch == 'u' || ch == 'U') {
//			Update
				
				System.out.print("Enter id to change name: ");
				int id = sc.nextInt();

				System.out.print("Enter name to update: ");
				String name = sc.next();
				
				System.out.println("Enter email to update: ");
				String email = sc.next();
				
				System.out.println("Enter phone to update: ");
				long phone = sc.nextLong();

				Employee b = dao.updateEmployeeByIdDao(id, name, email, phone);

				if (b != null) {
					System.out.println(b);
					System.out.println("Data Updated");
				} else {
					System.out.println("Something went wrong.. check your employee id");
				}

			} else {
				System.out.println("You Exited");
			}

		} while (ch != 'x' && ch != 'X');
		sc.close();
	}
}
