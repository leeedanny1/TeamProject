<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>


<!DOCTYPE html>
<!-- header -->
    <header>
        <!-- 헤더 내부 wrap -->
        <main class="wrap">
            <!-- 로고와 검색창 들어가는 부분 -->
            <section class="t_header">
                <!-- 로고 -->
                <a href="/index.html"><h1 class="h_logo">JC마켓</h1></a>
                <!-- 검색박스 -->
                <input type="text" class="h_search" placeholder="상품명, 지역명, @상점명 입력">
                <!-- 인포 -->
                <ul class="h_info">
                    <li><a href="">판매하기</a></li>
                    <li>|</li>
                    <li><a href="">내상점</a></li>
                    <li>|</li>
                    <li><a href="">JC톡</a></li>
                </ul>
            </section>

            <!-- 카테고리와 로그인 들어가는 부분 -->
            <section class="b_header">
                <!-- 카테고리 -->
                <ul class="h_category">
                    <li><a href="/notice/notice.html">Notice</a></li>
                    <li><a href="/product/hot_product.html">Hot&nbspItems</a></li>
                    <li><a href="/product/new_product.html">New&nbspItems</a></li>
                    <li><a href="/product/product_insert.html">Selling&nbspItems</a></li>
                </ul>
                <!-- 로그인, 회원가입 -->
                <c:choose>
                   <c:when test="${empty principal.user}">
		                <ul class="h_sign">
		                    <li><a href="sign-in-select">로그인</a></li>
		                    <li><a href="sign-up">회원가입</a></li>
		                </ul>
                	</c:when>
                	<c:otherwise>
		                 <ul class="h_sign">
		                     <li><a href="/update">${principal.user.user_nickname }</a></li>
		                     <li><a href="/logout"><i class="fas fa-sign-out-alt"></i></a></li>
		                 </ul>
                	</c:otherwise>
                </c:choose>
            </section>
        </main>
    </header>
   
</body>
</html>