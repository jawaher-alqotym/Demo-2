package com.example.demo2.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.springframework.stereotype.Component;

@Component
public class UserServices {
	
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(2, "ali", "omar"));
		users.add(new User(3, "mohmmad", "omar"));
		users.add(new User(4, "nora", "omar"));

	}
	
	private static int usersCount = 3;

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
