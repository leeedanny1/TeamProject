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
    <title>JC마켓</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/include/footer.css">
    <link rel="stylesheet" href="/css/index.css">
    <script src="/js/index/index_product.js" defer></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <!-- header -->
    <jsp:include page="../include/header.jsp" />

    <!-- main content -->
    <main class="wrap main">
        <!-- 광고배너 -->
        <section class="ad_images">

        </section>

        <!-- 공지사항과 커뮤니티 바로가기 배너 -->
        <section class="notice_banner">
            <article class="notice"></article>
            <article class="community"></article>
        </section>

        <!-- 인기상품 -->
        <!-- 하트 만들어서 판매중인 상품중에 하트 높은 순서대로 정렬 -->
        <section class="sale_item">
            <a href="/items/hot/1">
                <h2 class="section_name">인기상품</h2>
            </a>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container">
                <c:forEach var="items" items="${hotList }">
                    <li class="item_list" onclick="location.href = '/items/${items.item_code}'">
                        <!-- 상품사진 -->
                        <img src="/static/itemfileupload/${items.tempFileNames}" alt="상품사진입니다." class="item_photo">
                        <!-- 상품이름 -->
                        <ul class="item_info item_info_over">
                            <p class="item_name">${items.item_title}</p>
                            <p class="item_name_sub"><i class="fas fa-heart"></i>
                                <c:choose>
                                    <c:when test="${items.like_count gt 100}">99+</c:when>
                                    <c:otherwise>${items.like_count}</c:otherwise>
                                </c:choose>
                            </p>
                        </ul>
                        <!-- 상품 가격과 올린 시간 -->
                        <ul class="item_info">
                            <li><span class="item_price">
                                    <strong>
                                        <fmt:formatNumber value="${items.item_price}" type="number" />
                                    </strong>원</span>
                            </li>
                            <li><span class="item_time">${items.update_date}</span></li>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </section>

        <!-- 최근상품 -->
        <section class="sale_item">
            <a href="/items/new/1">
                <h2 class="section_name">최근상품</h2>
            </a>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container">

                <c:forEach var="items" items="${newList }">
                    <li class="item_list" onclick="location.href = '/items/${items.item_code}'">
                        <!-- 상품사진 -->
                        <img src="/static/itemfileupload/${items.tempFileNames}" alt="상품사진입니다." class="item_photo">
                        <!-- 상품이름 -->
                        <ul class="item_info item_info_over">
                            <p class="item_name">${items.item_title}</p>
                            <p class="item_name_sub"><i class="fas fa-eye"></i>
                                <c:choose>
                                    <c:when test="${items.item_count gt 100}">99+</c:when>
                                    <c:otherwise>${items.item_count}</c:otherwise>
                                </c:choose>
                            </p>
                        </ul>
                        <!-- 상품 가격과 올린 시간 -->
                        <ul class="item_info">
                            <li><span class="item_price">
                                    <strong>
                                        <fmt:formatNumber value="${items.item_price}" type="number" />
                                    </strong>원</span>
                            </li>
                            <li><span class="item_time">${items.update_date }</span></li>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </section>
    </main>
    <jsp:include page="../include/footer.jsp" />

</body>


</html>