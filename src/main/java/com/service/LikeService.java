package com.service;

import com.model.LikeDTO;

public interface LikeService {
	public void addLike(LikeDTO likeDTO);
	public void deleteLike(LikeDTO likeDTO);
	public boolean checkLike(LikeDTO likeDTO);
	public long countLike(int user_ID);
}
