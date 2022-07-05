<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="connector.*"%>
<%@ page import="controller.*"%>
<%@ page import="model.UserDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link href="signin.css" rel="stylesheet">
<style>
html, body {
	height: 100%;
}

body {
	display: flex;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
}
</style>
</head>
<body>
	<%
	String errorMessage = (String) session.getAttribute("errorMessage");

	if (errorMessage != null) {
	%>
	<%=errorMessage%>
	<%
	}
	%>

	<main class="form-signin w-100 m-auto">
		<form method="post" action="/member/auth.jsp">
			<div class="mb-8">
				아이디 <input type="text" name="username" class="form-control">
			</div>
			<div class="mb-8">
				비밀번호 <input type="password" name="password" class="form-control">
			</div>
			<div class="mb-8 row justify-content-around">
				<button type="submit" class="btn btn-secondary col-4">로그인</button>
				<div class="btn btn-warning col-4" onclick="location.href='/member/register.jsp'">회원가입</div>
			</div>
		</form>
	</main>
	
</body>
</html>