package com.libin.dao;

import com.libin.domain.User;

public interface IUserDAO {

	void addUser(User user);
	User findUser(String username, String password);
	boolean hasUser(String username);
}
