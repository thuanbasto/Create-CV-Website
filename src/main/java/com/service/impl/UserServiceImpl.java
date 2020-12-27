package com.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
		user.setState((byte)0); // waiting for job
		user.setTypecv(typecv);
		userDao.addUser(user);
	}

	@SuppressWarnings("deprecation")
	public void updateUser(UserDTO userDTO) {
		User user = userDao.getUserById(userDTO.getUser_ID());

		user.setAddress(userDTO.getAddress());
		user.setBirthday(userDTO.getBirthday());
		user.setEmail(userDTO.getEmail());
		user.setFacebook(userDTO.getFacebook());
		user.setName(userDTO.getName());
		user.setPhone(userDTO.getPhone());
		{
			String career = userDTO.getCareer().toLowerCase(); 
			career = StringUtils.capitalise(career);
			user.setCareer(career);
		}
		user.setMaxim(userDTO.getMaxim());
		user.setImageUrl(userDTO.getImageUrl());
		
		userDao.updateUser(user);
	}
	
	public void updateUserWithState(UserDTO userDTO) {
		User user = userDao.getUserById(userDTO.getUser_ID());

		user.setState(userDTO.getState());
		
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
		userDTO.setState(user.getState());
		
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
			userDTO.setState(user.getState());
			
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
		userDTO.setState(user.getState());
		
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
		userDTO.setState(user.getState());
	}

	public void updatePassword(UserDTO userDTO) {
		User user = userDao.getUserById(userDTO.getUser_ID());
		
		user.setPassword(userDTO.getPassword());
		
		userDao.updateUser(user);
	}

	public UserDTO getUsersWithLikes(String username) {
		Object[] user = userDao.getUsersWithLikes(username);
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUser_ID(Integer.parseInt(String.valueOf(user[0])));
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
		userDTO.setState(Byte.parseByte(String.valueOf(user[12])));
		if (user.length == 14)
			userDTO.setLikes(Long.parseLong(String.valueOf(user[13])));
		else 
			userDTO.setLikes(0);
		return userDTO;
	}
	
	public List<UserDTO> getAllUsersWithLikes() {
		List<Object[]> listUser = userDao.getAllUsersWithLikes();
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		for (Object[] user : listUser) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUser_ID(Integer.parseInt(String.valueOf(user[0])));  // ID
			userDTO.setName(String.valueOf(user[1]));  // name
			userDTO.setUsername(String.valueOf(user[2])); // username
			userDTO.setEmail(String.valueOf(user[3])); // email
			userDTO.setLikes(Long.parseLong(String.valueOf(user[4]))); // like
			
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

//	@Override
//	public void banUser(int id) {
//		User user = userDao.getUserById(id);
//		
//		user.setEnabled((byte) 0); // Banned
//		
//		userDao.updateUser(user);
//	}
//	
//	@Override
//	public void unBanUser(int id) {
//		User user = userDao.getUserById(id);
//		
//		user.setEnabled((byte) 1); // unban
//		
//		userDao.updateUser(user);
//	}

	public void updateUserWithTypecv(UserDTO userDTO) {
		User user = userDao.getUserById(userDTO.getUser_ID());
		user.setTypecv(userDTO.getTypecv());
		userDao.updateUser(user);
	}

	public List<String> getAllCareer() {
		List<String> careers = userDao.getAllCareer();
		for (int i = 0; i < careers.size(); i++) {
			String temp = careers.get(i);
			if (temp == null || "".equals(temp) || temp.isEmpty()) {
				careers.remove(i);
			}
		}
		return careers;
	}

	public List<UserDTO> searchCV(String career, int age, String city) {
		String sql = "from com.entity.User u";
		boolean checkCareer = false, checkAge = false;
		
		if (!"all".equals(career) || age != 0 || !"all".equals(city))
			sql += " WHERE";
		if (!"all".equals(career)) {
			sql += " u.career = '" + career + "'";
			checkCareer = true;
		}
		if (age != 0) {
			if (checkCareer) sql += " AND";
			LocalDateTime now = LocalDateTime.now();
			sql += " " + now.getYear() + " - Year(u.birthday) between 0 AND " + age;
			checkAge = true;
		}
		if (!"all".equals(city)) {
			if (checkAge || checkCareer) sql += " AND";
			sql += " u.address = '" + city + "'";
		}
		
		System.out.println(sql);
		
		List<User> listUser = userDao.SearchCV(sql);
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		
		for (User user : listUser) {
			UserDTO userDTO = new UserDTO();
			userDTO.setAddress(user.getAddress());
			userDTO.setBirthday(user.getBirthday());
			userDTO.setName(user.getName());
			userDTO.setCareer(user.getCareer());
			userDTO.setUsername(user.getUsername());
			userDTO.setState(user.getState());
			
			listUserDTO.add(userDTO);
		}
		
		return listUserDTO;
	}

	public void banUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void unBanUser(int id) {
		// TODO Auto-generated method stub
		
	}


}
