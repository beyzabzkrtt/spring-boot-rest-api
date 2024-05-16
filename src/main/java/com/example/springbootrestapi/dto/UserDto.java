package com.example.springbootrestapi.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class UserDto {

	private String firstName;
	private String lastName;
	private Date updatedAt;
	private String updatedBy;
}
