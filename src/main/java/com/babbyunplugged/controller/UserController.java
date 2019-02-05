package com.babbyunplugged.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babbyunplugged.entity.User;
import com.babbyunplugged.service.UserService;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService userService ;

	@GetMapping("/user/{id}")
	public Optional<User> findById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}
	
	
	public User save(User user) {
		return userService.save(user);
	}
}
