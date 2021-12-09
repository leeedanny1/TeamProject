<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
 	<link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/search/search.css">
     <script src="http://code.jquery.com/jquery-latest.min.js"></script>
     <script src="/js/search/search.js" defer></script>
</head>
<body>
    <jsp:include page="../include/header.jsp"/> 
    
      <main class="wrap main">
       <section class="sale_item">
        <ul class="item_container">
      <c:forEach var = "product" items ="${products }">
        <li class="item_list"  onclick="location.href = '/items/${product.item_code}'">
             <!-- 상품사진 -->
             <img class="item_photo" src="/images/items/items.jpg" alt="상품사진입니다.">
             <!-- 상품이름 -->
             <p class="item_name">${product.item_title }</p>
             <!-- 상품 가격과 올린 시간 -->
             <ul class="item_info">
                 <li><span class="item_price"><strong>${product.item_price }</strong>원</span></li>
                 <li><span class="item_time">${product.update_date }</span></li>
             </ul>
        </li>
       </c:forEach>
         </ul>   
      </section>   
       </main>              
</body>
</html>;