package com.libin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.libin.dao.IUserDAO;
import com.libin.domain.User;
import com.libin.util.HibernateUtil;

public class UserDAO implements IUserDAO {

	private SessionFactory sf=HibernateUtil.getSessionFactory();
	
	@Override
	public void addUser(User user) {
		Session session=null;
		Transaction ts=null;
		try {
			session = sf.openSession();
			ts = session.beginTransaction();
			ts.begin();
			session.save(user);
			ts.commit();
		} catch (Exception e) {
			if(ts!=null){
				ts.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException("failed to add user.");
		}finally{
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
	}

	@Override
	public User findUser(String username,String password) {
		Session session=null;
		Transaction ts=null;
		try {
			session = sf.openSession();
			ts = session.beginTransaction();
			ts.begin();
			Query query=session.createQuery("from User where username=? and password=?");
			query.setParameter(0, username);
			query.setParameter(1, password);
			List<User> result=query.list();
			ts.commit();
			return result.size()>0 ? result.get(0) : null;
		} catch (Exception e) {
			if(ts!=null){
				ts.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException("failed to add user.");
		}finally{
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
	}

	@Override
	public boolean hasUser(String username) {
		Session session=null;
		Transaction ts=null;
		try {
			session = sf.openSession();
			ts = session.beginTransaction();
			ts.begin();
			Query query=session.createQuery("from User where username=?");
			query.setParameter(0, username);
			List result=query.list();
			ts.commit();
			return !result.isEmpty();
		} catch (Exception e) {
			if(ts!=null){
				ts.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException("failed to add user.");
		}finally{
			if(session!=null && session.isOpen()){
				session.close();
			}
		}
	}



}
