package com.libin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.mysql.jdbc.StringUtils;




public class WebUtil {

	public static <T> T request2bean(HttpServletRequest request,Class<T> type){
		Enumeration names=request.getParameterNames();
		T bean;
		try {
			bean = type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		HashMap map=new HashMap();
		while(names.hasMoreElements()){
			String name=(String) names.nextElement();
			map.put(name, request.getParameter(name));
		}
		try {
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
			
	}
	
	public static void copyBean(Object dest,Object src){
		//注册自定义对象转换类
		ConvertUtils.register(new Converter(){

			@Override
			public Object convert(Class type, Object value) {
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				String dateStr=(String) value;
				if(!StringUtils.isNullOrEmpty(dateStr)){
					try {
						return df.parse(dateStr);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				return null;
			}
			
		}, Date.class);
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
	}
}
