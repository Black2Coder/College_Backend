package com.collage.dto;

import com.collage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import com.collage.entity.Users;

import java.util.Optional;


public interface UserRepo extends JpaRepository<Users, Integer>{
	public Users findByContactAndPassword(String contact, String Password);

	Users findByContact(String contact);



}
