<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

정말로 삭제하시겠습니까?
<%
	int id = Integer.parseInt(request.getParameter("id"));	
%>


<div onclick = "location.href='/board/deleteLogic.jsp?id=<%=id%>'">예</div>
<div onclick = "location.href='/board/selectOne.jsp?id=<%=id%>'">아니요</div>
	




</body>
</html>