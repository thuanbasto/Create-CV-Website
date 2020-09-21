package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LikeDao;
import com.entity.Like;
import com.entity.User;
import com.model.LikeDTO;
import com.service.LikeService;

@Service
@Transactional
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeDao likeDao;
	
	public void addLike(LikeDTO likeDTO) {
		Like like = new Like();
		User user1 = new User(likeDTO.getFrom_user_ID());
		User user2 = new User(likeDTO.getTo_user_ID());
		like.setUser1(user1);
		like.setUser2(user2);
		
		likeDao.addLike(like);
	}

	public void deleteLike(LikeDTO likeDTO) {
		Like like = new Like();
		User user1 = new User(likeDTO.getFrom_user_ID());
		User user2 = new User(likeDTO.getTo_user_ID());
		like.setUser1(user1);
		like.setUser2(user2);
		
		likeDao.deleteLike(like);
	}

	public boolean checkLike(LikeDTO likeDTO) {
		Like like = new Like();
		User user1 = new User(likeDTO.getFrom_user_ID());
		User user2 = new User(likeDTO.getTo_user_ID());
		like.setUser1(user1);
		like.setUser2(user2);
		
		return likeDao.checkLike(like);
	}

	public long countLike(int user_ID) {
		Like like = new Like();
		User user1 = new User();
		User user2 = new User(user_ID);
		like.setUser1(user1);
		like.setUser2(user2);
		
		return likeDao.countLike(like);
	}
}
