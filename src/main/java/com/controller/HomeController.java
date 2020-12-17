package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.model.LikeDTO;
import com.model.SkillDTO;
import com.model.UserDTO;
import com.service.DetailSkillService;
import com.service.LikeService;
import com.service.SkillService;
import com.service.UserService;
import com.validator.UserValidator;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator userValidator;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	DetailSkillService detailSkillService;
	
	@Autowired
	LikeService likeService;
	
	@GetMapping(value= {"/home","/"})
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/{username}")
	public String cvUser(@PathVariable(name="username", required=false) String username, HttpServletRequest request) {
		if (username != null) {
			try {
				UserDTO user = userService.getUsersWithLikes(username);
				List<SkillDTO> listSkill = skillService.getAllSkillsByUserId(user.getUser_ID());
				for (SkillDTO skillDTO : listSkill) {
					skillDTO.setDetailSkills(detailSkillService.getAllDetailSkillsBySkillId(skillDTO.getSkill_ID()));
				}
				user.setSkills(listSkill);
				boolean checkLike = checkLike(user.getUser_ID());
				request.setAttribute("checkLike", checkLike);
				request.setAttribute("user", user);
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:/home";
			}
			
			return "cvUser";
		}
		return "home";
	}
	
	@GetMapping("/signUp")
	public String signUpPage(@ModelAttribute("userDTO") UserDTO userDTO) {
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute("userDTO") UserDTO userDTO,
			BindingResult bindingResult) {
		
		userValidator.validate(userDTO, bindingResult);
		if (bindingResult.hasErrors()) {
			return "signUp";
		}
		userService.addUser(userDTO);
		return "redirect:/home?signup=success";
	}
	
	@GetMapping("/signIn")
	public String signInPage(HttpServletRequest request,
			@RequestParam(name="error" ,required=false) String error) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean anonymous = authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]");

		if (anonymous && error == null)
			return "signIn";
		if (anonymous && error != null)
			if (error.equals("failed")) 
				request.setAttribute("msg", "Username or password is incorret.");
			else 
				return "deny";
		if (!anonymous && error != null)
			if (error.equals("failed")) 
				return "redirect:/home";
			else 
				return "deny";
		if (!anonymous && error == null)
			return "redirect:/home";
		
		return "signIn";
	}
	
	@GetMapping("/topcv")
	public String topcv(@RequestParam(required=false) Integer page,HttpServletRequest request) {
		List<UserDTO> users = userService.getAllUsersWithLikes(); 
		PagedListHolder<UserDTO> listUser = new PagedListHolder<UserDTO>(users);
		listUser.setPageSize(5);
		
		if(page == null || page < 1 || page > listUser.getPageCount())
			page=1;
		
		if(page == null || page < 1 || page > listUser.getPageCount()) {
			listUser.setPage(0);
			request.setAttribute("users", listUser.getPageList());
		} else if(page <= listUser.getPageCount()) {
        	listUser.setPage(page-1);
        	request.setAttribute("users", listUser.getPageList());
        }
		request.setAttribute("stt", (page-1)*5);
		request.setAttribute("page", page);
		request.setAttribute("maxPages", listUser.getPageCount());
		return "topcv";
	}
	
	
	@GetMapping("/listcv")
	public String listcv(HttpServletRequest request) {
		List<String> careers = userService.getAllCareer();
		request.setAttribute("careers", careers);
		return "listcv";
	}
	
	@GetMapping("/listcv/{career}/{age}/{city}")
	public String listcv(HttpServletRequest request,@PathVariable(name="career") String career,
			@PathVariable(name="age") int age,@PathVariable(name="city") String city) throws UnsupportedEncodingException {

		career = new String(career.getBytes("iso-8859-1"),"UTF-8");
		city = new String(city.getBytes("iso-8859-1"),"UTF-8");

		List<UserDTO> listUser = userService.searchCV(career, age, city);
		List<String> careers = userService.getAllCareer();
		
		request.setAttribute("careers", careers);
		request.setAttribute("listUser", listUser);
		return "listcv";
	}
	
//	@GetMapping("/listcv")
//	public String search(HttpServletRequest request,@RequestParam(name="career") String career,
//			@RequestParam(name="age") int age,@RequestParam(name="city") String city) {
//		List<UserDTO> listUser = userService.searchCV(career, age, city);
//		List<String> careers = userService.getAllCareer();
//		request.setAttribute("careers", careers);
//		request.setAttribute("listUser", listUser);
//		return "listcv";
//	}

	
	public boolean checkLike(int to_user_ID) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]") != true) {
			UserDTO user = userService.getUserByUserName(authentication.getName());
			int from_user_ID = user.getUser_ID();
			LikeDTO likeDTO = new LikeDTO();
			likeDTO.setFrom_user_ID(from_user_ID);
			likeDTO.setTo_user_ID(to_user_ID);
			
			if (likeService.checkLike(likeDTO))
				return true; // da like
		}
		return false; // chua like
	}
}
