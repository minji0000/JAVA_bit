<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Kari's Store </title>
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">

</head>
<body>
<div class = "main">
    <div class = "first">
        <img id="banner1" src ="/static/img/banner1.png"  alt="배너" >
    </div>

    <div class = "banner">
        <img id = "logo" src ="/static/img/logo1.png"  alt="로고">

        <div class = search_mode>
            <input id = "search" type = text placeholder="검색어 입력" >
            <img id = "search_icon" src ="/static/img/ruby.png"  alt="검색창">
        </div>

        <button id = "wish"> 관심 목록 </button>
        <button id="logIn" onclick = "location.href = '/user/logIn'"> 로그인 </button>
    </div>

    <div class = "main_header" >
        <div id ="menu2">
            <ul class = "M01">
                <li><a href="#">뷰티</a>
                    <ul class = "M02">
                        <li href="#"><a>소메뉴1</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴2</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴3</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#">메이크업</a>
                    <ul class = "M02">
                        <li href="#"><a>소메뉴1</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴2</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴3</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#">패션</a>
                    <ul class = "M02">
                        <li href="#"><a>소메뉴1</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴2</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴3</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#">신발</a>
                    <ul class = "M02">
                        <li href="#"><a>소메뉴1</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴2</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴3</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#">가방</a>
                    <ul class = "M02">
                        <li href="#"><a>소메뉴1</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴2</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴3</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#">팬시</a>
                    <ul class = "M02">
                        <li href="#"><a>소메뉴1</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴2</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴3</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#">악세서리</a>
                    <ul class = "M02">
                        <li href="#"><a>소메뉴1</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴2</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>소메뉴3</a>
                            <ul class = "M03">
                                <li href="#"><a>2단 소메뉴1</a></li>
                                <li href="#"><a>2단 소메뉴2</a></li>
                                <li href="#"><a>2단 소메뉴3</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

        <div class="main_category">
            <div id="category_btn">
            <button type="button"> <span> 전체 카테고리 </span> </button>
            </div>
            <div id = "menu_btn">
            <a class = "category_link">프리미엄관</a>
            <a class = "category_link">뷰티</a>
            <a class = "category_link">패션</a>
            <a class = "category_link">kari's place </a>
            <a class = "category_link">쇼핑기획전</a>
            <a class = "category_link">이벤트</a>
            </div>
        </div>

        <div class = "main_container">

        </div>
    </div>







</div>






</body>
</html>