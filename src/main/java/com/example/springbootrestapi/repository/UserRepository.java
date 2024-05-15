package com.example.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootrestapi.entitiy.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	
	User findByFirstName(String firstName);
	User findByFirstNameAndLastName(String firstName,String lastName);
	

}
