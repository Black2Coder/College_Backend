package com.collage.dto;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collage.entity.PostEntity;
import com.collage.entity.Users;
import com.collage.model.User;

@Repository(value="userDAO")
public class UserDAOImpl implements UserDAO{
	@Autowired
	EntityManager entityManager;
	
	
	public User getUserByContactNumber(String contactNumber) throws Exception{
		
		Query query = entityManager.createQuery( "select u from Users u where u.contact =?1");
		query.setParameter(1, contactNumber);
		User user = null;
		List<Users> userEntity = query.getResultList();
		
		if(!userEntity.isEmpty()) {
			Users userEntity2= userEntity.get(0);
			user = new User();
			user.setUserId(userEntity2.getUserId());
			user.setUserName(userEntity2.getUserName());
			user.setEmailId(userEntity2.getEmailId());
			user.setContact(userEntity2.getContact());
			user.setPassword(userEntity2.getPassword());
		}
		return user;
	}


	
	
	
}
