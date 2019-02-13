package com.babbyunplugged.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.babbyunplugged.entity.User;

@Repository
@Transactional
public interface UserRepoCustom {
	List<User> findUser(String email);
	
	List<User> search(@Param("roleName")String roleName,final Pageable pageable);
	List<User> findUser(String searchStr,final Pageable pageable);
}
