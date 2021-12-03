<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
     <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body>
    <!-- header -->
	<jsp:include page="../include/header.jsp"/> 

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
            <a href="/items/hot"><h2 class="section_name">인기상품</h2></a>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container">
                <c:forEach var="notice" items="${noticeList }" class="item_container">
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
            	</c:forEach>
            </ul>
        </section>

        <!-- 최근상품 -->
        <section class="sale_item">
            <a href="/items/new"><h2 class="section_name">최근상품</h2></a>
            <!-- 개별 아이템 박스컨테이너 -->
            <ul class="item_container">
                <c:forEach var="notice" items="${noticeList }" class="item_container">
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
            	</c:forEach>
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
    <script type="text/javascript" src="/js/index/index.js"></script>
    <script src="https://kit.fontawesome.com/85db88a229.js" crossorigin="anonymous"></script>
   
</body>


</html>