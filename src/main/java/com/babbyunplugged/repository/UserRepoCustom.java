package com.babbyunplugged.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.babbyunplugged.entity.User;

@Repository
@Transactional
public interface UserRepoCustom {
	List<User> findUser(String email);
	
	List<User> findUserByRoleName(@Param("roleName")String roleName);
}
