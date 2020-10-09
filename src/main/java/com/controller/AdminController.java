package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.UserDTO;
import com.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/listUser")
	public String listUser(HttpServletRequest request) {
		List<UserDTO> listUser = userService.getAllUsers();
		request.setAttribute("listUser", listUser);
		return "listUser";
	}
	
	@GetMapping("/userInformation/{user_ID}")
	public String userDetail(HttpServletRequest request,@PathVariable(name="user_ID") int id) {
		UserDTO user = userService.getUserById(id);
		request.setAttribute("user", user);
		return "userInformation";
	}
	
	@GetMapping("/deleteUser/{user_ID}")
	public String deleteUser(@PathVariable(name="user_ID") int id) {
		userService.deleteUser(id);
		return "redirect:/admin/listUser";
	}
	
	@GetMapping("/ban/{user_ID}")
	public String banUser(@PathVariable(name="user_ID") int id) {
		userService.banUser(id);
		return "redirect:/admin/listUser";
	}
	
	@GetMapping("/unban/{user_ID}")
	public String unBanUser(@PathVariable(name="user_ID") int id) {
		userService.unBanUser(id);
		return "redirect:/admin/listUser";
	}
}
