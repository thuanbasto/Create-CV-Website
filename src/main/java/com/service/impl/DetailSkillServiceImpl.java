package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DetailSkillDao;
import com.entity.Detailskill;
import com.entity.Skill;
import com.model.DetailskillDTO;
import com.service.DetailSkillService;

@Transactional
@Service
public class DetailSkillServiceImpl implements DetailSkillService{

	@Autowired
	DetailSkillDao detailSkillDao;
	
	public void addDetailSkill(DetailskillDTO detailskillDTO, int skill_id) {
		Detailskill detailskill = new Detailskill();
		detailskill.setDetailSkill(detailskillDTO.getDetailSkill());
		detailskill.setSkill(new Skill(skill_id));
		
		detailSkillDao.addDetailSkill(detailskill);
	}

	public List<DetailskillDTO> getAllDetailSkillsBySkillId(int skill_ID) {
		List<Detailskill> detailskills = detailSkillDao.getAllDetailSkillsBySkillId(skill_ID);
		List<DetailskillDTO> list = new ArrayList<DetailskillDTO>();
		for (Detailskill detailskill : detailskills) {
			DetailskillDTO detailskillDTO = new DetailskillDTO();
			detailskillDTO.setDetailSkill(detailskill.getDetailSkill());
			list.add(detailskillDTO);
		}
		return list;
	}

}
