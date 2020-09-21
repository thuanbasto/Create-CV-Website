package com.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SkillDao;
import com.entity.Skill;
import com.entity.User;

@Repository
@Transactional
public class SkillDaoImpl implements SkillDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addSkill(Skill skill) {
		sessionFactory.getCurrentSession().save(skill);
	}
	public void deleteSkill(int id) {
		sessionFactory.getCurrentSession().delete(getSkillById(id));
	}
	public void updateSkill(Skill skill) {
		sessionFactory.getCurrentSession().merge(skill);
	}
	
	@SuppressWarnings("unchecked")
	public List<Skill> getAllSkillsByUserId(int id) {
		User user = new User(id);
		@SuppressWarnings("deprecation")
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Skill.class).add(Restrictions.eq("user", user));
		return criteria.list();
	}
	public Skill getSkillById(int id) {
		return (Skill) sessionFactory.getCurrentSession().get(Skill.class, id);
	}
	public void deleteAllSkillById(int id) {
		User user = new User(id);
		try {
			sessionFactory.getCurrentSession().createQuery("delete from com.entity.Skill s where s.user=:user")
					.setParameter("user", user).executeUpdate();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
	}
	
	public int getIdSkillByUserId(int id) {
		List<Skill> listSkill = getAllSkillsByUserId(id);
		return listSkill.get(listSkill.size()-1).getSkill_ID();
	}
	
}
