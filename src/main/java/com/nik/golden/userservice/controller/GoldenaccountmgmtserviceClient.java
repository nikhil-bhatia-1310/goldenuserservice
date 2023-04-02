package com.nik.golden.userservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="goldenaccountmgmtservice")
public interface GoldenaccountmgmtserviceClient {

	@GetMapping("/goldenaccountmgmt/status/check")
    public ResponseEntity<Object> statusCheck();
}
