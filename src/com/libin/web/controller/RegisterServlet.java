package com.libin.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libin.domain.User;
import com.libin.service.impl.BusinessService;
import com.libin.util.UserExistException;
import com.libin.util.WebUtil;
import com.libin.web.formbean.UserBean;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		UserBean userForm=WebUtil.request2bean(request,UserBean.class);
		BusinessService service=new BusinessService();
		
		if(!userForm.validate()){
			request.setAttribute("form", userForm);
			request.getRequestDispatcher("/servlet/RegisterUIServlet").forward(request, response);
			return ;
		}
		
		User user=new User();
		WebUtil.copyBean(user, userForm);
		try {
			service.register(user);
			request.getSession().setAttribute("message", "恭喜你，注册成功！");
			response.sendRedirect("/loginSystem/message.jsp");
			return;
		} catch (UserExistException e) {
			userForm.getErrors().put("username", "该用户已存在！");
			request.setAttribute("form", userForm);
			request.getRequestDispatcher("/servlet/RegisterUIServlet").forward(request, response);
			return;
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "服务器未知错误！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
