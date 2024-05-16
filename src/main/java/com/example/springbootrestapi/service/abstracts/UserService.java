package com.example.springbootrestapi.service.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.example.springbootrestapi.dto.UserDto;
import com.example.springbootrestapi.entitiy.User;
import com.example.springbootrestapi.util.CustomPage;

public interface UserService {

	UserDto createUser(UserDto user);
	List<UserDto> getUsers();
	UserDto getUser(Long id);
	UserDto updateUser(Long id, UserDto user);
	Boolean deleteUser(Long id);
	Page<User> pagination(int currentPage,int pageSize);
	Page<User> pagination(Pageable pageable);
	Slice<User> slice(Pageable pageable);
	CustomPage<UserDto> customPagination(Pageable pageable);
	

}
