package com.model;

import java.util.List;

public class SkillDTO {

	private int skill_ID;

	private int indexDisplay;

	private String skillName;

	private String typeDisplay;

	private List<DetailskillDTO> detailSkills;

	private UserDTO userDTO;

	
	public SkillDTO() {
	}

	public int getSkill_ID() {
		return this.skill_ID;
	}

	public void setSkill_ID(int skill_ID) {
		this.skill_ID = skill_ID;
	}

	public int getIndexDisplay() {
		return this.indexDisplay;
	}

	public void setIndexDisplay(int indexDisplay) {
		this.indexDisplay = indexDisplay;
	}

	public String getSkillName() {
		return this.skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getTypeDisplay() {
		return this.typeDisplay;
	}

	public void setTypeDisplay(String typeDisplay) {
		this.typeDisplay = typeDisplay;
	}

	
	public List<DetailskillDTO> getDetailSkills() {
		return detailSkills;
	}

	public void setDetailSkills(List<DetailskillDTO> detailSkills) {
		this.detailSkills = detailSkills;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
}