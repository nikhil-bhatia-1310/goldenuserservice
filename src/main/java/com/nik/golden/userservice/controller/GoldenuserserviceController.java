package com.nik.golden.userservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.nik.golden.userservice.model.EmployeeModel;
import com.nik.golden.userservice.model.GoldenuserserviceModel;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/goldenusers")
@CrossOrigin("http://localhost:3000/")
public class GoldenuserserviceController {

	@Autowired
	GoldenuserserviceControllerService service;
	
	@Autowired
	EurekaInstanceConfigBean eurekaConfigBean;
	
	@GetMapping("/status/check")
	public ResponseEntity<Object> status()
	{
		ResponseEntity<Object> response = null;
		try 
		{
			response = service.getAccountMgmt();
		} 
		catch (RestClientException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (response == null)
			{
				 MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<String, String>();
				 multiValueMap.add("message", "There is a problem");
				 multiValueMap.add("status", "400");
				 multiValueMap.add("data", "There is some problem");
				 multiValueMap.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
				 
		         String encoding = multiValueMap.get("Accept-Encoding").stream().map(String::toString)
		 				.collect(Collectors.joining(","));
		         
		         String contentType = multiValueMap.get("Content-Type").get(0);
		         
		         response = new ResponseEntity<Object>(encoding + "," + contentType, HttpStatus.OK);
		    }
		}
		return response;
	}
	
	@GetMapping("/hello")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "fallback")
	public ResponseEntity<Object> hello()
	{
		GoldenuserserviceModel model = new GoldenuserserviceModel();
		model.setId(1);
		model.setName("Golden User Model Name" +eurekaConfigBean.getInstanceId());

        ResponseEntity<Object> response = new ResponseEntity<Object>(model, HttpStatus.OK);
        
        return response;
	}
	
	public ResponseEntity<Object> fallback()
	{
		GoldenuserserviceModel model = new GoldenuserserviceModel();
		model.setName("Golden User Rate Limited" +eurekaConfigBean.getInstanceId());

        ResponseEntity<Object> response = new ResponseEntity<Object>(model, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> getUsers()
	{
		List<EmployeeModel> userList = new ArrayList<EmployeeModel>();
		
		userList.add(new EmployeeModel(1, "Nikhil", "Bhatia", "nik@email.com"));
		userList.add(new EmployeeModel(1, "n", "Bhatia", "nik@email.com"));
		userList.add(new EmployeeModel(1, "Nl", "Bhatia", "Nl@email.com"));
		userList.add(new EmployeeModel(1, "Nil", "Bhatia", "Nil@email.com"));
		userList.add(new EmployeeModel(1, "ikh", "Bhatia", "ikh@email.com"));
		userList.add(new EmployeeModel(1, "Nhil", "Bhatia", "Nhil@e111mail.com"));
		userList.add(new EmployeeModel(1, "hil", "Bhatia", "hil@email.com"));
		
        ResponseEntity<Object> response = new ResponseEntity<Object>(userList, HttpStatus.OK);
        
        return response;
	}
	
}
