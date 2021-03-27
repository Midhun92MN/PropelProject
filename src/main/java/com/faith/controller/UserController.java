package com.faith.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faith.entity.Role;
import com.faith.entity.User;
import com.faith.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping("users")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("roles")
	public List<Role> findAllRoles() {
		return userService.findAllRoles();
	}

	@GetMapping("users/{userId}")
	public Optional<User> findUserById(@PathVariable int userId) {
		return userService.findUserById(userId);
	}

	@GetMapping("users/name/{fullName}")
	public List<User> findUserByName(@PathVariable String fullName) {
		return userService.findUserByName(fullName);
	}

	@GetMapping("user-login/{userName}&{password}")
//	@GetMapping("users/{userName}")
	public User findUserByNameAndPassword(@PathVariable String userName, @PathVariable String password) {
		System.out.println("inside controller");
		return userService.findUserByNameAndPassword(userName, password);
	}

	@PostMapping("users")
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		System.out.println("inserting");

		return new ResponseEntity<User>(userService.insertUser(user), HttpStatus.OK);
	}

	@PutMapping("users")
	public User updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return user;
	}

	@GetMapping("users/enable/{userId}")
	public void enableUserById(@PathVariable int userId) {
		userService.enableUserById(userId);
	}

	@GetMapping("users/disable/{userId}")
	public void disableUserById(@PathVariable int userId) {
		userService.disableUserById(userId);
	}

}
