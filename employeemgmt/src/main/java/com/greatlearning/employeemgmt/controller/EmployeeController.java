package com.greatlearning.employeemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeemgmt.entity.Employee;
import com.greatlearning.employeemgmt.entity.Role;
import com.greatlearning.employeemgmt.entity.User;
import com.greatlearning.employeemgmt.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
		
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable(value = "id") int id) {
		Employee employee = employeeService.findById(id);
		return employee;
	}

	@PostMapping("/employees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
		employeeService.save(employees);
		return employees;
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") int id, @RequestBody Employee employee) {
		Employee existingEmp = employeeService.findById(id);
		if (existingEmp.getId() == employee.getId()) {
			existingEmp.setFirstName(employee.getFirstName());
			existingEmp.setLastName(employee.getLastName());
			existingEmp.setEmail(employee.getEmail());
		}
		employeeService.update(existingEmp);
		return existingEmp;
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable(value = "id") int id) {
		employeeService.deleteById(id);
		return "Deleted employee id - " + id;
	}

	@GetMapping("/employees/search/{firstName}")
	public List<Employee> searchByFirstName(@PathVariable(value = "firstName") String firstName) {
		return employeeService.getEmployeesByFirstName(firstName);
	}

	@GetMapping("/employees/sort")
	public List<Employee> getEmployeesSortedByName(@RequestParam(value = "order") String order) {
		return employeeService.getEmployeesCustomSortedByName(order);
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return employeeService.saveUser(user);
	}

	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		return employeeService.saveRole(role);
	}
	
	@GetMapping("/403")
	public String error() {
		return "You do not have permission to access this page!";
	}

}
