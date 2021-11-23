<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JC마켓</title>

    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/include/include.css">
    <link rel="stylesheet" href="css/index.css">
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
            <c:choose>
             <c:if test="">
                <ul class="h_sign">
                    <li><a href="sign/sign_in_select.html">로그인</a></li>
                    <li><a href="sign/sign_up_phone.html">회원가입</a></li>
                </ul>
                </c:if>
               <c:otherwise>
                    <li><a href=""></a></li>
               </c:otherwise>
           </c:choose>
            </section>
        </main>
    </header>



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
            <h2 class="section_name">인기상품</h2>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container">
                <!-- 아이템들 -->
                <li class="item_list">
                    <!-- 상품사진 -->
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <!-- 상품이름 -->
                    <p class="item_name">상품 이름입니다. 긴 이름도 입력이 됩니다.</p>
                    <!-- 상품 가격과 올린 시간 -->
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
            </ul>
        </section>

        <!-- 최근상품 -->
        <section class="sale_item">
            <h2 class="section_name">최근상품</h2>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container">
                <!-- 아이템들 -->
                <li class="item_list">
                    <!-- 상품사진 -->
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <!-- 상품이름 -->
                    <p class="item_name">상품 이름입니다.</p>
                    <!-- 상품 가격과 올린 시간 -->
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
                <li class="item_list">
                    <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
                    <p class="item_name">상품 이름입니다.</p>
                    <ul class="item_info">
                        <li><span class="item_price"><strong>1,000,000</strong>원</span></li>
                        <li><span class="item_time">1시간 전</span></li>
                    </ul>
                </li>
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
    


    <!-- fontawesome CDN -->
    <script src="https://kit.fontawesome.com/85db88a229.js" crossorigin="anonymous"></script>
</body>
</html>