package com.ibm.hibernate_simple_project.controller;

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
					"\n\nEnter 'i/I' to insert data \nEnter 's/S' to display data\nEnter 'd/D' for delete\nEnter 'x/X to exit");
			ch = sc.next().charAt(0);

			if (ch == 'i' || ch == 'I') {
//    	    	Insert

				System.out.print("Enter id: ");
				int id = sc.nextInt();

				System.out.print("Enter name: ");
				String name = sc.nextLine();
				sc.next();

				System.out.print("Enter email: ");
				String email = sc.next();

				System.out.print("Enter phone: ");
				long phone = sc.nextLong();

				Employee employee = new Employee(id, name, email, phone);
				dao.saveEmployeeDao(employee);

			} else if (ch == 's' || ch == 'S') {
//    	    	Fetch

				int id;
				System.out.print("Enter id to display data : ");
				id = sc.nextInt();
				Employee emp = dao.getEmployeeByIdDao(id);

				if (emp != null) {
					System.out.println(emp);
				} else {
					System.out.println("something went wrong check id");
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

			} else {
				System.out.println("Enter valid input");
			}

		} while (ch != 'x' || ch != 'X');
		sc.close();
	}
}
