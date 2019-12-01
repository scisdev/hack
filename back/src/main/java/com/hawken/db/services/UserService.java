package com.hawken.db.services;

import java.util.ArrayList;

import com.hawken.db.User;

public interface UserService {
	public abstract void saveUser(User user);
	public abstract void updateUser(Integer id, String firstName, String lastName);
	public abstract void deleteUser(Integer id);
	public abstract ArrayList<User> getAllUsers();
	public abstract User getUserById(Integer id);
}