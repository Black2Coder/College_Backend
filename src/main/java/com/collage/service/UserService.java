package com.collage.service;




import com.collage.entity.Users;
import com.collage.model.Post;
import com.collage.model.User;

public interface UserService  {
	
	public User authenticateUser(String contact, String password) throws Exception;
	public String registerUser(User user) throws Exception;
	public String post(Post post) throws Exception;
	public Users loginUser(String contact, String password) throws Exception;

}
