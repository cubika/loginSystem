package com.libin.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.libin.domain.User;
import com.libin.service.impl.BusinessService;
import com.libin.util.UserExistException;

public class ServiceTest {

	private BusinessService service=new BusinessService();

	@Test
	public void testRegister() {
		try {
			User jerry=new User();
			jerry.setUsername("jerry");
			jerry.setPassword("123");
			jerry.setEmail("a@b.cd");
			service.register(jerry);
		} catch (UserExistException e) {
			System.out.println("user is exist.");
		}
	}

	@Test
	public void testLogin() {
		assertNull(service.login("tom", "1234"));
		assertNull(service.login("ben", "1234"));
		assertNotNull(service.login("tom", "123"));
	}

}
