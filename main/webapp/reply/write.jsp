<%@page import="model.ReplyDTO"%>
<%@page import="controller.ReplyController"%>
<%@page import="connector.DBConnector"%>
<%@page import="connector.MySqlConnector"%>
<%@page import="model.UserDTO"%>
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
	int boardId = Integer.parseInt(request.getParameter("boardId"));
	String content = request.getParameter("content");
	UserDTO logIn = (UserDTO)session.getAttribute("logIn");
	
	DBConnector connector = new MySqlConnector();
	ReplyController replyController = new ReplyController(connector);
	
	ReplyDTO r = new ReplyDTO();
	r.setBoardId(boardId);
	r.setWriterId(logIn.getId());
	r.setContent(content);
	
	replyController.insert(r);
	
	response.sendRedirect("/board/selectOne.jsp?id=" + boardId);
	
%>














</body>
</html>