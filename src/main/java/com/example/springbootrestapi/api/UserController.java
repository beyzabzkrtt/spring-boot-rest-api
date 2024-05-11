package com.example.springbootrestapi.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestapi.service.abstracts.UserService;

@RestController
@RequestMapping(name="/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		
		this.userService = userService;
	}
	
	
	

}
