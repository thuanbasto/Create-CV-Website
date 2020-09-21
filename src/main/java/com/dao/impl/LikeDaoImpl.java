package com.dao.impl;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LikeDao;
import com.entity.Like;

@Repository
@Transactional
public class LikeDaoImpl implements LikeDao{

	@Autowired
	SessionFactory sessionFactory;

	public void addLike(Like like) {
		sessionFactory.getCurrentSession().save(like);
	}

	public void deleteLike(Like like) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from com.entity.Like s where s.user1=:user1 and s.user2=:user2")
					.setParameter("user1", like.getUser1())
					.setParameter("user2", like.getUser2())
					.executeUpdate();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
	}

	public boolean checkLike(Like like) {
		Like l; 
		try{
			l = (Like) sessionFactory.getCurrentSession().createQuery("from com.entity.Like s where s.user1=:user1 and s.user2=:user2")
				.setParameter("user1", like.getUser1())
				.setParameter("user2", like.getUser2())
				.getSingleResult();
		} catch (NoResultException e) {
			l = null;
		}
		if (l == null)
			return false; // chua like
		else 
			return true; // da like
	}

	public long countLike(Like like) {
		try{
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession()
					.createQuery("select count(user2) from com.entity.Like where user2=:user2")
					.setParameter("user2", like.getUser2());
			Long count = (Long)query.uniqueResult();
			return count;
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
