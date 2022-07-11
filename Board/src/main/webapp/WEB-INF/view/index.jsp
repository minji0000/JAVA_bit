<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 해주세요 ! </title>
</head>
<body>
	<h1> 다들 안녕 ! ! </h1>
	<form method = "post" action = "user/logIn">
		<input type = "text" placeholder = "아이디를 입력해" name = "username">
		<input type = "password" placeholder = "비밀번호도 입력해" name= "password">
		<button style = "background-color: #FFC0CB" > 로그인</button> 
	</form>

</body>
</html>