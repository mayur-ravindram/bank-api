package com.bank;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.service.adapter.CustomerService;
import com.bank.service.exception.BankException;
import com.bank.service.proxy.CustomerDBProxy;

@SpringBootTest
class BankApplicationTests {

	// class to be test
	@Autowired
	private CustomerService service;

	@Mock
	private CustomerDBProxy proxy;

	@Before
	public void setup() {
	}

	@Test
	public void testOnboardCall() throws BankException {
		String response = service.getTest();
		System.out.println(response);
	}

}
