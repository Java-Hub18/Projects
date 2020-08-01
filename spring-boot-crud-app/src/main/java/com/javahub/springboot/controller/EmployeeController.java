package com.javahub.springboot.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.javahub.springboot.entity.Employee;
import com.javahub.springboot.service.EmployeeService;
import com.javahub.springboot.utils.Utils;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	// @InitBinder - pre process every string data.
	// removes the leading & trailing white spaces.
	// If string only has white space .... trim it to null.

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}
	
	// Inject EmployeeService to call it's methods
	@Autowired
	EmployeeService employeeService;

	// Inject Utils to call it's methods
	@Autowired
	Utils utils;

	// Inject BCryptPasswordEncoder for encoding password, default length is 60.+	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	// Show Home Page
	@GetMapping(value = { "/", "/home", "/index", "default" })
	public ModelAndView showHomePage() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Home Page.");
		return new ModelAndView("index"); // Here index is a jsp page name
	}

	// Show All Employee
	@GetMapping("/employees")
	public ModelAndView showAllEmployees() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Employee list.");
		ModelAndView mav = new ModelAndView("employees"); // Here employees is a jsp page name
		List<Employee> employeeList = employeeService.getAllEmployee();
		mav.addObject("employeeList", employeeList); // Set the attribute as "employeeList"
		return mav;
	}

	// Show Sign-Up Form
	@GetMapping("/sign-up")
	public ModelAndView showSignupForm() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Sign-Up Form Page.");
		ModelAndView mav = new ModelAndView("sign-up"); // Here sign-up is a jsp page name
		mav.addObject("employee-sign-up", new Employee()); // Set the model attribute as "employee-sign-up"
		return mav;
	}

	// Show Sign-In Form
	@GetMapping("/sign-in")
	public ModelAndView showSigninForm() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Sign-In Form Page.");
		ModelAndView mav = new ModelAndView("sign-in"); // Here sign-in is a jsp page name
		mav.addObject("employee-sign-in", new Employee()); // Set the model attribute as "employee-sign-in"
		return mav;
	}

	// Show welcome page after successful login
	@GetMapping("/welcome")
	public ModelAndView welcomeMessage() {
		System.out.println(this.getClass().getSimpleName() + ":=======>Showing Welcome Page.");
		return new ModelAndView("welcome"); // Here welcome is a jsp page name
	}

	// Save or Update Employee through sign-up form
	@PostMapping("/saveEmployee")
	public ModelAndView createEmployee(@Valid @ModelAttribute("employee-sign-up") Employee employee, BindingResult br, 
			HttpServletRequest request, HttpSession session)
			throws ParseException {
		if(request.getParameter("testData") == null || request.getParameter("testData").isEmpty() 
				|| request.getParameter("testData").equals("")) {
			System.out.println("testData......."+request.getParameter("testData"));
			System.out.println("In If.......");
			System.out.println(this.getClass().getSimpleName() + ":=======>Employee save request came.");
			Employee employeeExist = employeeService.getEmployeeByEmail(employee.getEmail());
			System.out.println(this.getClass().getSimpleName() + ":=======>employeeExist = " + employeeExist);
			// Check if employee exists
			if (employeeExist != null) {
				System.out.println(this.getClass().getSimpleName() + ":=======>" + employee.getEmail()
						+ " This email already exists!");
				br.rejectValue("email", "error.employee", "This email already exists!");
			}
			// Check if any field is empty or null
			if (br.hasErrors()) {
				System.out.println(this.getClass().getSimpleName() + ":=======>BindingResult Found an error.");
				return new ModelAndView("sign-up");
			} else {
				String firstName = employee.getFirstName(); // get the firstName
				String lastName = employee.getLastName(); // get the lastName
				// Take 1st char of firstName & lastName and concat them
				String nameChar = firstName.substring(0, 1) + lastName.substring(0, 1);
				// call the random number generator function
				String empId = nameChar.toUpperCase() + utils.generateRandomNumber(); 
				System.out.println(this.getClass().getSimpleName() + ":=======>employeeId = " + empId);
				// set empId & encrypted password before saving to table
				employee.setEmpId(empId);
				employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
				// set current TimeStamp
				Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
				System.out.println(this.getClass().getSimpleName() + ":=======>currentTimeStamp = " + currentTimeStamp);
				employee.setCreateDate(currentTimeStamp);
				// Now save the Employee
				employeeService.saveOrUpdateEmployee(employee);
				System.out.println(empId + "=>This Employee has saved. Now redirecting...");
				// set the session before redirecting
				session.setAttribute("ename", firstName+" "+lastName);
				return new ModelAndView("redirect:/employee/employees");
			}
		}
		else {
			System.out.println("testData......."+request.getParameter("testData"));
			System.out.println("In else.......");
			System.out.println(this.getClass().getSimpleName() + ":=======>Employee update request came.");
			// Check if any field is empty or null
			if (br.hasErrors()) {
				System.out.println(this.getClass().getSimpleName() + ":=======>BindingResult Found an error.");
				return new ModelAndView("sign-up");
			} else {
				String firstName = employee.getFirstName(); // get the firstName
				String lastName = employee.getLastName(); // get the lastName
				// Take 1st char of firstName & lastName and concat them
				String nameChar = firstName.substring(0, 1) + lastName.substring(0, 1);
				// call the random number generator function
				String empId = nameChar.toUpperCase() + utils.generateRandomNumber(); 
				System.out.println(this.getClass().getSimpleName() + ":=======>employeeId = " + empId);
				// set empId & encrypted password before updating to table
				employee.setEmpId(empId);
				employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
				// Now update the Employee
				employeeService.saveOrUpdateEmployee(employee);
				System.out.println(empId + "=>This Employee updated. Now redirecting...");
				return new ModelAndView("redirect:/employee/employees");
			}
		}
	}

	// Validate Employee through login Process
	@PostMapping("/validateEmployee")
	public ModelAndView validateEmployee(@Valid @ModelAttribute("employee-sign-in") Employee employee,
			BindingResult br, HttpSession session) {
		System.out.println(this.getClass().getSimpleName() + ":Validating Employee For: " + employee.getEmail());
		Employee employeeExist = employeeService.getEmployeeByEmail(employee.getEmail());
		// Check if employee exists
		if (employeeExist == null) {
			System.out.println(this.getClass().getSimpleName() + ":This email does not exists!");
			br.rejectValue("email", "error.employee", "This email does not exists!");
		} else {
			String employeeEncodedPassword = employeeService.getEmployeePassword(employee.getEmail());
			System.out.println(this.getClass().getSimpleName() + ":employeeBCryptPassword======================="
					+ employeeEncodedPassword);
			boolean checkPassStatus = bCryptPasswordEncoder.matches(employee.getPassword(), employeeEncodedPassword);
			// Check if password matches
			if (checkPassStatus) {
				System.out.println(
						this.getClass().getSimpleName() + ":checkPassStatus=======================" + checkPassStatus);
				employee = employeeService.checkLogin(employee.getEmail(), employeeEncodedPassword);
				if (employee != null) {
					session.setAttribute("ename", employeeExist.getFirstName()+" "+employeeExist.getLastName());
					System.out.println(this.getClass().getSimpleName() + ":login done forwarding...");
					return new ModelAndView("welcome");
				} else {
					System.out.println(this.getClass().getSimpleName() + ":Password mismatch.");
					br.rejectValue("password", "error.employee", "Password mismatch.");
				}
			} else {
				System.out.println(this.getClass().getSimpleName() + ":Password doesn't match.");
				br.rejectValue("password", "error.employee", "Password doesn't match.");
			}
		}
		return new ModelAndView("sign-in");
	}

	// Update Employee By id
	@GetMapping("/updateEmployee/{id}")
	public ModelAndView editEmployee(@PathVariable("id") long id, Model model) {
		System.out.println(this.getClass().getSimpleName() + ":update employee..." + id);
		Employee employee = employeeService.getEmployeeById(id);
		ModelAndView mav = new ModelAndView("sign-up");
		mav.addObject("employee-sign-up", employee);
		model.addAttribute("testData", "testData");
		model.addAttribute("passwords", employee.getPassword());
		return mav;
	}

	// Delete Employee By id
	@GetMapping("/deleteEmployee/{id}")
	public ModelAndView removeEmployee(@PathVariable("id") long id) {
		System.out.println(this.getClass().getSimpleName() + ":deleting employee... " + id);
		employeeService.deleteEmployee(id);
		return new ModelAndView("redirect:/employee/employees");
	}

	@PostMapping("/search")
	public ModelAndView searchCustomers(@RequestParam("empId") String empId) {
		System.out.println(this.getClass().getSimpleName() + ":Searching employee... " + empId);
		ModelAndView mav = new ModelAndView("employees");
		// search employee from the repository
		List<Employee> employeeList = employeeService.getEmployeeByEmpId(empId);
		// add the employee to the model
		mav.addObject("employeeList", employeeList);
		return mav;
	}

	// Search Employee through keyword 
	@PostMapping("/search-keyword")
	public ModelAndView search(@RequestParam("keyword") String keyword) {
		System.out.println(this.getClass().getSimpleName() + ":Searching employee through keyword... " + keyword);
		List<Employee> result = employeeService.search(keyword);
		ModelAndView mav = new ModelAndView("search-result");
		mav.addObject("result", result);
		return mav;
	}
	
	// Delete All Employee
	@GetMapping("/deleteAll")
	public ModelAndView removeAllEmployee() {
		System.out.println(this.getClass().getSimpleName() + ":deleting all employees... ");
		employeeService.deleteAllEmployee();
		return new ModelAndView("redirect:/employee/employees");
	}
	
}
