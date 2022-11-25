package com.gl.customer.service;


import java.util.List;

import com.gl.customer.model.Customer;

public interface CustomerService {
	//fetch
	public List<Customer> getAll();
	public Customer getById(int id);
	public List<Customer> getByName(String name, String dept, String country);
	//save
	public void saveOrUpdateCustomer(Customer std);
	//remove
	public void removeCustomer(Customer std);
	public void removeCustomer(int id);

}
