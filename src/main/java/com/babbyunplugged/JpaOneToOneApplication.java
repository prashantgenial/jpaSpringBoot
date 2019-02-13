package com.babbyunplugged;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.babbyunplugged.entity.User;
import com.babbyunplugged.repository.UserRepo;

@SpringBootApplication
public class JpaOneToOneApplication implements CommandLineRunner {

	private Logger logger =LoggerFactory.getLogger(JpaOneToOneApplication.class);
	
	@PersistenceContext
	EntityManager em;

	
	@Autowired
	UserRepo userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		//logger.info("Custom repo result:",userRepo.findUser("amit.gupta@orange.com"));
		//logger.info("Users by role:",userRepo.findUserByRoleName("Admin"));	//get data based on Join
	/*	Role role = new Role("Reporter");
		em.persist(role);
		
		User u = new User("Shyam");
		u.setRole(role);
		//role.setUser(u);
		em.persist(u);
*/		
		/*1.
		 *  select
        user0_.id as id1_1_,
        user0_.created_date as created_2_1_,
        user0_.last_updated_date as last_upd3_1_,
        user0_.name as name4_1_         
    from
        user user0_ 
    where
        user0_.id=?
		 */
		/*User u1 = em.find(User.class, 10006L);
		logger.info("User u1 -> {}",u1.getName());
		logger.info("User u1 Role -> {}",u1.getRole());*/
		
		/*
		 *  select
        user0_.id as id1_1_,
        user0_.created_date as created_2_1_,
        user0_.last_updated_date as last_upd3_1_,
        user0_.name as name4_1_,
        user0_.role_id as role_id5_1_ 
    from
        user user0_ 
    where
        user0_.id=?
		 */
		//Don't use this JPQL as it will retrieve all the properties which we don't need
		/*TypedQuery<User> q = em.createQuery("Select u From User u where u.id=?1",User.class);
		q.setParameter(1, 10006L);
		User u = q.getSingleResult();
		logger.info("result -> {}",u.getName());*/
		
		
		/*
		 *  select
        user0_.name as col_0_0_,
        user0_.created_date as col_1_0_,
        user0_.last_updated_date as col_2_0_ 
    from
        user user0_ 
    where
        user0_.id=?
		 */
		//so either use find method or use selected columns
		/*Query q = em.createQuery("Select u.name,u.createdDate,u.lastUpdatedDate From User u where u.id=?1");
		q.setParameter(1, 10006L);
		
		Object result = q.getSingleResult();
		logger.info("result -> {}",result);*/
		
		//TODO: criteria query,PagingAndSortingRepository don't use findById()
		/*
		 *  select
        user0_.id as id1_1_0_,
        user0_.created_date as created_2_1_0_,
        user0_.last_updated_date as last_upd3_1_0_,
        user0_.name as name4_1_0_,
        user0_.role_id as role_id5_1_0_ 
    from
        user user0_ 
    where
        user0_.id=?
		 */
		/*Optional<User> user = userRepo.findById(10006L);
		logger.info("User details -> {}",user);*/
	}

}

