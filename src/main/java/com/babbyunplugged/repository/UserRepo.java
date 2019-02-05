package com.babbyunplugged.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.babbyunplugged.entity.User;

@Repository
@Transactional
public interface UserRepo extends PagingAndSortingRepository<User,Long> {
	
		/*
		 * select
        user0_.id as id1_1_0_,
        role1_.id as id1_0_1_,
        user0_.created_date as created_2_1_0_,
        user0_.last_updated_date as last_upd3_1_0_,
        user0_.name as name4_1_0_,
        user0_.role_id as role_id5_1_0_,
        role1_.created_date as created_2_0_1_,
        role1_.last_updated_date as last_upd3_0_1_,
        role1_.name as name4_0_1_ 
    from
        user user0_ 
    left outer join
        role role1_ 
            on user0_.role_id=role1_.id 
    where
        user0_.id=?
		 * @see org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
		 */
	 	/*@Query(value = "SELECT u FROM User u LEFT JOIN FETCH u.role where u.id = :id")
	    Optional<User> findById(@Param("id") Long id);*/

}
