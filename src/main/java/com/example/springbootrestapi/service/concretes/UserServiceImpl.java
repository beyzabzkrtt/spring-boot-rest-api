package com.example.springbootrestapi.service.concretes;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.springbootrestapi.entitiy.User;
import com.example.springbootrestapi.repository.UserRepository;
import com.example.springbootrestapi.service.abstracts.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //injection icin contructor
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		user.setCreatedDate(new Date());
		user.setCreatedBy("Admin");
		return userRepository.save(user);
	} 
	
}
