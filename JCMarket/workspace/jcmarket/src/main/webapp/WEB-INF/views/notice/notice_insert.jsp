<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 : 글쓰기</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/border/border_reset.css">
</head>

<body>
    <!-- header -->
	<jsp:include page="../include/header.jsp"/> 



    <!-- main content -->
    <main class="wrap main">
        <h1 class="page_name">공지사항 작성</h1>
        <form id="insert_form">
            <ul class="title_ul">
                <li class="title_name">제목</li>
                <li class="title_insert"><input type="text" class="title" name="title"></li>
            </ul>
            <ul class="info_ul">
                <li>작성자</li>
                <li>관리자</li>
                <li>작성일</li>
                <li>2021-11-23</li>
            </ul>
            <ul class="file_ul">
                <li class="file_li">첨부파일</li>
                <li class="file_insert"><input type="file" multiple="multiple" name="file" required></li>
            </ul>
            <ul class="content_ul">
                <li>
                    <textarea class="notice_content" name="notice_content"></textarea>
                </li>
            </ul>

            <section class="btn_container">
                <button type="button" class="submit">작성완료</button>
                <button type="reset">다시쓰기</button>
            </section>
        </form>
    </main>



    <!-- footer -->
    <footer>
        <main class="wrap">
            푸터<br>
            dsfdsfsd <br>
        </main>
    </footer>
</body>

</html>