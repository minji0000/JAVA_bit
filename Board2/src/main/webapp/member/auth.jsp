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
	DBConnector connector = new MySqlConnector();
	UserController userController = new UserController(connector);
	UserDTO u = userController.logIn(username, password);

	if (u != null) {
	session.setAttribute("logIn", u);
	session.setAttribute("errorMessage", null);
	response.sendRedirect("/board/list.jsp");
	} else {
	session.setAttribute("errorMessage" , "아이디와 비밀번호를 다시 확인해주세요.");
	response.sendRedirect("/index.jsp");
	}
	%>

</body>
</html>