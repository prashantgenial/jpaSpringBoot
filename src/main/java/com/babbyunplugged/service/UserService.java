package com.babbyunplugged.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
	
	public static final String[] SIMPLE_OPERATION_SET = { ":", "!", ">", "<", "~" };
	
	public List<User> search(Map<String,String> params,final Pageable pageable){
		/*StringBuilder wh = new StringBuilder("where 1=1");
		if(!params.isEmpty()) {
			wh.append(" and ")
		}*/
			
		return userRepo.search("Admin",pageable);
	}
	
	public List<User> findUser(String searchStr,final Pageable pageable) {
		System.out.println("Search:"+searchStr);
		return userRepo.findUser(searchStr,pageable);		
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
