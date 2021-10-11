package com.collage.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.collage.entity.PostEntity;

import com.collage.model.User;


public interface UserDAO {
	
	
	public User getUserByContactNumber(String contactNumber) throws Exception;
}
