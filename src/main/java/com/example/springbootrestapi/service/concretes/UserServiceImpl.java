package com.example.springbootrestapi.service.concretes;

import java.util.Arrays;
import java.util.Date;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.example.springbootrestapi.advice.UserNotFound;
import com.example.springbootrestapi.dto.UserDto;
import com.example.springbootrestapi.entitiy.User;
import com.example.springbootrestapi.repository.UserRepository;
import com.example.springbootrestapi.service.abstracts.UserService;
import com.example.springbootrestapi.util.CustomPage;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@Service
@RequiredArgsConstructor //injection icin contructor
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = modelMapper.map(userDto,User.class);
		user.setCreatedDate(new Date());
		user.setCreatedBy("Admin");
		return modelMapper.map(userRepository.save(user), UserDto.class);
	}

	@Override
	public List<UserDto> getUsers() {
		List<User> users = userRepository.findAll();
		List<UserDto> dtos = users.stream().map(user -> modelMapper.map(users, UserDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public UserDto getUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return modelMapper.map(user.get(),UserDto.class);
		}
		throw new UserNotFound("Kullanıcı bulunamadı");
	}

	@Override
	public UserDto updateUser(Long id, UserDto user) {
		Optional<User> resultUser = userRepository.findById(id);
		
		if(resultUser.isPresent()) {
			resultUser.get().setFirstName(user.getFirstName());
			resultUser.get().setLastName(user.getLastName());
			resultUser.get().setUpdatedAt(user.getUpdatedAt());
			resultUser.get().setUpdatedBy(user.getUpdatedBy());
			
			return modelMapper.map(userRepository.save(resultUser.get()),UserDto.class);
		}
		throw new IllegalArgumentException("Kullanıcı bulunamadı");
	} 

	@Override
	public Boolean deleteUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Page<User> pagination(int currentPage, int pageSize) {
		
		Pageable pageable = PageRequest.of(currentPage, pageSize);
		return userRepository.findAll(pageable);
	}

	@Override
	public Page<User> pagination(Pageable pageable) {

			return userRepository.findAll(pageable);
	}

	@Override
	public Slice<User> slice(Pageable pageable) {
		
		return userRepository.findAll(pageable);
	}

	@Override
	public CustomPage<UserDto> customPagination(Pageable pageable) {
		
		Page<User> data = userRepository.findAll(pageable);
		UserDto[] dtos = modelMapper.map(data.getContent(), UserDto[].class);
		return new CustomPage<UserDto>(data,Arrays.asList(dtos));
	} 
	
}
