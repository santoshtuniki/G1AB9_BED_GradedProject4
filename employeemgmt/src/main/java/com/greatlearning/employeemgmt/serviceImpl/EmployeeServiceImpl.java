package com.greatlearning.employeemgmt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemgmt.entity.Employee;
import com.greatlearning.employeemgmt.entity.Role;
import com.greatlearning.employeemgmt.entity.User;
import com.greatlearning.employeemgmt.repository.EmployeeRepository;
import com.greatlearning.employeemgmt.repository.RoleRepository;
import com.greatlearning.employeemgmt.repository.UserRepository;
import com.greatlearning.employeemgmt.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void save(List<Employee> employees) {
		employeeRepository.saveAll(employees);
	}

	@Override
	public void update(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Employee does not exists for the Id: " + id);
		}
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String firstName) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("first_name", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "last_name", "email");
		Example<Employee> example = Example.of(employee, exampleMatcher);
		return employeeRepository.findAll(example);

	}

	@Override
	public List<Employee> getEmployeesSortedByFirstName() {
		return employeeRepository.findAll(Sort.by("first_name"));
	}

	@Override
	public List<Employee> getEmployeesCustomSortedByName(String direction) {
		return employeeRepository.findAll(Sort.by(direction, "first_name"));
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

}
