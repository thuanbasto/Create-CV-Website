package com.dao;

import java.util.List;

import com.entity.Skill;

public interface SkillDao {
	public void addSkill(Skill skill);
	public void updateSkill(Skill skill);
	public void deleteSkill(int id);
	public Skill getSkillById(int id);
	public List<Skill> getAllSkillsByUserId(int id);
	public void deleteAllSkillById(int id);
	public int getIdSkillByUserId(int id);
}
