package org.cdac.ankit.springhibernate.dao;

import java.util.List;

import javax.annotation.Resource;

import org.cdac.ankit.hibernate.model.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

@Repository
public class UserHinbernateDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDetail getUser(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetail user=(UserDetail)session.get(UserDetail.class, 1);
		return user;
	}

}
