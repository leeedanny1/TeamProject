<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
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
</head>

<body>
    <!-- header -->
	<jsp:include page="../include/header.jsp"/> 



    <!-- main content -->
    <main class="wrap main">
        <!-- 상단 아이템 정보 -->
        <section class="t_container">
            <!-- 상품 사진 -->
            <img src="../images/items/items.jpg" alt="상품 사진입니다." class="item_photo">
            <!-- 상품 정보 -->
            <section class="item_info">
                <!-- 상품명 -->
                <article class="t_item_info">
                    <h3>김준일강사님수업 1시간 이용권</h3>
                    <h4>1,000,000<span> 원</span></h4>
                </article>
                <!-- 상품간략정보 -->
                <article class="b_item_info">
                    <!-- 상품상태 -->
                    <ul class="item_info_now">
                        <li><i class="fas fa-heart"></i> 0</li>
                        <li><i class="fas fa-eye"></i> 50</li>
                        <li><i class="fas fa-clock"></i> 1시간 전</li>
                        <li><i class="fas fa-exclamation-triangle"></i> 신고하기</li>
                    </ul>
                    <!-- 상품정보 -->
                    <article class="item_info_dtl">
                        <h4>판매자</h4>
                        <span>판매자 닉네임</span>
                        <h4>상품상태</h4>
                        <span>새상품</span>
                        <h4>교환여부</h4>
                        <span>교환 불가능</span>
                        <h4>배송비</h4>
                        <span>배송비 별도</span>
                    </article>
                    <!-- 연락버튼 -->
                    <article class="item_info_btn">
                        <button type="button"><i class="fas fa-heart"></i> 찜 0</button>
                        <button type="button">연락하기</button>
                        <button type="button">구매하기</button>
                    </article>
                </article>
            </section>
        </section>

        <section class="b_container">
            <h2 class="item_dtl_name">상품정보</h2>
            <pre
                class="item_dtl">김준일강사님수업 1시간 이용권입니다.<br>유효기간은 2021년 12월 31일 까지입니다.<br>유효기간이 얼마 남지 않아서 100만원에 급처합니다.</pre>
            <article class="list_btn_container">
                <button type="button" class="list_btn" onclick="location.href='/product/product_update.html'">수정</button>
                <button type="button" class="list_btn">삭제</button>
                <button type="button" class="list_btn" onclick="location.href='/product/new_product.html'">목록</button>
            </article>
        </section>

    </main>



    <!-- footer -->
    <footer>
        <main class="wrap">
            푸터<br>
            dsfdsfsd <br>
        </main>
    </footer>



    <!-- fontawesome CDN -->
    <script src="https://kit.fontawesome.com/85db88a229.js" crossorigin="anonymous"></script>
</body>

</html>