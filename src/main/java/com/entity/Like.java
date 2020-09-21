package com.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the like database table.
 * 
 */
@Entity(name="likecv")
public class Like implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int like_ID;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="from_user_ID")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="to_user_ID")
	private User user2;

	public Like() {
	}

	public int getLike_ID() {
		return this.like_ID;
	}

	public void setLike_ID(int like_ID) {
		this.like_ID = like_ID;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}