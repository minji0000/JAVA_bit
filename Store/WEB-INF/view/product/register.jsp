<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> 물건을 등록해즈세여~ </title>
</head>
<body>
    <div>

        <h2> 등록하실 상품을 입력해주세요.</h2>

        <form method="post" action="/product/register2" enctype="multipart/form-data">
            상품이름 <input type="text" name = "name">
            <br>
            상품종류의 번호를 선택해주세요.
            <br>
            1. 뷰티 2. 메이크업 3. 패션 4. 신발 5. 가방 6. 팬시 7. 악세서리
            <br>
            <input type="text" name = "kind">
            <br>
            가격 <input type="text" name = "price">원
            <br>
            상품 설명 <input type="text" name = "content">
            <br>
            <input type = "file" multiple = "multiple" name = "image">
            <br>
            <button type = "submit"> 상품 등록 </button>
        </form>




    </div>

</body>
</html>