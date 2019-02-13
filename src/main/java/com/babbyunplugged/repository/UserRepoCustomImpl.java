package com.babbyunplugged.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;

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
	public List<User> search(String roleName,final Pageable pageable) {
		String q = "select u from User u JOIN u.role role where role.name =:roleName";
		TypedQuery<User> qry = em.createQuery(OrderBy(q,pageable),User.class);
		qry.setParameter("roleName", roleName);
		Long offset = pageable.getOffset();
		qry.setFirstResult(offset.intValue());
		qry.setMaxResults(pageable.getPageSize());
		return qry.getResultList();
	}
	
	private String OrderBy(String qry,final Pageable pageable) {
		StringBuilder qryStr = new StringBuilder(qry);
		if(pageable.getSort().isEmpty()) {
			qryStr.append(" Order By ").append("u.name").append(" ")
	        .append("asc");
		}
		else {
			Iterator<Order> orderIterator = pageable.getSort().iterator();
			Order order = orderIterator.next();
			qryStr.append(" Order By ").append("u."+order.getProperty()).append(" ")
	        .append(order.getDirection().name());
		}
		return qryStr.toString();
	}

	public List<User> findUser(String searchStr,final Pageable pageable){
		String q = "select u from User u JOIN u.role role "+getWhere(searchStr);
		System.out.println("Query:"+q);
		TypedQuery<User> qry = em.createQuery(OrderBy(q,pageable),User.class);
		Long offset = pageable.getOffset();
		qry.setFirstResult(offset.intValue());
		qry.setMaxResults(pageable.getPageSize());
		return qry.getResultList();
	}

	private String getWhere(String str) {
		String[] conditions = str.split(",");
		System.out.println(conditions.length);
		String[] k = new String[2];
		StringBuilder builder = new StringBuilder("where 1=1"); 
		for (String condition : conditions) {
            System.out.println("condition:"+condition);
            if(condition.contains(":")) {
            	//equal
            	k = condition.split(":");
            	if(k[0].equalsIgnoreCase("role"))
            		builder.append(" and lower(role.name)"+" = '"+k[1].toLowerCase()+"'");
            	else
            		builder.append(" and lower(u."+k[0]+") = '"+k[1].toLowerCase()+"'");
            }
            else if(condition.contains("!")) {
            	//negation
            	k = condition.split("!");
            	if(k[0].equalsIgnoreCase("role"))
            		builder.append(" and lower(role.name)"+" != "+k[1].toLowerCase());
            	else
            		builder.append(" and lower(u."+k[0]+") != "+k[1].toLowerCase());
            }
            else if(condition.contains(">")) {
            	//greater then
            	k = condition.split(">");
            	builder.append(" and u."+k[0]+" > "+k[1]);
            }
            else if(condition.contains("<")) {
            	//less then
            	k = condition.split("<");
            	builder.append(" and u."+k[0]+" < "+k[1]);
            }
            else if(condition.contains("~")) {
            	//like
            	k = condition.split("~");
            	if(k[0].equalsIgnoreCase("role"))
            		builder.append(" and lower(role.name)"+" like '%"+k[1].toLowerCase()+"%'");
            	else
            		builder.append(" and lower(u."+k[0]+") like '%"+k[1].toLowerCase()+"%'");
            }
        }
		System.out.println(builder.toString());
		return builder.toString();
	}
}
