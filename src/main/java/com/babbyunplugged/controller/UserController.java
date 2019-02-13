package com.babbyunplugged.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Page<User> search(@RequestBody(required=false) Map<String,String> params,final Pageable pageable) {
		LOGGER.info("Inside Search.......................");
		LOGGER.info(""+params);
		//LOGGER.info(""+sort);
		LOGGER.info("page:"+pageable);
		List<User> users = userService.search(params,pageable); //pageable contains page and sorting information both
		return new PageImpl<>(users,pageable,users.size());	//Converting List to Page
	}

	@RequestMapping(method=RequestMethod.GET,value="/user/search")
	public List<User> find(@RequestParam("search") String str,final Pageable pageable) {
		LOGGER.info("page:"+pageable);
		return userService.findUser(str,pageable);
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
