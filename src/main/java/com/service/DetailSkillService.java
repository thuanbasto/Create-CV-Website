package com.service;

import java.util.List;

import com.model.DetailskillDTO;

public interface DetailSkillService {
	public void addDetailSkill(DetailskillDTO detailskillDTO, int skill_id);
	public List<DetailskillDTO> getAllDetailSkillsBySkillId(int skill_ID);
}
