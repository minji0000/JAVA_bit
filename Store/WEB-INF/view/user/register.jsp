<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> 가입해즈세여 ~ </title>
    <!-- CSS only -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/tabmenu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/button.css">


</head>
<body class="text-center">
    <br><br>
    <div class="tabs">
        <input id="all" type="radio" name="tab_item" checked>
        <label class="tab_item" for="all">일반회원</label>
        <input id="programming" type="radio" name="tab_item">
        <label class="tab_item" for="programming">사업자회원</label>
        <input id="design" type="radio" name="tab_item">

        <div class="tab_content" id="all_content">
            <form method="post" action="/user/member_register">
                <input type="text" name="name" class = "form-control" placeholder="이름">
                <br> <br>
                <input type="text" name="username" class = "form-control" placeholder="아이디">
                <br> <br>
                <input type="password" name="password" class = "form-control" placeholder="비밀번호">
                <br> <br>
                <input type="text" name="number" class = "form-control" placeholder="전화번호">
                <br> <br>
                <input type="text" name="address" class = "form-control" placeholder="주소">
                <br> <br>
                <button type = "submit" class = "btn1"> 일반회원 가입하기 </button>
            </form>
        </div>
        <div class="tab_content" id="programming_content">
            <form method="post" action="/user/seller_register">
                <input type="text" name="name" class = "form-control" placeholder="이름">
                <br>  <br>
                <input type="text" name="username" class = "form-control" placeholder="아이디">
                <br> <br>
                <input type="password" name="password" class = "form-control" placeholder="비밀번호">
                <br> <br>
                <input type="text" name="number" class = "form-control" placeholder="전화번호">
                <br> <br>
                <input type="text" name="address" class = "form-control" placeholder="주소">
                <br> <br>
                <button type = "submit" class = "btn1"> 사업자회원 가입하기 </button>
            </form>
        </div>
    </div>


</body>
</html>