package com.tcs.fresco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationCheck authenticationCheck;


	@RequestMapping(value="/validate/{uname}", method = RequestMethod.GET)
    @ResponseBody
	public ResponseEntity<String> validateUser(@PathVariable String uname){
		boolean check=authenticationCheck.validateUser(uname);
		if(check) {
			return new ResponseEntity<String>("Valid", new HttpHeaders(),HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid", new HttpHeaders(),HttpStatus.OK);
	}


}
