package com.model;

public class LikeDTO{

//	private int like_ID;

	private int from_user_ID;

	private int to_user_ID;

	public LikeDTO() {
	}

//	public int getLike_ID() {
//		return this.like_ID;
//	}
//
//	public void setLike_ID(int like_ID) {
//		this.like_ID = like_ID;
//	}

	public int getFrom_user_ID() {
		return from_user_ID;
	}

	public void setFrom_user_ID(int from_user_ID) {
		this.from_user_ID = from_user_ID;
	}

	public int getTo_user_ID() {
		return to_user_ID;
	}

	public void setTo_user_ID(int to_user_ID) {
		this.to_user_ID = to_user_ID;
	}



}