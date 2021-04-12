package com.bcsp.project.dao;

import com.bcsp.project.model.User;

import java.util.List;


public interface UserDao {

	User findById(int id);
	
	User findByPERSONID(String pid);
	
	void save(User user);
	
	void deleteByPERSONID(String pid);
	
	List<User> findAllUsers();

}

