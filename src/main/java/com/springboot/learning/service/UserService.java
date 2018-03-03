package com.springboot.learning.service;

import java.util.List;

import com.springboot.learning.model.User;

public interface UserService {

	List<User> getAllUsers();
	
	User getUserDetails(long id);
	
	boolean isUserPresent(User user);
	
	void saveUser(User user);
	
	void updateUser(User user); 
}
