package com.example.springbootrestapi.api;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestapi.dto.UserDto;
import com.example.springbootrestapi.entitiy.User;
import com.example.springbootrestapi.service.abstracts.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		
		this.userService = userService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
		
		UserDto resultUser = userService.createUser(user);
		return ResponseEntity.ok(resultUser);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getUsers(){
		
		List<UserDto> users = userService.getUsers();
		return ResponseEntity.ok(users);
		
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
		UserDto user =  (UserDto) userService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id")Long id,UserDto user){
		UserDto resultUser = userService.updateUser(id,user);
		return ResponseEntity.ok(resultUser);
		
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
		Boolean status = userService.deleteUser(id);
		return ResponseEntity.ok(status);
	}
	
	
	

}
