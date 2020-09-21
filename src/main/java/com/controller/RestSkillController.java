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

import com.model.DetailskillDTO;
import com.model.ListSkillDTO;
import com.model.SkillDTO;
import com.model.UserDTO;
import com.service.DetailSkillService;
import com.service.SkillService;
import com.service.UserService;

@RestController
public class RestSkillController {
	@Autowired
	UserService userService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	DetailSkillService detailSkillService;
	
	@RequestMapping(value="/addSkill",method = RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public void addSkill(@RequestBody ListSkillDTO listSkill) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getAuthorities().toString().equals("[ROLE_ANONYMOUS]") != true) {
			UserDTO user = userService.getUserByUserName(authentication.getName());
			int id = user.getUser_ID();
			skillService.deleteAllSkillById(id);
			if (!listSkill.getListSkill().isEmpty()) {
				for (SkillDTO skillDTO : listSkill.getListSkill()) {
					skillService.addSkill(skillDTO, id);
					int skill_ID = skillService.getIdSkillByUserId(id);
					if (!skillDTO.getDetailSkills().isEmpty()) {
						for (DetailskillDTO detailskillDTO : skillDTO.getDetailSkills()) {
							detailSkillService.addDetailSkill(detailskillDTO, skill_ID);
						}
					}
				}
			}
		}
		
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody UserDTO userDTO) {
		System.out.println(userDTO.getName());
	}

}
