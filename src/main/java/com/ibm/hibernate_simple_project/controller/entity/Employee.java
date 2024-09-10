package com.ibm.hibernate_simple_project.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private int id;
	private String name;
	private String email;
	private Long phone;
	

}
