package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.model.Customer;
import com.bank.model.CustomerAddResponse;
import com.bank.model.ResponseStatus;
import com.bank.service.adapter.CustomerService;
import com.bank.service.exception.BankException;

@Component
public class CustomerServiceAdapter {

	@Autowired
	private CustomerService customerDBService;
	
	public CustomerAddResponse onboardCustomer(Customer customer) throws BankException {
		CustomerAddResponse addResponse = customerDBService.onboard(customer);
		addResponse.setConfirmationId("OID-76547");// confirmationId
		ResponseStatus respStatus = new ResponseStatus();
		if( null != addResponse && null != addResponse.getConfirmationId())
		{
			addResponse.setConfirmationId(addResponse.getConfirmationId());
			respStatus.setStatus("Success");
			addResponse.setResponseStatus(respStatus);
		}
		else
		{
			respStatus.setStatus("Failure");
			addResponse.setResponseStatus(respStatus);
		}
		return addResponse ;
	}
	
}
