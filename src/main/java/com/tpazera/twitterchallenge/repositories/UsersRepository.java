package com.tpazera.twitterchallenge.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.tpazera.twitterchallenge.entities.User;

@Repository
public class UsersRepository {

	private Set<User> users;

	{
		users = Collections.synchronizedSet(new HashSet<>());
		users.add(new User("tpazera"));
		users.add(new User("jnowak"));
	}

	public Set<User> findAllUsers() {
		return users;
	}
	
	public Optional<User> findUserByUserName(String userName) {
		return users.stream().filter(u->u.getUserName().equalsIgnoreCase(userName)).findFirst();
	}

	public boolean updateUser(User user) {
		users.remove(user);
		users.add(user);
		return true;
	}

	public boolean addUser(User user) {
		try {
		users.add(user);
		return true;
		} catch (Exception e) {
			return false;
		}
	}

}
