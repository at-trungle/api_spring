package com.example.demo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;



@Service
public class UserService {

	public static List<User> listUser = new ArrayList<User>();

	static {
		User userKai = new User(1, "kai", "123456");
		userKai.setRoles(new String[] { "ROLE_ADMIN" });

		User userSena = new User(2, "sena", "123456");
		userSena.setRoles(new String[] { "ROLE_USER" });

		listUser.add(userKai);
		listUser.add(userSena);
	}

	public List<User> findAll() {
		return listUser;
	}

	public User findById(int id) {
		for (User user : listUser) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public boolean add(User user) {
		for (User userExist : listUser) {
			if (user.getId() == userExist.getId() ||user.getUsername().equals(userExist.getUsername())) {
				return false;
			}
		}
		listUser.add(user);
		return true;
	}

	public void delete(int id) {
		listUser.removeIf(user -> user.getId() == id);
	}

	public User loadUserByUsername(String username) {
		for (User user : listUser) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public boolean checkLogin(User user) {
		for (User userExist : listUser) {
			if (user.getUsername().equals( userExist.getUsername())
					&& user.getPassword().equals( userExist.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
