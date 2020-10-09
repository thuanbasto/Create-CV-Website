package com.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity(name="typecv")
public class Typecv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typecv_ID;

	private String descr;

	private String typename;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="typecv")
	private List<User> users;

	public Typecv() {
	}
	
	public Typecv(int typecv_ID) {
		this.typecv_ID = typecv_ID;
	}

	public int getTypecv_ID() {
		return this.typecv_ID;
	}

	public void setTypecv_ID(int typecv_ID) {
		this.typecv_ID = typecv_ID;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setTypecv(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setTypecv(null);

		return user;
	}

}