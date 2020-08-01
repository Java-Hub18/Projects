package com.dream.spring.dao;

import java.util.List;

import com.dream.spring.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int customeId);
	public void deleteCustomer(int customeId);
	public List<Customer> searchCustomers(String email);
	public boolean checkLogin(String email,String password);
}
