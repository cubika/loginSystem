<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册页面</title>

	<link rel="stylesheet" type="text/css" href="/loginSystem/css/register.css">
	<script type="text/javascript" src="/loginSystem/datePicker/WdatePicker.js"></script>
  </head>
  
  <body>
  <form class="reform" action="/loginSystem/servlet/RegisterServlet" method="post">
	<p><label>用户名：</label><input type="text" name="username" value="${form.username }" />${form.errors.username }</p>
	<p><label>密码：</label><input type="password" name="password" value="${form.password }" />${form.errors.password }</p>
	<p><label>确认密码：</label><input type="password" name="password2" value="${form.password2 }" />${form.errors.password2}</p>
	<p><label>邮箱：</label><input type="text" name="email" value="${form.email }"  />${form.errors.email}</p>
	<p><label>生日：</label><input type="text" name="birthday" onclick="WdatePicker()" value="${form.birthday }" />${form.errors.birthday }</p>
	<input type="submit" value="注册" />
  </form>
  </body>
</html>
