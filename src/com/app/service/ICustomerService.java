package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {
	public int saveCustomer(Customer cust);
	public void updateCustomer(Customer cust);
	public void deleteCustomer(int custId);
	public Customer getCustomerById(int custId);
	public List<Customer> getAllCustomers();
	public Customer getCustomerByEmail(String email);
}
