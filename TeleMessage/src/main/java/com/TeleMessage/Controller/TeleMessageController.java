package com.TeleMessage.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.TeleMessage.util.PhoneNumberValidation;

@RestController("/api/v1")
public class TeleMessageController {
	
	
	@PostMapping("/numberStatus")
	public Object validateNumbers(
			@RequestHeader(name = "x-date", required = false) Date xDate,
			@RequestHeader(name = "Signature", required = false) String signature,
			@RequestBody List<String> list) {
		
		HashMap <String,String> errorMessage = new HashMap<String,String>();
		
		if(xDate == null ) {
			errorMessage.put("status", "ERROR");
			errorMessage.put("statusInfo", "Date header not present");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
		}
		if(signature == null) {
			errorMessage.put("status", "ERROR");
			errorMessage.put("statusInfo", "Signature header not present");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
		}
		if(list.size() > 10) {
			errorMessage.put("statusInfo", "request exceeds maximum limit of numbers allowed max allowed 10");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
		}
		else {
			return PhoneNumberValidation.PhoneValidation(list);
		}
	}

}
