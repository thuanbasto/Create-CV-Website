package com.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TypecvDao;
import com.entity.Typecv;

@Repository
@Transactional
public class TypecvDaoImpl implements TypecvDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Typecv getTypeCVById(int id) {
		return (Typecv) sessionFactory.getCurrentSession().get(Typecv.class, id);
	}
	
}
