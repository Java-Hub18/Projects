package com.javahub.imageupload.service;

import java.io.IOException;
import java.util.List;

import com.javahub.imageupload.entity.Employee;

public interface EmployeeService {
 
	public boolean saveEmployee(Employee employee) throws IOException;
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteFile(Long id, String file);
}
