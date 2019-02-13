package com.babbyunplugged.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babbyunplugged.entity.User;
import com.babbyunplugged.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	/*public Page<User> findAll() {
		return userRepo.findAll();
	}*/
	
	public List<User> search(){
		return userRepo.findUserByRoleName("Admin");
	}
	
	public Optional<User> findById(Long id) {
		return userRepo.findById(id);
	}
	
	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}
	
	public User save(User user) {
		return userRepo.save(user);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}
}
