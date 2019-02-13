package com.babbyunplugged.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
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
	public List<User> findUserByRoleName(String roleName, Sort sort) {
		String q = "select u from User u JOIN u.role role where role.name =:roleName";
		TypedQuery<User> qry = em.createQuery(OrderBy(q,sort),User.class);
		qry.setParameter("roleName", roleName);
		return qry.getResultList();
	}
	
	private String OrderBy(String qry,Sort sort) {
		Iterator<Order> orderIterator = sort.iterator();
		Order order = orderIterator.next();
		StringBuilder qryStr = new StringBuilder(qry);
		qryStr.append(" Order By ").append("u."+order.getProperty()).append(" ")
        .append(order.getDirection().name());
		return qryStr.toString();
	}


}
