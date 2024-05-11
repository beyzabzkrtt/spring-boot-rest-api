package com.example.springbootrestapi.service.concretes;

import org.springframework.stereotype.Service;

import com.example.springbootrestapi.repository.UserRepository;
import com.example.springbootrestapi.service.abstracts.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //injection icin contructor
public class UserServiceImpl implements UserService{

	private UserRepository userRepository; 
	
}
