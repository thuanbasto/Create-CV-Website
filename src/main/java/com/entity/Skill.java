package com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity(name="skill")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int skill_ID;

	private int indexDisplay;

	private String skillName;

	private String typeDisplay;

	//bi-directional many-to-one association to Detailskill
	@OneToMany(mappedBy="skill")
	private List<Detailskill> detailskills;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_ID")
	private User user;

	public Skill() {
	}

	public Skill(int id) {
		this.skill_ID = id;
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

	public List<Detailskill> getDetailskills() {
		return this.detailskills;
	}

	public void setDetailskills(List<Detailskill> detailskills) {
		this.detailskills = detailskills;
	}

	public Detailskill addDetailskill(Detailskill detailskill) {
		getDetailskills().add(detailskill);
		detailskill.setSkill(this);

		return detailskill;
	}

	public Detailskill removeDetailskill(Detailskill detailskill) {
		getDetailskills().remove(detailskill);
		detailskill.setSkill(null);

		return detailskill;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}