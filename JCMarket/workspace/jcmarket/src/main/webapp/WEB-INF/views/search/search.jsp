<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 	<link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/include/include.css">
    <link rel="stylesheet" href="/css/index.css">
     <script src="http://code.jquery.com/jquery-latest.min.js"></script>
     <script src="/js/search/search.js" defer></script>
</head>
<body>
    <jsp:include page="../include/header.jsp"/> 
    
     <input type = "hidden"  class= "update_date" value = ">${products.update_date }">
      <main class="wrap main">
      <section class="sale_item">
      <ul class="item_container">
            <li class="item_list">
             <!-- 상품사진 -->
             <img class="item_photo" src="images/items/items.jpg" alt="상품사진입니다.">
             <!-- 상품이름 -->
             <p class="item_name">${products.item_title }</p>
             <!-- 상품 가격과 올린 시간 -->
             <ul class="item_info">
                 <li><span class="item_price"><strong>${products.item_price }</strong>원</span></li>
                 <li><span class="item_time"></span></li>
             </ul>
      </section>   
       </main>              
</body>
</html>