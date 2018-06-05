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
<title>查看用户信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href=" <%=basePath%>">
</head>
<body>
	<div align="center">
		<form action="user/doQuery" method="post">
			<label>用户id</label><input name="userid" type="text" /><input type="submit">
		</form>
	</div>
</body>
</html>