package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Typecv;
import com.entity.User;
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
	
	@PostMapping(value="/search/{career}/{age}/{city}")
	public List<UserDTO> search(@PathVariable(name="career") String career,
			@PathVariable(name="age") int age,
			@PathVariable(name="city") String city) {
		List<UserDTO> listCV = userService.searchCV(career, age, city);
		return listCV;
	}
	
	@RequestMapping(value="/changeState",method = RequestMethod.POST)
	public void changeState() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]") != true) {
			UserDTO userDTO = userService.getUserByUserName(authentication.getName());
			
			if (userDTO.getState() == 0)
				userDTO.setState((byte)1);
			else 
				userDTO.setState((byte)0);
			userService.updateUserWithState(userDTO);
		}
	}
	
}
