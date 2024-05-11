package com.example.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootrestapi.entitiy.User;


//@Repository e gerek yok cünkü jparepositeryden extends edildi
public interface UserRepository  extends JpaRepository<User, Long>{
	
	User findByFirstName(String firstName);
	User findByFirstNameAndLastName(String firstName,String lastName);
	

}
