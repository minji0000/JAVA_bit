<%@page import="model.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="controller.UserController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	UserController controller = new UserController();
	controller.init();
	List<UserDTO> list = controller.selectAll();
	UserDTO u = controller.selectOne(32);
	
	u = new UserDTO();
	
	u.setUsername("치킨");
	u.setPassword("bb");
	u.setNickname("비비");
	
	controller.insert(u);
%>

<%= u %>

</body>
</html>