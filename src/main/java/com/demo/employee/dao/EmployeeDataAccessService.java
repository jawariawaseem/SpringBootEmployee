package com.demo.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.demo.employee.datasource.EmployeeRepository;
import com.demo.employee.model.Employee;

@Repository("newDb")
public class EmployeeDataAccessService implements EmployeeDao{

	@Autowired
    EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> selectAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee selectEmployeeById(int id) {
		try {
			return employeeRepository.findById(id)
			        .orElseThrow(() -> new EmployeeNotFoundException(id));
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean  deleteEmployeeById(int id)  {
		Employee employee;
		try {
			employee = employeeRepository.findById(id)
			        .orElseThrow(() -> new EmployeeNotFoundException(id));
			employeeRepository.delete(employee);
			return true;
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee updateEmployeeById(int id, Employee employeeDetails){
		Employee employee;
		try {
			employee = employeeRepository.findById(id)
			        .orElseThrow(() -> new EmployeeNotFoundException(id));
			employee.setName(employeeDetails.getName());
			employee.setAddress(employeeDetails.getAddress());
			employee.setCity(employeeDetails.getCity());
					
			Employee updatedEmployee = employeeRepository.save(employee);
			return updatedEmployee;
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
