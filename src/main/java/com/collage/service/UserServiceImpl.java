package com.collage.service;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.collage.dto.DummyUser;
import com.collage.dto.UserDAO;
import com.collage.dto.UserRepo;
import com.collage.entity.PostEntity;
import com.collage.entity.Users;

import com.collage.model.Post;
import com.collage.model.User;
import com.collage.utility.HashingUtility;
import com.collage.validator.Validation;



@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User authenticateUser(String contact, String password) throws Exception{
		
		Validation.validateUserForLogin(contact, password);
		User userDB = userDAO.getUserByContactNumber(contact);
		if(userDB== null) {
			throw new Exception("Invalid Credentials");
		}
		String passDB=userDB.getPassword();
		if(passDB!= null) {
			String hashedPassword = HashingUtility.getHashValue(password);
			
			if(hashedPassword.equals(passDB)) {
				userDB.setPassword(null);
				return userDB;
			}else {
				throw new Exception("Invalid Credentioals");
			}
		}
		else {
			throw new Exception("Invalid Credentioals");
		}
	}
	
	@Override
	public User loginUser(String contact, String password) throws Exception {
		
		String hashedPassword = HashingUtility.getHashValue(password);
		User user = repo.findByContactAndPassword(contact, hashedPassword);
		
		return user;
		
	}
	
	@Override
	public String registerUser(User user) throws Exception{
//		try {
			Validation.validateUserForLogin(user.getContact(), user.getPassword());
			Users userEntity = new Users();
			
			userEntity.setUserName(user.getUserName());
			
			userEntity.setEmailId(user.getEmailId());
			userEntity.setContact(user.getContact());
			
			String hashedPassword = HashingUtility.getHashValue(user.getPassword());
			userEntity.setPassword(hashedPassword);
			repo.save(userEntity);
//			entityManager.persist(userEntity);
			return userEntity.getUserName();
//		}
//		
//		catch(Exception e){
//			System.out.println("Exception");
//			System.out.println((e.getMessage()).toString());
//			ErrorInfo error = new ErrorInfo();
//			error.setErrorCode(HttpStatus.ALREADY_REPORTED.value());
//			throw new Exception("Mobile number is already registered "+ (e.getMessage()));
//		}
		
	}
	
	public DummyUser dummyData() {
		
		DummyUser u1 = new DummyUser(1, "Uday", "uday@gmail.com", "9986748514","abcd1234");
		return u1;
	}
	@Override
	public String post(Post post) throws Exception{
		
		PostEntity postEntity = new PostEntity();
		postEntity.setTitle(post.getTitle());
		postEntity.setDescription(post.getDescription());
		entityManager.persist(postEntity);
		
		return "Posted";
		
	}
}
