package com.example.springbootrestapi.entitiy;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable{
	
	private Date createdDate;
	private String createdBy;
	private Date updatedAt;
	private String updatedBy;

}
