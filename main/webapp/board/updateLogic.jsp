<%@page import="model.BoardDTO"%>
<%@page import="controller.BoardController"%>
<%@page import="connector.DBConnector"%>
<%@page import="connector.MySqlConnector"%>
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

	int id = Integer.parseInt(request.getParameter("id"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	DBConnector connector = new MySqlConnector();
	BoardController boardController = new BoardController(connector);
	
	BoardDTO b = boardController.selectOne(id);
	b.setTitle(title);
	b.setContent(content);
	
	boardController.update(b);
	
	response.sendRedirect("/board/selectOne.jsp?id="+id);
	
%> 









</body>
</html>