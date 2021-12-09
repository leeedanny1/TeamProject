<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
</sec:authorize>    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/myshop/my_shop.css">
    <link rel="stylesheet" href="/css/include/footer.css">
</head>
<body>
      	<jsp:include page="../include/header.jsp"/> 


      <div class="myshop_container">
       <section class="my_info">
          <article class="name">
            <span>이름: </span>
            <span>${principal.user.user_name}</span>
           </article>
           <article class="phone">
            <span>전화번호: </span>
            <span>${principal.user.user_phone}</span>
           </article> 
            <article class="id">
            <span>아이디: </span>
            <span>${principal.user.user_id}</span>
           </article>
            <article class="nickname">
            <span>닉네임: </span>
            <span>${principal.user.user_nickname}</span>
           </article>
       
        </section>
        <section class="sale_item">
            <a href="/product/hot_product.html"><h2 class="section_name">판매 중인 상품</h2></a>
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


        <section class="sale_item">
            <a href="/product/hot_product.html"><h2 class="section_name">내가 찜한 상품</h2></a>
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
<jsp:include page="../include/footer.jsp"/> 

     </div>
</body>
</html>