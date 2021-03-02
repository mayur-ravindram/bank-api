package com.bank.service.proxy;

import java.net.URI;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.bank.model.CustomerAddRequest;
import com.bank.model.CustomerAddResponse;
import com.bank.model.ResponseStatus;

@Component
public class CustomerDBProxy {
	@Autowired
	private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(CustomerDBProxy.class);

	public CustomerAddResponse onboard(CustomerAddRequest customerData) {
		ResponseEntity<CustomerAddResponse> response = null;
		try {
			URI url = new URI("http://localhost:8020/db/bank/account/save");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<CustomerAddRequest> request = new HttpEntity<CustomerAddRequest>(customerData, headers);
			
			response = restTemplate.postForEntity(url, request, CustomerAddResponse.class);
			logger.trace("customer info saved successfully!");
		} catch (HttpServerErrorException e) {
			logger.error(e.getMessage());
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			CustomerAddResponse body = new CustomerAddResponse();
			ResponseStatus respStatus = new ResponseStatus();
			respStatus.setStatus("Failure");
			body.setResponseStatus(respStatus );
			body.setStatusReason(e.getMessage());
			return ResponseEntity.unprocessableEntity().body(body).getBody();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return response.getBody();
	}
}
