package com.babbyunplugged.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.babbyunplugged.entity.User;
import com.babbyunplugged.service.UserService;

@RestController
@RequestMapping
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService ;
	

	@RequestMapping(method=RequestMethod.POST,value="/search",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> search(@RequestBody(required=false) Map<String,String> params,Sort sort) {
		LOGGER.info("Inside Search.......................");
		LOGGER.info(""+params);
		LOGGER.info(""+sort);
		return userService.search(sort);
	}

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
