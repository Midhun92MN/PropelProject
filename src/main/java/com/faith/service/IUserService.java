package com.faith.service;

import java.util.List;
import java.util.Optional;

import com.faith.entity.Role;
import com.faith.entity.User;

public interface IUserService {

	List<User> findAllUsers();

	List<Role> findAllRoles();

	User insertUser(User user);

	void updateUser(User user);

	void disableUserById(int userId);

	void enableUserById(int userId);

	public List<User> findUserByName(String fullName);
	
	public Optional<User> findUserById(int userId);

	public User findUserByNameAndPassword(String userName, String password);

}