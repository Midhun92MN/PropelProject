package com.faith.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.entity.Role;
import com.faith.entity.User;
import com.faith.repo.IRoleRepo;
import com.faith.repo.IUserRepo;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepo userRepo;
	@Autowired
	IRoleRepo roleRepo;

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public List<Role> findAllRoles() {
		return (List<Role>) roleRepo.findAll();
	}

	@Transactional
	@Override
	public User insertUser(User user) {
		userRepo.save(user);
		return user;
	}

	@Transactional
	@Override
	public void updateUser(User user) {
		userRepo.save(user);
	}

	@Transactional
	@Override
	public void disableUserById(int userId) {
		userRepo.disableById(userId);
	}

	@Transactional
	@Override
	public void enableUserById(int userId) {
		userRepo.enableById(userId);
	}

	@Override
	public List<User> findUserByName(String fullName) {

		return userRepo.findByName(fullName);

	}
	
	@Override
	public Optional<User> findUserById(int userId) {
		return userRepo.findById(userId);
	}
	
	@Override
	public User findUserByNameAndPassword(String userName,String password){
		return userRepo.findByUsernameAndPassword(userName, password);
	}
}
