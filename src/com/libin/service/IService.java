package com.libin.service;

import com.libin.domain.User;
import com.libin.util.UserExistException;

public interface IService {

	void register(User user) throws UserExistException;
	User login(String username, String password);
}
