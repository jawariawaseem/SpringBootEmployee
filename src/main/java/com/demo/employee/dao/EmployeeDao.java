package com.demo.employee.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.employee.model.Employee;

public interface EmployeeDao {
		
//	default int insertEmployee(Employee employee) {
//		return insertEmployee(employee);
//	}
	Employee addEmployee(Employee employee);
	List<Employee> selectAllEmployees();

	Employee selectEmployeeById(int id);
	
	boolean deleteEmployeeById(int id);
	
	Employee updateEmployeeById(int id, Employee employee) ;

}
