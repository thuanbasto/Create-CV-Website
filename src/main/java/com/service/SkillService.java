package com.service;

import java.util.List;

import com.model.SkillDTO;

public interface SkillService {
	public void addSkill(SkillDTO skillDTO,int id);
	public void updateSkill(SkillDTO skillDTO);
	public void deleteSkill(int id);
	public SkillDTO getSkillById(int id);
	public List<SkillDTO> getAllSkillsByUserId(int id);
	public void deleteAllSkillById(int id);
	public int getIdSkillByUserId(int id);
}
