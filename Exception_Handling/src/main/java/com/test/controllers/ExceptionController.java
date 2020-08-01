package com.test.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController implements ErrorController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model map) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		log.info("Http status code >> " + statusCode);
		log.info("Exception >> " + exception);
		/* Extra information while exception occuring */
		Class<?> exceptionType = (Class<?>) request.getAttribute("javax.servlet.error.exception_type");
		String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		log.info("exceptionType >> " + exceptionType);
		log.info("errorMessage >> " + errorMessage);
		log.info("requestUri >> " + requestUri);
		log.info("servletName >> " + servletName);

		map.addAttribute("statusCode", statusCode);
		if (statusCode == 404) {
			String exceptionValue = "The page you are looking for might have been removed had its name changed or is temporarily unavailable.";
			map.addAttribute("exception", exceptionValue);
			return "page404";
		} else {
			map.addAttribute("exception", exception);
			return "page500";
		}
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
