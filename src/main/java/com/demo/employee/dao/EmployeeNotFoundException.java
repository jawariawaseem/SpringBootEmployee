package com.demo.employee.dao;

public class EmployeeNotFoundException extends Exception {

	private int id;
	
	public EmployeeNotFoundException(int id) {
		super(String.format("Employee is not found with id : '%s'", id));
	}
}
