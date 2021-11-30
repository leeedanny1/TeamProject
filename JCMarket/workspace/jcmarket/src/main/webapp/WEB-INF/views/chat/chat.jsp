<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
  
    <link rel="stylesheet" href="/css/chat/chat.css">
</head>
<body>
    <div class="wrap">
    <div class="chat">
        <div class="list">
         	<c:forEach var="chatlist" items="${chatList }">
            		<a href="">
	                    <ul>
	                         <img src="../images/items/items.jpg" alt="상품 사진입니다." class="item_photo">
	                        <li class="notice_title">${product.item_title}</li>
	                    </ul>
	                </a>
            	</c:forEach>
                
        </div>
        <div class="chatting">
            <ul>
                <h2><li class="my">aaa</li></a>
                <h2 ><li class="you">aaa</li></a>
                <h2 class="my"><li>aaa</li></a>
                <h2 class="you"><li>aaa</li></a>
                <h2 class="my"><li>aaa</li></a>
                <h2 class="you"><li>aaa</li></a>
                <h2 class="my"><li>aaa</li></a>
                <h2 class="you"><li>aaa</li></a>     
            </ul>
            <div class="msgbox">
                <textarea class="msginput" value="asdfa"></textarea>
                <button class="submitbtn">전 송</button>
            </div>
        </div>
     
    </div>
</div>
</body>
</html>