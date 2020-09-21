package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SkillDao;
import com.entity.Skill;
import com.entity.User;
import com.model.SkillDTO;
import com.model.UserDTO;
import com.service.SkillService;

@Transactional
@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	SkillDao skillDao;
	
	public void addSkill(SkillDTO skillDTO,int id) {
		Skill skill = new Skill();
		skill.setSkillName(skillDTO.getSkillName());
		skill.setIndexDisplay(skillDTO.getIndexDisplay());
		skill.setTypeDisplay(skillDTO.getTypeDisplay());
		skill.setUser(new User(id));
		
		skillDao.addSkill(skill);
	}

	public void updateSkill(SkillDTO skillDTO) {
		
	}

	public void deleteSkill(int id) {
		
	}

	public SkillDTO getSkillById(int id) {
		return null;
	}

	public List<SkillDTO> getAllSkillsByUserId(int id) {
		List<Skill> listSkill = skillDao.getAllSkillsByUserId(id);
		List<SkillDTO> listSkillDTO = new ArrayList<SkillDTO>();
		for (Skill skill : listSkill) {
			SkillDTO skillDTO = new SkillDTO();
			skillDTO.setSkill_ID(skill.getSkill_ID());
			skillDTO.setSkillName(skill.getSkillName());
			skillDTO.setIndexDisplay(skill.getIndexDisplay());
			skillDTO.setTypeDisplay(skill.getTypeDisplay());
			skillDTO.setUserDTO(new UserDTO(id));
			
			listSkillDTO.add(skillDTO);
		}
		return listSkillDTO;
	}

	public void deleteAllSkillById(int id) {
		skillDao.deleteAllSkillById(id);
	}

	public int getIdSkillByUserId(int id) {
		return skillDao.getIdSkillByUserId(id);
	}

}
