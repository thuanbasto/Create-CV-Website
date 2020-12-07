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

import com.model.SkillDTO;
import com.model.UserDTO;
import com.service.DetailSkillService;
import com.service.SkillService;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	DetailSkillService detailSkillService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/information")
	public String information(@ModelAttribute("userDTO") UserDTO userDTO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]") == true)
			return "redirect:/home";
		UserDTO user = userService.getUserByUserName(authentication.getName());
		userService.setUserDTO(userDTO, user);
		
		return "information";
	}
	
	@PostMapping("/editInformation")
	public String editUser(HttpServletRequest request, @ModelAttribute("userDTO") UserDTO userDTO) {
		MultipartFile file = userDTO.getFile();
		if (!file.isEmpty()) {
			try {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String fileName = authentication.getName() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
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
		return "redirect:/user/information";
	}
	
	@GetMapping("/editCV")
	public String editCV(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]") == true)
			return "redirect:/home";

		UserDTO user = userService.getUserByUserName(authentication.getName());
		List<SkillDTO> listSkill = skillService.getAllSkillsByUserId(user.getUser_ID());
		for (SkillDTO skillDTO : listSkill) {
			skillDTO.setDetailSkills(detailSkillService.getAllDetailSkillsBySkillId(skillDTO.getSkill_ID()));
		}
		user.setSkills(listSkill);
			
		request.setAttribute("user", user);
		
 		if (user.getTypecv().getTypecv_ID() == 2)
			return "editCV2";
		return "editCV";
	}
	
	@GetMapping("/editCV/{typecv}")
	public String editCVWithParam(HttpServletRequest request,@PathVariable(name="typecv",required=false) int typecv) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]") == true)
			return "redirect:/home";

		UserDTO user = userService.getUserByUserName(authentication.getName());
		List<SkillDTO> listSkill = skillService.getAllSkillsByUserId(user.getUser_ID());
		for (SkillDTO skillDTO : listSkill) {
			skillDTO.setDetailSkills(detailSkillService.getAllDetailSkillsBySkillId(skillDTO.getSkill_ID()));
		}
		user.setSkills(listSkill);
			
		request.setAttribute("user", user);
		
 		if (user.getTypecv().getTypecv_ID() == 2 && typecv != 1 && typecv != 2)
			return "editCV2";
		if (typecv == 1)
			return "editCV";
		else if (typecv == 2)
			return "editCV2";
		return "editCV";
	}
	
	@GetMapping("/changePassword")
	public String changePasswordPage() {
		return "changePassword";			
	}
	
	@PostMapping("/changePassword")
	public String changePassword(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDTO user = userService.getUserByUserName(authentication.getName());
		String password = (String) request.getParameter("password");
		String newPassword = (String) request.getParameter("newPassword");
		String confirmNewPassword = (String) request.getParameter("confirmNewPassword");
		
		if (passwordEncoder.matches(password, user.getPassword())) {
			if (newPassword.length() > 0 && confirmNewPassword.length() > 0) {
				if (newPassword.equals(confirmNewPassword)) {
					user.setPassword(passwordEncoder.encode(newPassword));
					userService.updatePassword(user);
					
					return "redirect:/user/changePassword?success";
				}
			}
		}
		
		return "redirect:/user/changePassword?failed.";
	}
}
