<%@page import = "connector.*" %>
<%@page import = "model.UserDTO" %>
<%@page import = "controller.UserController" %>
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
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String nickname = request.getParameter("nickname");
	
	
	DBConnector connector = new MySqlConnector();
	UserController userController = new UserController(connector);
	UserDTO u = new UserDTO();
	
	u.setUsername(username);
	u.setPassword(password);
	u.setNickname(nickname);
	
	boolean success = userController.register(u);
	
	if(success) {
		session.setAttribute("errorMessage", null);
		response.sendRedirect("/index.jsp");
	} else {
		session.setAttribute("errorMessage", "중복된 아이디입니다.");
        response.sendRedirect("/member/register.jsp");
       
	}
	
%>
	

</body>
</html>