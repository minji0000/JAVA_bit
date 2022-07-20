<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Kari's Store </title>
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script defer src="/static/js/index.js"></script>

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
        <button><a href="/"> 로그아웃 </a></button>
    </div>

    <div class = "main_header" >

        <div id ="menu2">
            <ul class = "M01">
                <li><a href="/product/showBeauty">뷰티</a>
                    <ul class = "M02">
                        <li href="#"><a>스킨케어</a>
                            <ul class = "M03">
                                <li href="#"><a>스킨/토너</a></li>
                                <li href="#"><a>에센스/세럼</a></li>
                                <li href="#"><a>로션</a></li>
                                <li href="#"><a>크림</a></li>
                                <li href="#"><a>미스트/오일</a></li>
                                <li href="#"><a>패드/마스크팩</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>클렌징</a>
                            <ul class = "M03">
                                <li href="#"><a>여행용 미니</a></li>
                                <li href="#"><a>약산성</a></li>
                                <li href="#"><a>모공관리</a></li>
                                <li href="#"><a>여드름</a></li>
                                <li href="#"><a>오일/워터</a></li>
                                <li href="#"><a>클렌징폼/젤</a></li>
                                <li href="#"><a>필링/스크럽</a></li>
                            </ul>
                        </li>
                        <li href="#"><a>선케어</a>
                            <ul class = "M03">
                                <li href="#"><a>유기자차</a></li>
                                <li href="#"><a>무기자차</a></li>
                                <li href="#"><a>톤업 선크림</a></li>
                                <li href="#"><a>야외활동용</a></li>
                                <li href="#"><a>패밀리용</a></li>
                                <li href="#"><a>선블록</a></li>
                                <li href="#"><a>태닝/애프터선</a></li>
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

        <div id="category_btn">
            <H2 id = "category_btn1"> ≡ 전체 카테고리 </H2>
        </div>

        <div id = "menu_btn">
            <a><H2 class = "category_link">프리미엄관</H2></a>
            <a><H2 class = "category_link">뷰티</H2></a>
            <a><H2 class = "category_link">패션</H2></a>
            <a><H2 class = "category_link">kari's place</H2></a>
            <a><H2 class = "category_link">쇼핑 기획전</H2></a>
            <a><H2 class = "category_link">이벤트</H2></a>
        </div>

        <div class = "main_container">
            <div class="container">
                <ul class="slider">
                    <img class="item" src="/static/img/dis1.jpeg">
                    <img class="item" src="/static/img/dis2.png">
                    <img class="item" src="/static/img/dis3.jpeg">
                </ul>
            </div>
        </div>

    </div>


</div>
</body>
</html>