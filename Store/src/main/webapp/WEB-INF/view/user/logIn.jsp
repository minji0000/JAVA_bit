<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title> 로그인 해주세요 </title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/button.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">

</head>

<body class="text-center">

    <form method="post" action="/user/logIn">
        <div class = "login">
            <br> <br> <br>
        <div id = "id">
        <input type="text" name="username" class = "form-control" placeholder="아이디">
        </div>
            <br>
        <div id = "pass">
        <input type="password" name="password" class = "form-control" placeholder="비밀번호">
        </div>
            <br>
        <div id = "login_btn">
        <button class = "btn1" type="submit" style= "width: 7%" > LogIn </button>
        </div>
        </div>
    </form>

        <button class = "btn1" style="width: 7%"><a href="/user/register"> Sign up</a>
        </button>






</body>
</html>