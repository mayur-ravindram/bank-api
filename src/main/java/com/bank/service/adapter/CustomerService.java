package com.bank.service.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Customer;
import com.bank.model.CustomerAddRequest;
import com.bank.model.CustomerAddResponse;
import com.bank.service.exception.BankException;
import com.bank.service.proxy.CustomerDBProxy;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerDBProxy proxy;
	
	public CustomerAddResponse onboard(Customer customer) throws BankException
	{
		CustomerAddResponse response = new CustomerAddResponse();
		CustomerAddRequest request = new CustomerAddRequest();
		
		request.setCustomerFirstName(customer.getFirstName());
		request.setCustomerMiddleName(customer.getMiddleName());
		request.setCustomerLastName(customer.getLastName());
		request.setDateOfBirth(customer.getDob());
		request.setGender(customer.getGender().toString());
		request.setEmail(customer.getEmail());
		request.setUid(Integer.parseInt(customer.getUid()));
		try {
			response = proxy.onboard(request);
		} catch (Exception e) {
			throw new BankException("Http Error!");
		}
		return response;
	}
	
	public String getTest() {
		return "Hello";
	}
}
