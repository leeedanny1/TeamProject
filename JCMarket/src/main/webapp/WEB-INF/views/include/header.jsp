<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
</body>
</html>