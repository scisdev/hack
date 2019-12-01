package com.hawken.db.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hawken.db.User;
import com.hawken.db.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(Integer id, String firstName, String lastName) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			User user = u.get();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			userRepository.save(user);
		}
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> res = new ArrayList<>();
		for (User u : userRepository.findAll()) {
			res.add(u);
		}
		return res;
	}
	
	@Override
	public User getUserById(Integer id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) return u.get();
		else return null;
	}
}
