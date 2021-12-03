<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>공지사항</title>

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
        <h1 class="page_name">공지사항</h1>
        <section id="insert_form">
        	<input type="hidden" id="notice_code" value="${notice_dtl.notice_code }">
        	<input type="hidden" id="notice_title" value="${notice_dtl.notice_title }">
        
            <ul class="title_ul">
                <li class="title_name">제목</li>
                <li class="title_insert">${notice_dtl.notice_title}</li>
            </ul>
            <ul class="info_ul">
                <li>작성자</li>
                <li>${notice_dtl.notice_writer}</li>
                <li>조회수</li>
                <li>${notice_dtl.notice_count}</li>
            </ul>
            <ul class="info_ul">
                <li>작성시간</li>
                <fmt:parseDate value="${notice_dtl.notice_date }" var="insertDate" pattern="yyyy-MM-dd'T'HH:mm"/>
                <li><fmt:formatDate value="${insertDate }" pattern="yyyy-MM-dd HH:mm"/></li>
                <li>수정시간</li>
				<fmt:parseDate value="${notice_dtl.update_date }" var="updateDate" pattern="yyyy-MM-dd'T'HH:mm"/>
                <li><fmt:formatDate value="${updateDate }" pattern="yyyy-MM-dd HH:mm"/></li>
            </ul>

            <ul class="content_ul">
                <li>
                    <pre>${notice_dtl.notice_content}</pre>
                </li>
            </ul>

            <ul class="file_ul_dtl">
                <li>첨부파일</li>
            </ul>
            <ul class="file_ul_dtl">
                <li>
                <!-- 
                    <c:forEach var="fileBean" items="${fileList }" varStatus="st">
                        <a href="file-download/${fileBean.originFileName }?tempFileName=${fileBean.tempFileName }">
                            ${fileBean.originFileName }
                        </a>
                        <c:if test="${not st.last }">
                            /
                        </c:if>
                    </c:forEach>
                     -->
                </li>
            </ul>

        </section>

        <article class="list_btn_container">
            <c:if test="${principal.user.role eq 'admin'}">
                <button type="button" class="list_btn notice_update_btn">수정</button>
                <button type="button" class="list_btn notice_delete_btn">삭제</button>
            </c:if>
            <button type="button" class="list_btn" onclick="location.href='/notice/list'">목록</button>
        </article>


        <div class="notice_pre_next">
            <ul class="notice_next">
                <li class="next_title">다음 글</li>
                <!-- 
                <c:if test="${notice.nextNotice_code ne 0}">
                    <a href="notice/${notice.nextNotice_code }">
                        <li>${notice.nextNotice_title }</li>
                    </a>
                </c:if>
                 -->
            </ul>
            <ul class="notice_pre">
                <li class="pre_title">이전 글</li>
                <!--
                <c:if test="${notice.preNotice_code ne 0}">
                    <a href="notice/${notice.preNotice_code }">
                        <li>${notice.preNotice_title }</li>
                    </a>
                </c:if>
                 -->
            </ul>
        </div>
    </main>



    <!-- footer -->
    <footer>
        <main class="wrap">
            푸터<br>
            dsfdsfsd <br>
        </main>
    </footer>
    


    <script src="/js/notice/notice_dtl.js"></script>
    <script src="/js/notice/notice_delete.js"></script>
</body>

</html>