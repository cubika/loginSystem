package com.libin.service.impl;

import com.libin.dao.impl.UserDAO;
import com.libin.domain.User;
import com.libin.service.IService;
import com.libin.util.ServiceUtil;
import com.libin.util.UserExistException;

public class BusinessService implements IService {

	private UserDAO dao=new UserDAO();
	
	@Override
	public void register(User user) throws UserExistException {
		if( dao.hasUser(user.getUsername())){
			throw new UserExistException();
		}
		user.setPassword(ServiceUtil.md5(user.getPassword()));
		dao.addUser(user);
	}

	@Override
	public User login(String username, String password) {
		password=ServiceUtil.md5(password);
		return dao.findUser(username, password);
	}

}
