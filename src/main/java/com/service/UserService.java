package com.service;

import java.util.List;

import com.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO userDTO);
	public void updateUser(UserDTO userDTO);
	public void updateUserWithTypecv(UserDTO userDTO);
	public void updatePassword(UserDTO userDTO);
	public void deleteUser(int id);
	public void banUser(int id);
	public void unBanUser(int id);
	public UserDTO getUserById(int id);
	public UserDTO getUserByUserName(String username);
	public List<UserDTO> getAllUsers();
	public UserDTO getUsersWithLikes(String username);
	public List<UserDTO> getAllUsersWithLikes();
	public boolean checkUsername(String username);
	public void setUserDTO(UserDTO userDTO,UserDTO user);
	public List<String> getAllCareer();
	public List<UserDTO> searchCV(String career,int age, String city);
	public void updateUserWithState(UserDTO userDTO);
}
