<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>JC마켓 : 상품 상세정보</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/border/border_reset.css">
    <link rel="stylesheet" href="/css/product/product_dtl.css">
    <script src = "/js/index/index_product.js" defer></script>
</head>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<link rel="stylesheet" href="/css/include/footer.css">
<body>
    <!-- header -->
	<jsp:include page="../include/header.jsp"/> 
    <input type = "hidden" class="like_id" value = "${item.like_id}">


    <!-- main content -->
    <main class="wrap main">
        <!-- 상단 아이템 정보 -->
        <section class="t_container">
            <!-- 상품 사진 -->
            <c:forEach var="fileBean" items="${fileList }" varStatus="st">
                <img src="/static/itemfileupload/${fileBean.tempFileName}" alt="상품 사진입니다." class="item_photo">
            </c:forEach>
            <!-- 상품 정보 -->
            <section class="item_info">
                <!-- 상품명 -->
                <article class="t_item_info">
                    <h3 id="item_title_value">${item.item_title}</h3>
                    <h4><fmt:formatNumber value="${item.item_price}" type="number"/><span> 원</span></h4>
                    <input type="hidden" class="listinfo item_code" value=${item.item_code }>
                  	<input type="hidden" class="listinfo" value=${item.item_writer }> 
                    <input type="hidden" class="listinfo user_id" value=${principal.user.id }>
                    
                </article>
                <!-- 상품간략정보 -->
                <article class="b_item_info">
                    <!-- 상품상태 -->
                    <ul class="item_info_now">
                        <li><i class="fas fa-heart"></i> ${item.like_count}</li>
                        <li><i class="fas fa-eye"></i> ${item.item_count}</li>
                        <li><i class="fas fa-clock"></i> <span class= "item_time">${item.update_date }</span></li>
                        <li><i class="fas fa-exclamation-triangle"></i> 신고하기</li>
                    </ul>
                    <!-- 상품정보 -->
                    <article class="item_info_dtl">
                        <h4>판매자</h4>
                        <span><a href="/my-shop/${item.item_writer}">${item.user_nickname}</a></span>
                        <h4>상품상태</h4>
                        <c:choose>
                            <c:when test="${item.item_stat eq 0}">
                                <span>새상품</span>
                            </c:when>
                            <c:when test="${item.item_stat eq 1}">
                                <span>S급</span>
                            </c:when>
                            <c:when test="${item.item_stat eq 2}">
                                <span>A급</span>
                            </c:when>
                            <c:when test="${item.item_stat eq 3}">
                                <span>B급</span>
                            </c:when>
                            <c:otherwise>
                                <span>DB값 오류</span>
                            </c:otherwise>
                        </c:choose>
                        <h4>교환여부</h4>
                        <c:choose>
                            <c:when test="${item.item_change eq 0}">
                                <span>교환가능</span>
                            </c:when>
                            <c:when test="${item.item_change eq 1}">
                                <span>교환불가</span>
                            </c:when>
                            <c:otherwise>
                                <span>DB값 오류</span>
                            </c:otherwise>
                        </c:choose>
                        <h4>배송비</h4>
                        <c:choose>
                            <c:when test="${item.item_delivery eq 0}">
                                <span>판매자 부담</span>
                            </c:when>
                            <c:when test="${item.item_delivery eq 1}">
                                <span>구매자 부담</span>
                            </c:when>
                            <c:when test="${item.item_delivery eq 2}">
                                <span>직거래</span>
                            </c:when>
                            <c:otherwise>
                                <span>DB값 오류</span>
                            </c:otherwise>
                        </c:choose>
                    </article>
                    <!-- 연락버튼 -->
                    <article class="item_info_btn">
                        <button type="button" class ="like_button"><i class="fas fa-heart"></i> 찜 <span class="like_count">${item.like_count}</span></button>
                        <button type="button" class="chatstart">연락하기</button>
                        <button type="button">구매하기</button>
                    </article>
                </article>
            </section>
        </section>

        <section class="b_container">
            <h2 class="item_dtl_name">상품정보</h2>
            <pre class="item_dtl">${item.item_content}</pre>

            <article class="list_btn_container">
                <c:if test="${principal.user.role eq 'admin' || principal.user.id eq item.item_writer}">
                    <button type="button" class="list_btn product_update_btn">수정</button>
                    <button type="button" class="list_btn product_delete_btn">삭제</button>
                </c:if>
                <button type="button" class="list_btn" onclick="location.href='/items/new/1'">목록</button>
            </article>

            <!-- 이전상품, 다음상품 아직 구현 못 함-->
            <!--
            <article class="notice_pre_next">
                <ul>
                    <li class="pn_title pn_title1"><i class="fas fa-arrow-up"></i> 다음 상품</li>
                    <c:choose>
                        <c:when test="${not empty next_notice }">
                            <li class="pn_content pn_content1">
                                <a href="/notice/${next_notice.next_code }">
                                    ${next_notice.next_title }
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="pn_content pn_content1">다음 상품이 없습니다.</li>
                        </c:otherwise>
                    </c:choose>
                </ul>
                <ul>
                    <li class="pn_title"><i class="fas fa-arrow-down"></i> 이전 상품</li>
                    <c:choose>
                        <c:when test="${not empty pre_notice }">
                            <li class="pn_content">
                                <a href="/notice/${pre_notice.pre_code }">
                                    ${pre_notice.pre_title }
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="pn_content">이전 상품이 없습니다.</li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </article>
            -->
        </section>
        
        
    </main>



<jsp:include page="../include/footer.jsp"/> 



<script src="/js/product/product_dtl.js"></script>
<script src="/js/product/product_delete.js"></script>
</body>

</html>