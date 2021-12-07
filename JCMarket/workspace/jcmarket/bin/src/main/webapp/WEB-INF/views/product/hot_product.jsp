<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>JC마켓 : 인기상품</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/border/border_reset.css">
    <link rel="stylesheet" href="/css/product/product.css">
</head>

<body>
    <!-- header -->
	<jsp:include page="../include/header.jsp"/> 



    <!-- main content -->
    <main class="wrap main">
        <!-- 인기상품 -->
        <!-- 하트 만들어서 판매중인 상품중에 하트 높은 순서대로 정렬 -->
        <section class="sale_item">
            <h2 class="page_name">인기상품</h2>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container">
                <c:forEach var="items" items="${productList }">
                    <li class="item_list" onclick="location.href = '/items/${items.item_code}'">
                        <!-- 상품사진 -->
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <!-- 상품이름 -->
                        <ul class="item_info">
                            <p class="item_name">${items.item_title}</p>
                            <p><i class="fas fa-eye"></i> ${items.item_count} <i class="fas fa-heart"></i> ${items.like_count}</p>
                        </ul>
                        <!-- 상품 가격과 올린 시간 -->
                        <ul class="item_info">
                            <li><span class="item_price">
                                <strong><fmt:formatNumber value="${items.item_price}" type="number"/></strong>원</span>
                            </li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </section>

        <section class="product_footer">
            <c:if test="${not empty principal }">
                <section class="btn_container">
                    <button type="button" class="notice_insert_button"
                        onclick="location.href='/items/sale'">상품등록</button>
                </section>
            </c:if>

            <ul class="page_num_area">
                <a href="/items/new/${productBean.startPage - 5 le 0 ? 1 : productBean.pageNumber - 5 }">
                    <li><i class="fas fa-arrow-circle-left"></i></li>
                </a>

                <c:forEach var="i" begin="${productBean.startPage }" end="${productBean.endPage }">
                    <a href="/items/new/${i }">
                        <li>${i }</li>
                    </a>
                </c:forEach>

                <a
                    href="/items/new/${productBean.totalPage ge productBean.pageNumber ? productBean.totalPage : productBean.pageNumber + 5 }">
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