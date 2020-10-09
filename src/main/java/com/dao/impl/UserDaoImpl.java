package com.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().merge(user);
	}

	public void deleteUser(int id) {
		sessionFactory.getCurrentSession().delete(getUserById(id));
	}

	public User getUserById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		@SuppressWarnings("deprecation")
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		return criteria.list();
	}

	public boolean checkUsername(String username) {
		User user;
		try {
			user = (User) sessionFactory.getCurrentSession().createQuery("from com.entity.User u where u.username=:username")
					.setParameter("username", username)
					.getSingleResult();
		} catch (NoResultException e) {
			user = null;
		}
		if (user == null)
			return true;
		else 
			return false;
	}

	public User getUserByUserName(String username) {
		User user = (User) sessionFactory.getCurrentSession().createQuery("from com.entity.User u where u.username=:username")
				.setParameter("username", username)
				.getSingleResult();;
		return user;
	}

	@SuppressWarnings("rawtypes")
	public Object[] getUsersWithLikes(String username) {
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("SELECT u.user_ID,u.name,u.address,u.birthday,u.phone,u.email,u.career,u.maxim,u.facebook,u.imageUrl,u.username,u.typecv,Count(l.user1) "
					+ "FROM com.entity.User u LEFT JOIN com.entity.Like l ON u.user_ID = l.user2 "
					+ "WHERE u.username =: username "
					+ "GROUP BY u.user_ID")
					.setParameter("username", username);
			Object[] user = (Object[]) query.uniqueResult();
			
			if (user == null) {
				query = sessionFactory.getCurrentSession()
						.createQuery("SELECT u.user_ID,u.name,u.address,u.birthday,u.phone,u.email,u.career,u.maxim,u.facebook,u.imageUrl,u.username,u.typecv "
								+ "FROM com.entity.User u "
								+ "WHERE u.username =: username")
						.setParameter("username", username);
				user = (Object[]) query.uniqueResult();
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Object[]> getAllUsersWithLikes() {
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("SELECT u.user_ID,u.name,u.username,u.email,Count(l.user2) FROM com.entity.User u,com.entity.Like l "
					+ "WHERE u.user_ID = l.user2 "
					+ "GROUP BY u.user_ID "
					+ "HAVING Count(l.user2) > 0 ORDER BY(Count(l.user2)) DESC");
			@SuppressWarnings("unchecked")
			List<Object[]> users = query.getResultList();	
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
