package com.javahub.fileupload.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javahub.fileupload.model.Employee;
import com.javahub.fileupload.service.FileStorageService;
import com.javahub.fileupload.exception.MyFileNotFoundException;

@Controller
@RequestMapping("/file-upload")
public class FileController {

	private static Logger log = LoggerFactory.getLogger(FileController.class);
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	FileStorageService fileStorageService;

	@GetMapping(value = { "/", "/index", "/home", "/default" })
	public String homePage() {
		return "index";
	}

	@GetMapping("/sign-up")
	public String showSignupPage() {
		return "sign-up";
	}

	@PostMapping("/saveEmployee")
	public @ResponseBody ResponseEntity<?> createEmployee(Employee employee, @RequestParam("name") String name,
			@RequestParam("designation") String designation, final @RequestParam("file") MultipartFile file) {
		try {
			String[] desg = designation.split(",");
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			long size = file.getSize();
			String fileSize = String.valueOf(size);
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

			log.info("Name: " + name);
			log.info("Designation: " + desg[0]);
			log.info("FileName: " + file.getOriginalFilename());
			log.info("FileType: " + file.getContentType());
			log.info("FileSize: " + file.getSize());

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			employee.setName(name);
			employee.setDesignation(desg[0]);
			employee.setFileName(fileName);
			employee.setFilePath(filePath);
			employee.setFileType(fileType);
			employee.setFileSize(fileSize);
			employee.setCreatedDate(currentTimestamp);

			String status = fileStorageService.saveEmployeeWithFile(employee);
			if (status.equals("success")) {
				log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
				return new ResponseEntity<>("Employe Saved With File - " + fileName, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/downloadFile/{fileName}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = fileStorageService.loadFileAsResource(fileName);
		log.info("resource: " + resource);
		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
			log.info("contentType: " + contentType);
		} catch (IOException ex) {
			log.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@GetMapping("/employees")
	public ModelAndView showAllEmployees() {
		log.info("Showing Employee list with File.");
		ModelAndView mav = new ModelAndView("employees");
		List<Employee> employeeList = fileStorageService.getAllEmployees();
		mav.addObject("employeeList", employeeList);
		return mav;
	}

	@GetMapping("/removeFile/{id}/{deletedFileName}")
	public ModelAndView removeFileHandler(@PathVariable("id") Long id,
			@PathVariable("deletedFileName") String deletedFileName) {
		ModelAndView mav = new ModelAndView("redirect:/file-upload/employees");
		String path = null;
		File file = null;
		try {
			path = uploadDirectory + "/" + deletedFileName;
			file = new File(path);
			if (file.exists()) {
				log.info("File Exits: ID: " + id + " File: " + deletedFileName);
				log.info("Deleteing Employee with File.");
				boolean status = fileStorageService.deleteFile(id, deletedFileName);
				log.info("Status: " + status);
				if (status) {
					log.info("Employee Deleted with file Status: " + status);
					List<Employee> employeeList = fileStorageService.getAllEmployees();
					mav.addObject("employeeList", employeeList);
					return mav;
				} else {
					log.info("Oops! Something Went Wrong Status: " + status);
					List<Employee> employeeList = fileStorageService.getAllEmployees();
					mav.addObject("employeeList", employeeList);
					return mav;
				}
			} else {
				log.info("Oops! File Not Found: "+deletedFileName);
				throw new MyFileNotFoundException("Oops! File Not Found: "+deletedFileName);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			throw new MyFileNotFoundException("Oops! File Not Found: "+deletedFileName, e);
		}
	}
}
