package com.dao;

import com.entity.Like;

public interface LikeDao {
	public void addLike(Like like);
	public void deleteLike(Like like);
	public boolean checkLike(Like like);
	public long countLike(Like like);
}
