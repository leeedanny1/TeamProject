<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 : 수정하기</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/border/border_reset.css">
    <link rel="stylesheet" href="/css/include/footer.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <!-- header -->
    <jsp:include page="../include/header.jsp" />



    <!-- main content -->
    <main class="wrap main notice_main_c">
        <h1 class="page_name">공지사항 수정</h1>
        <form id="update_form">
            <input type="hidden" name="notice_code" id="notice_code" value="${notice_update.notice_code }">
            <ul class="title_ul">
                <li class="title_name">제목</li>
                <li class="title_insert"><input type="text" class="notice_title" name="notice_title"
                        value="${notice_update.notice_title }"></li>
            </ul>
            <ul class="info_ul">
                <li>작성자</li>
                <li>${notice_update.user_nickname }</li>
                <li>수정일</li>
                <li>
                    <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm" />
                </li>
            </ul>
            <ul class="content_ul">
                <li>
                    <textarea class="notice_content" name="notice_content">${notice_update.notice_content }</textarea>
                </li>
            </ul>

            <ul class="file_ul_dtl">
                <li>첨부파일</li>
            </ul>
            <ul class="file_ul_dtl">
                <li>
                    <input type="file" multiple="multiple" name="notice_file">
                </li>
            </ul>
            <ul class="file_ul_dtl">
                <li class="file_list">
                    <c:forEach var="fileBean" items="${fileList }" varStatus="st">
                        <div class="item-file">
                            <input type="hidden" name="originFileNames" value="${fileBean.originFileName }">
                            <input type="hidden" name="tempFileNames" value="${fileBean.tempFileName }">
                            <label class="file-name">${fileBean.originFileName }</label>
                            <div class="file-dbtn"><i class="far fa-times-circle"></i></div>
                        </div>
                        <c:if test="${not st.last }">
                            <hr>
                        </c:if>
                    </c:forEach>
                </li>
            </ul>

            <section class="btn_container">
                <button type="button" class="notice_update_button">수정완료</button>
                <button type="button" class="notice_cancel_button">수정취소</button>
            </section>
        </form>
    </main>


    <jsp:include page="../include/footer.jsp" />

    <script src="/js/notice/notice_update.js"></script>
</body>

</html>