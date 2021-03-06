package com.bcsp.project.service;

import com.bcsp.project.dao.UserDao;
import com.bcsp.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByPERSONID(String pid) {
		User user = dao.findByPERSONID(pid);
		return user;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setPersonId(user.getPersonId());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFullName(user.getFullName());
			entity.setMobileNumber(user.getMobileNumber());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	
	public void deleteUserByPERSONID(String pid) {
		dao.deleteByPERSONID(pid);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserPERSONIDUnique(Integer id, String pid) {
		User user = findByPERSONID(pid);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
