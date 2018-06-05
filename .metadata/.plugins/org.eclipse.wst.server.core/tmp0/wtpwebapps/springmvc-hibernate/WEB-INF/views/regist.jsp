<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）:      
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href=" <%=basePath%>">
<title>注册</title>
</head>
<body>
	<h1>欢迎注册</h1>
	<br />
	<div align="center">
		<form action="user/doRegist" method="post">
			<label>用户名</label><input name="username" type="text" /> <label>密码</label><input
				name="passwd" type="password" /> <label>手机号码</label><input
				name="telephone" type="text" /> <input type="submit">
		</form>
	</div>
</body>
</html>