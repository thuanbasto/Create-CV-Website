package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Typecv;
import com.model.UserDTO;
import com.service.UserService;

@RestController
public class RestUserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/updateTypeCV/{typecv_ID}",method = RequestMethod.POST)
	public void add(@PathVariable(name="typecv_ID") int typecv_ID) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]") != true) {
			UserDTO user = userService.getUserByUserName(authentication.getName());
			user.setTypecv(new Typecv(typecv_ID));
			userService.updateUserWithTypecv(user);
		}
	}
}
