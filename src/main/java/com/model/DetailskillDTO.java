package com.model;

public class DetailskillDTO {

	private int detailSkill_ID;

	private String detailSkill;

	private SkillDTO skillDTO;

	public DetailskillDTO() {
	}

	public int getDetailSkill_ID() {
		return this.detailSkill_ID;
	}

	public void setDetailSkill_ID(int detailSkill_ID) {
		this.detailSkill_ID = detailSkill_ID;
	}

	public String getDetailSkill() {
		return this.detailSkill;
	}

	public void setDetailSkill(String detailSkill) {
		this.detailSkill = detailSkill;
	}

	public SkillDTO getSkillDTO() {
		return skillDTO;
	}

	public void setSkillDTO(SkillDTO skillDTO) {
		this.skillDTO = skillDTO;
	}

}