package com.dream.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.spring.dao.CustomerDAO;
import com.dream.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int customeId) {
		return customerDAO.getCustomer(customeId);
	}

	@Override
	@Transactional
	public void saveCusetomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customeId) {
		customerDAO.deleteCustomer(customeId);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String email) {
		return customerDAO.searchCustomers(email);
	}

	@Override
	@Transactional
	public boolean checkLogin(String email, String password) {	
		return customerDAO.checkLogin(email, password);
	}

}
