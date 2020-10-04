package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUserById(int id);
	public User getUserByUserName(String username);
	public List<User> getAllUsers();
	public Object[] getUsersWithLikes(String username);
	public List<Object[]> getAllUsersWithLikes();
	public boolean checkUsername(String username);
}
