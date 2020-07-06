package com.demo.employee.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.dao.EmployeeNotFoundException;
import com.demo.employee.model.Employee;
import com.demo.employee.service.EmployeeService;

@RestController
@Validated
@RequestMapping("api/v1/employee")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<?>  addEmployee(@Valid @NotNull @RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<>("Employee added successfully!", HttpStatus.OK);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable(value = "id") int id) throws EmployeeNotFoundException {
		Employee employee = employeeService.getEmployeeById(id);
		if(employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee with id " + id + " not found.",
                HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path = "{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(value = "id") int id,
            @Valid @RequestBody Employee employee){
		Employee updatedEmployee = employeeService.updateEmployee(id, employee);
		if(updatedEmployee != null) {
			return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
		}
		return new ResponseEntity<>("Unable to update. Employee with id " + id + " not found.",
                HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "{id}")
	 public ResponseEntity<?> deleteEmplyeeById(@PathVariable(value = "id") int id) throws EmployeeNotFoundException{
		boolean result =  employeeService.deleteEmployee(id);
		if(result) {
			return new ResponseEntity<>("Employee with id " + id + " deleted successfully.",HttpStatus.OK);
		}
		return new ResponseEntity<>("Unable to delete. Employee with id " + id + " not found.",
                HttpStatus.NOT_FOUND);
	}
}
