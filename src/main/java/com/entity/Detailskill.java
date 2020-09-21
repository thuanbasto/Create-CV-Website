package com.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity(name="detailskill")
public class Detailskill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int detailSkill_ID;

	private String detailSkill;

	//bi-directional many-to-one association to Skill
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Skill_ID")
	private Skill skill;

	public Detailskill() {
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

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}