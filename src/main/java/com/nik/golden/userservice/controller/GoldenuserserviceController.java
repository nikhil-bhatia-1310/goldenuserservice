package com.nik.golden.userservice.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.nik.golden.userservice.model.GoldenuserserviceModel;

@RestController
@RequestMapping("/goldenusers")
public class GoldenuserserviceController {

	@Autowired
	GoldenuserserviceControllerService service;
	
	@GetMapping("/status/check")
	public ResponseEntity<Object> status()
	{
		GoldenuserserviceModel model = new GoldenuserserviceModel();
		model.setId(1);
		model.setName("Golden User Model Name");
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
}