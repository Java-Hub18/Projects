package com.javahub.fileupload;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javahub.fileupload.controller.FileController;

@SpringBootApplication
public class FileUploadDownloadApplication {

	public static void main(String[] args) {
		// Below line will create "uploads" folder at startup if not created.
		new File(FileController.uploadDirectory).mkdir();
		SpringApplication.run(FileUploadDownloadApplication.class, args);
	}

}
