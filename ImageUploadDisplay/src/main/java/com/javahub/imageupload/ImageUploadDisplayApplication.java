package com.javahub.imageupload;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javahub.imageupload.controller.EmployeeController;

@SpringBootApplication
public class ImageUploadDisplayApplication {

	public static void main(String[] args) {
		// Below line will create "uploads" folder at startup if not created.
		new File(EmployeeController.uploadDirectory).mkdir();
		SpringApplication.run(ImageUploadDisplayApplication.class, args);
	}

}
