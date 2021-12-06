<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>JC톡</title>

<link rel="stylesheet" href="/css/chat/chat.css">
<script src="/js/chat/chat.js" defer></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="chat">
			<div class="list">
				<c:forEach var="chat" items="${chatList }">
					<div class="chatlist_btn">
					<input type="hidden" class="chatinfo" value="${chat.item_code}">
					<input type="hidden" class="chatinfo" value="${chat.buyer_id}">
					<input type="hidden" class="chatinfo" value="${chat.seller_id}">
					<input type="hidden" class="chatinfo" value="${principal.user.id }">
		
						<ul>
							<li class="chat_title"><br>과의 채팅</li>
						</ul>
					</div>
				</c:forEach>
			</div>
			<div class="chatting">
			
				<ul>
					<li>
						<div class="chatmsg">
							<h2 class="my">
								<li>${chatmsg1.chat_content}</li>
								<li><h5 class="nickname">${chatmsg1.writer_nickname }</h5></li>
							</h2>
						</div>
					</li>
						
				</ul>
		
				<div class="msgbox">
					<textarea class="msginput" placeholder="메세지를 입력해주세요"></textarea>
					<button type="button" class="submitbtn">전 송</button>
				</div>
			</div>

		</div>
	</div>
</body>
</html>
