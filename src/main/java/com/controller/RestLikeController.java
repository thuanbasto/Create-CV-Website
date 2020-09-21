package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.model.LikeDTO;
import com.model.UserDTO;
import com.service.LikeService;
import com.service.UserService;

@RestController
public class RestLikeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	LikeService likeService;
	
	@RequestMapping(value="/like",method = RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public void like(@RequestBody LikeDTO likeDTO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]") != true) {
			UserDTO user = userService.getUserByUserName(authentication.getName());
			int id = user.getUser_ID();
			likeDTO.setFrom_user_ID(id);
			likeService.addLike(likeDTO);
		}
	}

	@RequestMapping(value="/dislike",method = RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public void dislike(@RequestBody LikeDTO likeDTO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]") != true) {
			UserDTO user = userService.getUserByUserName(authentication.getName());
			int id = user.getUser_ID();
			likeDTO.setFrom_user_ID(id);
			likeService.deleteLike(likeDTO);
		}
	}

}
