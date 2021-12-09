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
    <title>상품등록 : 상품등록</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/border/border_reset.css">
	<link rel="stylesheet" href="/css/include/footer.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <!-- header -->
	<jsp:include page="../include/header.jsp"/> 



    <!-- main content -->
    <main class="wrap main">
        <h1 class="page_name">상품등록</h1>
        <form id="insert_form">
            <ul class="title_ul">
                <li class="title_name">상품명</li>
                <li class="title_insert"><input type="text" id="item_title" class="title" name="item_title" placeholder="상품명을 입력하세요."></li>
            </ul>
            <ul class="title_ul">
                <li class="title_name select_name">상품가격(숫자만 입력)</li>
                <li class="title_insert"><input type="number" id="item_price" class="title" name="item_price" placeholder="상품 가격을 입력하세요."></li>
            </ul>
            <ul class="title_ul">
                <li class="title_name">상품상태</li>
                <select name="item_stat" id="item_stat" class="title_insert">
                    <option value=null> ===== 상품 상태를 선택하세요. =====</option>
                    <option value=0>새상품</option>
                    <option value=1>S급</option>
                    <option value=2>A급</option>
                    <option value=3>B급</option>
                </select>
            </ul>
            <ul class="title_ul">
                <li class="title_name">교환여부</li>
                <select name="item_change" id="item_change" class="title_insert">
                    <option value=null> ===== 교환 여부를 선택하세요. =====</option>
                    <option value=0>교환가능</option>
                    <option value=1>교환불가</option>
                </select>
            </ul>
            <ul class="title_ul">
                <li class="title_name">배송비</li>
                <select name="item_delivery" id="item_delivery" class="title_insert">
                    <option value=null> ===== 배송비 부담 방법을 선택하세요. =====</option>
                    <option value=0>판매자 부담</option>
                    <option value=1>구매자 부담</option>
                    <option value=2>직거래</option>
                </select>
            </ul>
            <ul class="info_ul">
                <li>판매자 닉네임</li>
                <input type="hidden" name="item_writer" value="${principal.user.id }">
                <li>${principal.user.user_nickname }</li>
                <li>작성 시작 시간</li>
                <li><fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm"/></li>
            </ul>
            <ul class="file_ul">
                <li class="file_li">사진등록</li>
                <li class="file_insert"><input type="file" multiple="multiple" name="file"></li>
            </ul>
            <ul class="content_ul">
                <li>
                    <textarea class="notice_content" id="item_content" name="item_content" placeholder="상품 설명을 입력하세요."></textarea>
                </li>
            </ul>

            <section class="btn_container">
                <button type="button" class="item_insert_btn">등록완료</button>
                <button type="button" class="item_cancel_btn">등록취소</button>
            </section>
        </form>
    </main>



 <jsp:include page="../include/footer.jsp"/> 

    <script src="/js/product/product_insert.js"></script>
</body>

</html>