package com.javahub.fileupload.service;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;

import com.javahub.fileupload.model.Employee;

public interface FileStorageService {

	public String saveEmployeeWithFile(Employee theEmployee) throws IOException;

	public Resource loadFileAsResource(String fileName);
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteFile(Long id, String file);
}
