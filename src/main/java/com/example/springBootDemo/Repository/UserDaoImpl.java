package com.example.springBootDemo.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springBootDemo.Model.User;
/**
 * 
 * @author Swati Zendewale
 *
 */
@Repository
public class UserDaoImpl {
	
	@Autowired
	EntityManager entityManager;
	
	
	private Session getSession() {
		Session session= (Session) entityManager.getDelegate();
		return session;
	}
	
	public List<User> fetchUsers(User user){
	Criteria cr = getSession().createCriteria(User.class);
	if(user.getUserGender()!=null) {
	cr.add(Restrictions.like("userGender", "%" +user.getUserGender()+ "%"));
	}
	if(user.getUserId()!=null) {
		cr.add(Restrictions.eq("userId", user.getUserId()));

	}
	if(user.getUserAge()!=null) {
		cr.add(Restrictions.eq("userAge", user.getUserAge()));
	}
	return cr.list();
	}

}




