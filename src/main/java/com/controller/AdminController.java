package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.model.UserDTO;
import com.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/listUser")
	public String listUser(HttpServletRequest request) {
		List<UserDTO> listUser = userService.getAllUsers();
		request.setAttribute("listUser", listUser);
		return "listUser";
	}
	
	@GetMapping("/userInformation/{user_ID}")
	public String userDetail(HttpServletRequest request,@PathVariable(name="user_ID") int id) {
		UserDTO userDTO = userService.getUserById(id);
		request.setAttribute("userDTO", userDTO);
		return "userInformation";
	}
	
	@GetMapping("/changePassword_Admin/{user_ID}")
	public String changePasswordPage(HttpServletRequest request,@PathVariable(name="user_ID") int id) {
		request.setAttribute("user_ID", id);
		return "changePassword_Admin";			
	}
	
	@PostMapping("/changePassword_Admin/{user_ID}")
	public String changePassword(HttpServletRequest request,@PathVariable(name="user_ID") int id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ADMIN]") == true) {
			UserDTO user = userService.getUserById(id);
			
			String newPassword = (String) request.getParameter("newPassword");
			String confirmNewPassword = (String) request.getParameter("confirmNewPassword");
			
			if (newPassword.length() > 0 && confirmNewPassword.length() > 0) {
				if (newPassword.equals(confirmNewPassword)) {
					user.setPassword(passwordEncoder.encode(newPassword));
					userService.updatePassword(user);
					
					return "redirect:/admin/changePassword_Admin/"+id+"?success";
				}
			}
		}
		return "redirect:/admin/changePassword_Admin/+"+id+"?failed.";
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
	
	@PostMapping("/editInformation")
	public String editUser(HttpServletRequest request, @ModelAttribute("userDTO") UserDTO userDTO) {
		MultipartFile file = userDTO.getFile();
		if (!file.isEmpty()) {
			try {
				String fileName = userDTO.getUsername() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				File newFile = new File(request.getServletContext().getRealPath("") +"\\storage\\image\\" + fileName);
				FileOutputStream fileOutputStream = new FileOutputStream(newFile);
				fileOutputStream.write(file.getBytes());
				fileOutputStream.close();
				
				userDTO.setImageUrl(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		userService.updateUser(userDTO);
		return "redirect:/admin/userInformation/" + userDTO.getUser_ID();
	}
}
