<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
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
            <a href="/product/hot_product.html">
                <h2 class="page_name">인기상품</h2>
            </a>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container item_big_container">
                <c:forEach var="notice" items="${noticeList }" class="item_container">
                    <li class="item_list">
                        <!-- 상품사진 -->
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <!-- 상품이름 -->
                        <p class="item_name">상품 이름입니다. 긴 이름도 입력이 됩니다.</p>
                        <!-- 상품 가격과 올린 시간 -->
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                    <li class="item_list">
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <p class="item_name">상품 이름입니다.</p>
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                    <li class="item_list">
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <p class="item_name">상품 이름입니다.</p>
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                    <li class="item_list">
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <p class="item_name">상품 이름입니다.</p>
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                    <li class="item_list">
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <p class="item_name">상품 이름입니다.</p>
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                    <li class="item_list">
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <p class="item_name">상품 이름입니다.</p>
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                    <li class="item_list">
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <p class="item_name">상품 이름입니다.</p>
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                    <li class="item_list">
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <p class="item_name">상품 이름입니다.</p>
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                    <li class="item_list">
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <p class="item_name">상품 이름입니다.</p>
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                    <li class="item_list">
                        <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
                        <p class="item_name">상품 이름입니다.</p>
                        <ul class="item_info">
                            <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                            <li><span class="item_time">1시간 전</span></li>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </section>

        <section class="product_footer">
            <c:if test="${not empty login_user }">
                <section class="btn_container">
                    <button type="button" class="notice_insert_button"
                        onclick="location.href='/items/sale'">상품등록</button>
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