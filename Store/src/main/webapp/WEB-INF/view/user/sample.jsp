<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>부트스트랩 샘플 페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>

<main>
    <header class="p-3 bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <svg class="bi me-2" width="40" height="32" role="img" aria-label="부트스트랩"><use xlink:href="#bootstrap"></use></svg>
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="#" class="nav-link px-2 text-secondary"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">집</font></font></a></li>
                    <li><a href="#" class="nav-link px-2 text-white"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">특징</font></font></a></li>
                    <li><a href="#" class="nav-link px-2 text-white"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">가격</font></font></a></li>
                    <li><a href="#" class="nav-link px-2 text-white"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">자주 묻는 질문</font></font></a></li>
                    <li><a href="#" class="nav-link px-2 text-white"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">에 대한</font></font></a></li>
                </ul>

                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                    <input type="search" class="form-control form-control-dark" placeholder="검색..." aria-label="검색">
                </form>

                <div class="text-end">
                    <button type="button" class="btn btn-outline-light me-2"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">로그인</font></font></button>
                    <button type="button" class="btn btn-warning"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">가입하기</font></font></button>
                </div>
            </div>
        </div>
    </header>
</main>

</body>
</html>