package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entity.Typecv;
import com.entity.User;
import com.model.UserDTO;
import com.service.LikeService;
import com.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	LikeService likeService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void addUser(UserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUsername().toLowerCase());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setRole("ROLE_USER");
		user.setEnabled((byte)1);
		Typecv typecv = new Typecv();
		typecv.setTypecv_ID(1);
		user.setTypecv(typecv);
		userDao.addUser(user);
	}

	public void updateUser(UserDTO userDTO) {
		User user = userDao.getUserById(userDTO.getUser_ID());

		user.setAddress(userDTO.getAddress());
		user.setBirthday(userDTO.getBirthday());
		user.setEmail(userDTO.getEmail());
		user.setFacebook(userDTO.getFacebook());
		user.setName(userDTO.getName());
		user.setPhone(userDTO.getPhone());
		user.setCareer(userDTO.getCareer());
		user.setMaxim(userDTO.getMaxim());
		user.setImageUrl(userDTO.getImageUrl());
		
		userDao.updateUser(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public UserDTO getUserById(int id) {
		User user = userDao.getUserById(id);
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUser_ID(user.getUser_ID());
		userDTO.setAddress(user.getAddress());
		userDTO.setBirthday(user.getBirthday());
		userDTO.setEmail(user.getEmail());
		userDTO.setFacebook(user.getFacebook());
		userDTO.setImageUrl(user.getImageUrl());
		userDTO.setName(user.getName());
		userDTO.setPhone(user.getPhone());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setMaxim(user.getMaxim());
		userDTO.setCareer(user.getCareer());
		userDTO.setTypecv(user.getTypecv());
		
		return userDTO;
	}

	public List<UserDTO> getAllUsers() {
		List<User> listUser = userDao.getAllUsers();
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		for (User user : listUser) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUser_ID(user.getUser_ID());
			userDTO.setAddress(user.getAddress());
			userDTO.setBirthday(user.getBirthday());
			userDTO.setEmail(user.getEmail());
			userDTO.setFacebook(user.getFacebook());
			userDTO.setImageUrl(user.getImageUrl());
			userDTO.setName(user.getName());
			userDTO.setPhone(user.getPhone());
			userDTO.setUsername(user.getUsername());
			
			listUserDTO.add(userDTO);
		}
		
		return listUserDTO;
	}

	public boolean checkUsername(String username) {
		return userDao.checkUsername(username);
	}

	public UserDTO getUserByUserName(String username) {
		User user = userDao.getUserByUserName(username);
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUser_ID(user.getUser_ID());
		userDTO.setAddress(user.getAddress());
		userDTO.setBirthday(user.getBirthday());
		userDTO.setEmail(user.getEmail());
		userDTO.setFacebook(user.getFacebook());
		userDTO.setImageUrl(user.getImageUrl());
		userDTO.setName(user.getName());
		userDTO.setPhone(user.getPhone());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setMaxim(user.getMaxim());
		userDTO.setCareer(user.getCareer());
		userDTO.setTypecv(user.getTypecv());
		
		return userDTO;
	}
	
	public void setUserDTO(UserDTO userDTO,UserDTO user) {
		userDTO.setUser_ID(user.getUser_ID());
		userDTO.setAddress(user.getAddress());
		userDTO.setBirthday(user.getBirthday());
		userDTO.setEmail(user.getEmail());
		userDTO.setFacebook(user.getFacebook());
		userDTO.setImageUrl(user.getImageUrl());
		userDTO.setName(user.getName());
		userDTO.setPhone(user.getPhone());
		userDTO.setUsername(user.getUsername());
		userDTO.setMaxim(user.getMaxim());
		userDTO.setCareer(user.getCareer());
	}

	public void updatePassword(UserDTO userDTO) {
		User user = userDao.getUserById(userDTO.getUser_ID());
		
		user.setPassword(userDTO.getPassword());
		
		userDao.updateUser(user);
	}

	@Override
	public UserDTO getUsersWithLikes(String username) {
		Object[] user = userDao.getUsersWithLikes(username);
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUser_ID((int) user[0]);
		userDTO.setName(String.valueOf(user[1]));
		userDTO.setAddress(String.valueOf(user[2]));
		userDTO.setBirthday((Date) user[3]);
		userDTO.setPhone(String.valueOf(user[4]));
		userDTO.setEmail(String.valueOf(user[5]));
		userDTO.setCareer(String.valueOf(user[6]));
		userDTO.setMaxim(String.valueOf(user[7]));
		userDTO.setFacebook(String.valueOf(user[8]));
		userDTO.setImageUrl(String.valueOf(user[9]));
		userDTO.setUsername(String.valueOf(user[10]));
		userDTO.setTypecv((Typecv) user[11]);
		if (user.length == 13)
			userDTO.setLikes((Long) user[12]);
		else 
			userDTO.setLikes(0);
		return userDTO;
	}
	
	public List<UserDTO> getAllUsersWithLikes() {
		List<Object[]> listUser = userDao.getAllUsersWithLikes();
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		for (Object[] user : listUser) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUser_ID((int) user[0]);  // ID
			userDTO.setName(String.valueOf(user[1]));  // name
			userDTO.setUsername(String.valueOf(user[2])); // username
			userDTO.setEmail(String.valueOf(user[3])); // email
			userDTO.setLikes((long) user[4]);; // like
			
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

	@Override
	public void banUser(int id) {
		User user = userDao.getUserById(id);
		
		user.setEnabled((byte) 0); // Banned
		
		userDao.updateUser(user);
	}
	
	@Override
	public void unBanUser(int id) {
		User user = userDao.getUserById(id);
		
		user.setEnabled((byte) 1); // unban
		
		userDao.updateUser(user);
	}

	@Override
	public void updateUserWithTypecv(UserDTO userDTO) {
		User user = userDao.getUserById(userDTO.getUser_ID());
		user.setTypecv(userDTO.getTypecv());
		userDao.updateUser(user);
	}

}
