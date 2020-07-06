package com.demo.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import com.demo.employee.dao.EmployeeDao;
import com.demo.employee.dao.EmployeeNotFoundException;
import com.demo.employee.model.Employee;

@Service
public class EmployeeService {
	
	private final EmployeeDao employeeDao;
	
	public Employee addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}
	@Autowired
	public EmployeeService(@Qualifier("newDb") EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeDao.selectAllEmployees();
	}
	
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException{
		return employeeDao.selectEmployeeById(id);
	}
	
	public boolean deleteEmployee(int id) throws EmployeeNotFoundException {
		return employeeDao.deleteEmployeeById(id);
	}
	
	public Employee updateEmployee(int id, Employee employee){
		return employeeDao.updateEmployeeById(id, employee);
	}

}
