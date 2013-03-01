package com.libin.web.formbean;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class UserBean {
	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	
	private static final String unReg="^[a-z0-9_-]{3,15}$";
	private static final String passReg="^\\d{6,20}$";
	private static final String emailReg="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String dateReg="^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$";
	
	private Map<String,String> errors=new HashMap();
	
	public String getUsername() {
		return username;
	}
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public boolean validate(){
		boolean isOK=true;
		
		if(username==null || username.trim().equals("")){
			isOK=false;
			errors.put("username", "用户名不能为空！");
		}else if(!username.matches(unReg)){
			isOK=false;
			errors.put("username", "密码必须是3到15位字母数字_-！");
		}
		
		if(password==null || password.trim().equals("")){
			isOK=false;
			errors.put("password", "密码不能为空！");
		}else if(!password.matches(passReg)){
			isOK=false;
			errors.put("password", "密码必须是6到20位数字！");
		}
		
		if(password==null || password.equals("")){
			isOK=false;
			errors.put("password", "密码不能为空！");
		}else if(!password.matches(passReg)){
			isOK=false;
			errors.put("password", "密码必须是6到20位不含空格！");
		}
		
		if(password2==null || password2.equals("")){
			isOK=false;
			errors.put("password2", "确认密码不能为空！");
		}else if(!password.equals(password2)){
			isOK=false;
			errors.put("password2", "两次密码不一致！");
		}
		
		if(email==null || email.equals("")){
			isOK=false;
			errors.put("email", "邮箱不能为空！");
		}else if(!email.matches(emailReg)){
			isOK=false;
			errors.put("email", "邮箱格式不正确！");
		}
		
		if(birthday!=null && !birthday.trim().equals("")){
			try{
				DateLocaleConverter dlc=new DateLocaleConverter();
				dlc.convert(birthday,"yyyy-MM-dd");
			}catch(Exception e){
				isOK=false;
				errors.put("birthday", "日期格式不对！");
			}
		}
		
		return isOK;
		
	}

}
