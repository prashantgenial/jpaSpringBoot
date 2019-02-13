package com.babbyunplugged.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.babbyunplugged.entity.User;

/**
 * 
 * @author MHQG9765
 *
 */
public class UserRepoCustomImpl implements UserRepoCustom {

	@PersistenceContext
    private EntityManager em;

	
	@Override
	public List<User> findUser(String email) {
		TypedQuery<User> qry = em.createQuery("select u from User u where email =:email",User.class);
	    qry.setParameter("email", email);
	    return qry.getResultList();
	}


	@Override
	@Transactional
	public List<User> findUserByRoleName(String roleName) {
		TypedQuery<User> qry = em.createQuery("select u from User u JOIN u.role role where role.name =:roleName",User.class);
	    qry.setParameter("roleName", roleName);
	    return qry.getResultList();
	}
	
	

}
