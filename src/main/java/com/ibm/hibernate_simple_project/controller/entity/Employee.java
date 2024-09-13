package com.ibm.hibernate_simple_project.controller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//IllegalArgumentException : when we didn't define the @Entity
@Entity
//@Table : It changes the name of table , it didn't create as class name i.e; Employee
//@Table(name="emp")
//or
//@Entity(name="emp") 
public class Employee {
	@Id
	private int id;
//	@Column : decides constraints of table and to give the name from programmer side
//	@Column(name="empName",length=20, nullable=false)
	private String name;
	@Column(unique=true)
	private String email;
	private long phone;
	
	

}
