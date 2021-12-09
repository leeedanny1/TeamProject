<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>

<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 : 글쓰기</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/border/border_reset.css">
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <!-- header -->
	<jsp:include page="../include/header.jsp"/> 


    <!-- main content -->
    <main class="wrap main notice_main_c">
        <h1 class="page_name">공지사항 작성</h1>
        <form id="insert_form">
            <ul class="title_ul">
                <li class="title_name">제목</li>
                <li class="title_insert"><input type="text" class="title" name="notice_title" placeholder="공지사항 제목을 입력하세요"></li>
            </ul>
            <ul class="info_ul">
                <li>작성자</li>
                <input type="hidden" name="notice_writer" value="${principal.user.id }">
                <li name="notice_writer">${principal.user.user_nickname }</li>
                <li>작성일</li>
                <li><fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm"/></li>
            </ul>
            <ul class="file_ul">
                <li class="file_li">첨부파일</li>
                <li class="file_insert"><input type="file" multiple="multiple" name="notice_file"></li>
            </ul>
            <ul class="content_ul">
                <li>
                    <textarea class="notice_content" name="notice_content"></textarea>
                </li>
            </ul>

            <section class="btn_container">
                <button type="button" class="notice_insert_button">작성완료</button>
                <button type="button" class="notice_cancel_button">작성취소</button>
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
    
    <script src="/js/notice/notice_insert.js"></script>
</body>

</html>