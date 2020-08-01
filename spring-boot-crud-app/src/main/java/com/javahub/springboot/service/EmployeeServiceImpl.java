package com.javahub.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javahub.springboot.entity.Employee;
import com.javahub.springboot.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	// Inject EmployeeRepository to call it's Pre-defined or Custom methods 
	@Autowired 
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		// Get All Employee
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// Get Employee By id
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		// Get Employee By email
		return employeeRepository.findByEmail(email);
	}

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		// Save or Update Employee
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		// Delete Employee By id
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> search(String keyword) {
		// Search Employee By keyword
		return employeeRepository.search(keyword);
	}

	@Override
	public List<Employee> getEmployeeByEmpId(String empId) {
		// Get Employee By empId
		return employeeRepository.findEmployeeByEmpId(empId);
	}

	@Override
	public Employee checkLogin(String email, String password) {
		// Validate Employee
		return employeeRepository.validateEmployee(email, password);
	}

	@Override
	public String getEmployeePassword(String email) {
		// Get Employee password By email
		return employeeRepository.findEmployeePassword(email);
	}

	@Override
	public void deleteAllEmployee() {
		// Delete All Employee
		employeeRepository.deleteAll();	
	}

}
