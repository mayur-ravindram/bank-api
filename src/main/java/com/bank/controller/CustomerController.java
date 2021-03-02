package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Customer;
import com.bank.model.CustomerAddResponse;
import com.bank.service.CustomerServiceAdapter;
import com.bank.service.exception.BankException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerServiceAdapter customerServiceAdapter;
	
	@GetMapping("/ping")
	public String healthCheck()
	{
		return "200 OK!";
	}
	
	@PostMapping("/onboard")
	public CustomerAddResponse addCustomer(@RequestBody Customer customer) throws BankException
	{
		CustomerAddResponse response = this.customerServiceAdapter.onboardCustomer(customer);
		return response;
	}
}
