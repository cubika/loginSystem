<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<c:if test="${not empty user }">
    Hello,${user.username } <a href="/loginSystem/servlet/LogoutServlet">注销</a>
    </c:if>
    
    <c:if test="${empty user }">
    	<a href="/loginSystem/servlet/LoginUIServlet">登录</a><br/>
    	<a href="/loginSystem/servlet/RegisterUIServlet">注册</a>
    </c:if>
  </body>
</html>
