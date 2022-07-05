<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

.btn-outline {
	border-color: #FF69B4;
}

</style>

<title>회원가입</title>
</head>
<body>
<%
	String errorMessage = (String)session.getAttribute("errorMessage");

	if(errorMessage != null) {
%>
<%= errorMessage %> <br/>
<% 				
	}
%>
	<main class="form-signin w-100 m-auto">
		<form method = "post" action = "/member/register_logic.jsp">
			<div class= "mb-6">
				아이디 <input type ="text" name="username" class="form-control">
			</div>
			<div class= "mb-6">
				비밀번호 <input type ="password" name="password"  class="form-control">
			</div>
			<div class= "mb-6">	
				닉네임 <input type ="text" name="nickname"  class="form-control">
			</div>
			<div class= "mb-12 row justity-content-center">
				<button type = "submit" class="btn btn-outline">회원가입</button>
			</div>
		</form>
	</main>

</body>
</html>