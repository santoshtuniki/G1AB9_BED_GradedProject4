package com.greatlearning.employeemgmt.service;

import java.util.List;

import com.greatlearning.employeemgmt.entity.Employee;
import com.greatlearning.employeemgmt.entity.Role;
import com.greatlearning.employeemgmt.entity.User;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public void save(List<Employee> employees);
	
	public void update(Employee employee);

	public void deleteById(int id);
	
	public Employee findById(int id);

	public List<Employee> getEmployeesByFirstName(String firstName);

	public List<Employee> getEmployeesSortedByFirstName();

	public List<Employee> getEmployeesCustomSortedByName(String direction);
	
	public User saveUser(User user);
	
	public Role saveRole(Role role);

}