package com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DetailSkillDao;
import com.entity.Detailskill;
import com.entity.Skill;

@Repository
@Transactional
public class DetailSkillDaoImpl implements DetailSkillDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public void addDetailSkill(Detailskill detailskill) {
		sessionFactory.getCurrentSession().save(detailskill);
	}

	@SuppressWarnings("unchecked")
	public List<Detailskill> getAllDetailSkillsBySkillId(int skill_ID) {
		Skill skill = new Skill(skill_ID);
		@SuppressWarnings("deprecation")
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Detailskill.class).add(Restrictions.eq("skill", skill));
		return criteria.list();
	}

}
