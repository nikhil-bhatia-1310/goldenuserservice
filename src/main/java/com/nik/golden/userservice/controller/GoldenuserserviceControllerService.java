package com.nik.golden.userservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class GoldenuserserviceControllerService {
	
	@Autowired
    private GoldenaccountmgmtserviceClient accountMgmtServiceClient;

	public ResponseEntity<Object> getAccountMgmt() throws RestClientException, IOException {

		ResponseEntity<Object> response=null;
		try
		{
			response = accountMgmtServiceClient.statusCheck();
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		return response;
	}
}
