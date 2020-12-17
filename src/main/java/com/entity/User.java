package com.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


@Entity(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_ID;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String career;

	private String email;

	private Byte enabled;

	private String facebook;

	private String imageUrl;

	private String maxim;

	private String name;

	private String password;

	private String phone;

	private String role;

	private String username;

	private Byte state;
	
	@OneToMany(mappedBy="user")
	private List<Skill> skills;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="typecv_ID")
	private Typecv typecv;

	public User() {
	}
	
	public User(int id) {
		this.user_ID = id;
	}

	public int getUser_ID() {
		return this.user_ID;
	}

	public Typecv getTypecv() {
		return typecv;
	}

	public void setTypecv(Typecv typecv) {
		this.typecv = typecv;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCareer() {
		return this.career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Byte getEnabled() {
		return enabled;
	}

	public void setEnabled(Byte enabled) {
		this.enabled = enabled;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getMaxim() {
		return this.maxim;
	}

	public void setMaxim(String maxim) {
		this.maxim = maxim;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Skill addSkill(Skill skill) {
		getSkills().add(skill);
		skill.setUser(this);

		return skill;
	}

	public Skill removeSkill(Skill skill) {
		getSkills().remove(skill);
		skill.setUser(null);

		return skill;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}
	
	

}