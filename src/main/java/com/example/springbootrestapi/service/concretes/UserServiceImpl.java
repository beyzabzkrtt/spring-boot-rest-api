package com.example.springbootrestapi.service.concretes;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.springbootrestapi.dto.UserDto;
import com.example.springbootrestapi.entitiy.User;
import com.example.springbootrestapi.repository.UserRepository;
import com.example.springbootrestapi.service.abstracts.UserService;

import lombok.RequiredArgsConstructor;

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
		return null;
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
		return null;
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
	
}
