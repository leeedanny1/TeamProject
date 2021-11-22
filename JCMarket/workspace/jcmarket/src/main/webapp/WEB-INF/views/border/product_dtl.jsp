<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JC마켓 : 상품 상세정보</title>

    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/include/include.css">
    <link rel="stylesheet" href="../css/border/product_dtl.css">
</head>
<body>
    <!-- header -->
    <header>
        <!-- 헤더 내부 wrap -->
        <main class="wrap">
            <!-- 로고와 검색창 들어가는 부분 -->
            <section class="t_header">
                <!-- 로고 -->
                <a href="#"><h1 class="h_logo">JC마켓</h1></a>
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
                    <li><a href="#">Spring</a></li>
                    <li><a href="#">Boot</a></li>
                    <li><a href="#">JAVA</a></li>
                    <li><a href="#">Security</a></li>
                </ul>
                <!-- 로그인, 회원가입 -->
                <ul class="h_sign">
                    <li><a href="sign/sign_in_select.html">로그인</a></li>
                    <li><a href="sign/sign_up_phone.html">회원가입</a></li>
                </ul>
            </section>
        </main>
    </header>



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
                        <button type="button">바로구매</button>
                    </article>
                </article>
            </section>
        </section>

        <section class="b_container">
            <h1>이곳도 블럭</h1>
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