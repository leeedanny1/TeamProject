<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
</sec:authorize>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 상점</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/myshop/my_shop.css">
    <link rel="stylesheet" href="/css/include/footer.css">
    <script src="/js/mypage/my_shop.js" defer></script>
</head>

<body>
    <jsp:include page="../include/header.jsp" />


    <div class="myshop_container">
        <section class="my_info">
            <article class="title">
                <span>현재 로그인 한 사용자의 정보</span>
            </article>
            <hr>
            <c:choose>
                <c:when test="${not empty principal}">
                    <article class="name">
                        <span>이름: </span>
                        <a href="/my-shop/${principal.user.id}"><span>${principal.user.user_name}</span></a>
                    </article>
                    <article class="phone">
                        <span>전화번호: </span>
                        <span>${principal.user.user_phone}</span>
                    </article>
                    <article class="id">
                        <span>아이디: </span>
                        <span>${principal.user.user_id}</span>
                    </article>
                    <article class="nickname">
                        <span>닉네임: </span>
                        <span>${principal.user.user_nickname}</span>
                    </article>
                </c:when>
                <c:otherwise>
                    <article class="title">
                        <span>로그인이 되어있지 않습니다. 로그인을 진행해 주세요.</span>
                    </article>
                </c:otherwise>
            </c:choose>


        </section>
        <section class="sale_item">
            <h2 class="section_name">${user_nickname }의 판매 상품</h2>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container">
                <c:forEach var="mySaleProduct" items="${mySaleProducts }">
                    <li class="item_list" onclick="location.href = '/items/${mySaleProduct.item_code}'">
                        <!-- 상품사진 -->
                        <img class="item_photo" src="/static/itemfileupload/${mySaleProduct.tempFileNames}"
                            alt="상품사진입니다.">
                        <!-- 상품이름 -->
                        <p class="item_name">${mySaleProduct.item_title}</p>
                        <!-- 상품 가격과 올린 시간 -->
                        <ul class="item_info">
                            <li><span class="item_price">
                                    <fmt:formatNumber value="${mySaleProduct.item_price}" type="number" />원
                                </span></li>
                            <li><span class="item_time">${mySaleProduct.update_date}</span></li>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </section>

        <section class="sale_item">

            <h2 class="section_name">${user_nickname }의 찜한 상품</h2>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container">
                <c:forEach var="mySelectProduct" items="${mySelectProducts }">
                    <li class="item_list" onclick="location.href = '/items/${mySelectProduct.item_code}'">
                        <!-- 상품사진 -->
                        <img class="item_photo" src="/static/itemfileupload/${mySelectProduct.tempFileNames}"
                            alt="상품사진입니다.">
                        <!-- 상품이름 -->
                        <p class="item_name">${mySelectProduct.item_title}</p>
                        <!-- 상품 가격과 올린 시간 -->
                        <ul class="item_info">

                            <li><span class="item_price">
                                    <fmt:formatNumber value="${mySelectProduct.item_price}" type="number" />원
                                </span></li>
                            <li><span class="item_time">${mySelectProduct.update_date}</span></li>
                        </ul>
                    </li>

                </c:forEach>
            </ul>
        </section>
    </div>

    <jsp:include page="../include/footer.jsp" />
</body>

</html>