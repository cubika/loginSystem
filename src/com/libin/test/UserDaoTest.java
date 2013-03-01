package com.libin.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.libin.dao.impl.UserDAO;
import com.libin.domain.User;

public class UserDaoTest {

	private UserDAO dao=new UserDAO();
	
	@Test
	public void testAddUser() {
		User tom=new User();
		tom.setUsername("tom");
		tom.setPassword("123");
		tom.setEmail("a@b.c");
		tom.setBirthday(new Date());
		dao.addUser(tom);
	}

	@Test
	public void testFindUser() {
		User realTom=dao.findUser("tom", "123");
		User fakeTom=dao.findUser("tom", "1234");
		User fakeJerry=dao.findUser("jerry", "1234");
		
		assertNotNull(realTom);
		assertNull(fakeTom);
		assertNull(fakeJerry);
	}

	@Test
	public void testHasUser() {
		assertTrue(dao.hasUser("tom"));
		assertFalse(dao.hasUser("jerry"));
	}

}
