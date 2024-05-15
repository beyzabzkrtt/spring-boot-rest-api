package com.example.springbootrestapi.service.abstracts;

import java.util.List;

import com.example.springbootrestapi.dto.UserDto;
import com.example.springbootrestapi.entitiy.User;

public interface UserService {

	UserDto createUser(UserDto user);
	List<UserDto> getUsers();
	UserDto getUser(Long id);
	UserDto updateUser(Long id, UserDto user);
	Boolean deleteUser(Long id);
}
