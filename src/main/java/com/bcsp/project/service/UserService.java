package com.bcsp.project.service;

import com.bcsp.project.model.User;

import java.util.List;


public interface UserService {
	
	User findById(int id);
	
	User findByPERSONID(String pid);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByPERSONID(String pid);

	List<User> findAllUsers(); 
	
	boolean isUserPERSONIDUnique(Integer id, String pid);

}