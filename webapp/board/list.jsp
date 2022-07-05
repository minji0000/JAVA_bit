<%@page import="controller.UserController"%>
<%@page import="model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.BoardController"%>
<%@page import="connector.DBConnector"%>
<%@page import="connector.MySqlConnector"%>
<%@page import="model.UserDTO"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	UserDTO u = (UserDTO)session.getAttribute("logIn");
	if(u == null) {
		response.sendRedirect("/index.jsp");
	}
	
	DBConnector connector = new MySqlConnector();
	BoardController boardController = new BoardController(connector);
	UserController userController = new UserController(connector);
	
	ArrayList<BoardDTO> list = boardController.selectAll();
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	 
%>
	<div class = "container">
		<table class = "table">
		<thead>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>작성일</td>
			<td>수정일</td>
		<thead>
		
		<%
		for(BoardDTO b : list) {
		%>
		<tr>
			<td><%=b.getId()%></td>
			<td><a href="/board/selectOne.jsp?id=<%=b.getId()%>"><%=b.getTitle()%> </a></td>
			<td> <%=sdf.format(b.getWrittenDate().getTime()) %></td>
			<td><%=sdf.format(b.getUpdatedDate().getTime()) %></td>
			
		</tr>
				
		<%	
		}
		%>
	
		</table>
		
	<div class = "btn btn-primary" onclick="location.href ='/board/write.jsp'" > 글 작성하기 </div>	
		
		
		
		
		
		
	</div>








</body>
</html>