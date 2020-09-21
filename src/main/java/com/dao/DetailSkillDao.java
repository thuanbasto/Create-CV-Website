package com.dao;

import java.util.List;

import com.entity.Detailskill;

public interface DetailSkillDao {
	public void addDetailSkill(Detailskill detailskill);
	public List<Detailskill> getAllDetailSkillsBySkillId(int skill_ID);
}
