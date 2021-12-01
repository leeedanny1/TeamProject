<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/border/border_reset.css">
</head>

<body>
    <!-- header -->
	<jsp:include page="../include/header.jsp"/> 



    <!-- main content -->
    <main class="wrap main">
        <h1 class="page_name">JC Market 공지사항</h1>
        <section class="notice_header">
            <ul>
                <li class="notice_num">번호</li>
                <li class="notice_title">제목</li>
                <li class="notice_writer">작성자</li>
                <li class="notice_date">작성일</li>
                <li class="notice_count">조회수</li>
            </ul>
        </section>

        <section class="notice_main">
            <c:forEach var="notice" items="${noticeList }">
                <a href="/notice/${notice.notice_code }">
                    <ul>
                        <li class="notice_num">${notice.notice_code }</li>
                        <li class="notice_title">${notice.notice_title }</li>
                        <li class="notice_writer">${notice.notice_writer }</li>
                        <fmt:parseDate value="${notice.notice_date }" var="insertDate" pattern="yyyy-MM-dd'T'HH:mm:ss"/>
                        <li class="notice_date"><fmt:formatDate value="${insertDate }" pattern="yyyy-MM-dd"/></li>
                        <li class="notice_count">${notice.notice_count }</li>
                    </ul>
                </a>
            </c:forEach>
        </section>

        <section class="notice_footer">
            <c:if test="${not empty login_user }">
                <section class="btn_container">
                    <button type="button" class="notice_insert_button"
                        onclick="location.href='/notice/write'">글쓰기</button>
                </section>
            </c:if>

            <ul class="page_num_area">
                <a href="/notice/list/${noticeBean.startPage - 1 eq 0 ? 1 : noticeBean.pageNumber - 1 }">
                    <li><i class="fas fa-arrow-circle-left"></i></li>
                </a>

                <c:forEach var="i" begin="${noticeBean.startPage }" end="${noticeBean.endPage }">
                    <a href="/notice/list/${i }">
                        <li>${i }</li>
                    </a>
                </c:forEach>

                <a
                    href="/notice/list/${noticeBean.totalPage eq noticeBean.pageNumber ? noticeBean.totalPage : noticeBean.pageNumber + 1 }">
                    <li><i class="fas fa-arrow-circle-right"></i></li>
                </a>
            </ul>
        </section>
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