package com.dream.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.dream.spring.entity.Customer;
import com.dream.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private Logger logger = Logger.getLogger(CustomerController.class);
	//@InitBinder- Pre process every string data.
			//removes the leading & trailing white spaces.
			//If string only has white space .... trim it to null.
			
			
			@InitBinder
			public void initBinder(WebDataBinder dataBinder) {
				StringTrimmerEditor ste=new StringTrimmerEditor(true);
				dataBinder.registerCustomEditor(String.class, ste);
			}
	
//	 need to inject the customer dao
//	@Autowired
//	private CustomerDAO customerDAO;
	
	// need to inject the customer service
	@Autowired
	private CustomerService customerService;	
	
	
	
	@RequestMapping(path="/customer-form")
	public String addCustomer(Customer customer,Model model) {
		logger.info("Debug: Showing Customer Form");
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping(path="/login")
	public String loginCustomer(Customer customer,Model model) {
		logger.info("Debug: Showing Customer Login Form");
		model.addAttribute("customer", new Customer());
		return "customer-login";
	}
	
	@RequestMapping("/list")
	public String customerList(Model model) {
		logger.info("Debug: Showing Customer List");
		//get the customers from dao
		List<Customer> customers=customerService.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@RequestMapping(path="/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult br) {
		logger.info("Debug: Saving/Updating Customer...");
		if(br.hasErrors()) {
			logger.info("Debug: Error Occured");
			return "customer-form";
		}else {
			logger.info("Debug: In Else No Error Found.");
			customerService.saveCusetomer(customer);
			return "redirect:/customer/list";
		}
	}
	
	@RequestMapping(path="/loginCustomer")
	public String loginProcess(@Valid @ModelAttribute("customer") Customer customer,BindingResult br, @RequestParam("email") String email, @RequestParam("password") String password) {
		logger.info("Debug: During Customer Login...");
//		if(br.hasErrors()) {
//			logger.info("Debug: Error Occured During Customer Login.");
//			return "customer-login";
//		}else {
			logger.info("Debug: In Else No Error Found.");
			boolean status=customerService.checkLogin(email, password);
			logger.info(status+" "+email+" "+password);
			if(status) {
				logger.info("Debug: Redirecting...");
				return "redirect:/customer/list";
			}
			else {
				logger.info("Debug: Customer Not Found...");
				return "customer-login";
			}
		//}
	}
	
	@RequestMapping(path="/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int customeId, Model model) {
		logger.info("Debug: Updating Customer...");
		// get the customer from service
		Customer customer=customerService.getCustomer(customeId);
		// set customer as a model attribute to pre-populate the form.
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	
	
	@RequestMapping(path="/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId) {
		logger.info("Debug: Deleting Customer...");
		// get the customer from service
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/search")
    public String searchCustomers(@RequestParam("email") String email,Model theModel) {
		logger.info("Debug: Searching Customer...");
        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(email);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }
}
