package com.example.springbootrestapi.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestapi.entitiy.User;
import com.example.springbootrestapi.service.abstracts.UserService;

@RestController
@RequestMapping(name="/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		
		this.userService = userService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User resultUser = userService.createUser(user);
		return ResponseEntity.ok(resultUser);
		
	}
	
	
	

}
