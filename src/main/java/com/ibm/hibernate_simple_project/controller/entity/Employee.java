package com.ibm.hibernate_simple_project.controller.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Employee {
	
	private int id;
	@Setter
	private String name;
	@Setter
	private String email;
	private Long phone;
	

}
