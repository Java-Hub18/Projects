package com.javahub.fileupload.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.javahub.fileupload.exception.MyFileNotFoundException;
import com.javahub.fileupload.model.Employee;
import com.javahub.fileupload.repository.EmployeeRepository;

@Service
@Transactional	
public class FileStorageServiceImpl implements FileStorageService {

	@Autowired
	EmployeeRepository employeeRepositoy;
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	private final Path fileStorageLocation= Paths.get(uploadDirectory)
			.toAbsolutePath().normalize();
	@Override
	public String saveEmployeeWithFile(Employee theEmployee) throws IOException {
		// Save Employee With File
		employeeRepositoy.save(theEmployee);
		return "success";
	}

	@Override
	public Resource loadFileAsResource(String fileName) {
		try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            System.out.println(filePath+" "+resource);
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
	}

	@Override
	public List<Employee> getAllEmployees() {
		// List All Employee
		return employeeRepositoy.findAll();
	}

	@Override
	public boolean deleteFile(Long id, String file) {
		boolean status = false;
		try {
			if (id != 0 && file != null) {
				employeeRepositoy.deleteEmployeeWithFile(id, file);
				System.out.println(this.getClass().getSimpleName() + ":deleting employee... " + id);
				String path = uploadDirectory+"/"+file;
				System.out.println("Path="+path);
				File fileToDelete = new File(path);
				status = fileToDelete.delete();
				System.out.println(this.getClass().getSimpleName() + ":deleting file... " + file);
			    System.out.println("Success: "+status+" fileToDelete: "+fileToDelete);
				return status;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return status;
		}
		return status;
	}

}

