<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="stylesheet" href="/css/chat/chat.css">
<script src="/js/chat/chat.js" defer></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="chat">
			<div class="list">
				<c:forEach var="chat" items="${chatList }">
					<a class="chatlist_btn" href="/chatting/${chat.item_code }/${chat.buyer_id}/${chat.seller_id}">
						<ul>
							<li class="chat_title"><br>과의 채팅</li>
						</ul>
					</a>
				</c:forEach>
			</div>
			<div class="chatting">
			
				<ul>
				<c:forEach var="chatmsg1" items="${chatmsg }">
		
					<li>
						<div class="chatmsg">
							<h2 class="my">
								<li>${chatmsg1.chat_content}</li>
								<li><h5 class="nickname">${chatmsg1.writer_nickname }</h5></li>
							</h2>
						</div>
					</li>
					
					</c:forEach>
				</ul>
				<form id="chatting">
				<div class="msgbox">
					<textarea class="msginput"placeholder="메세지를 입력해주세요"></textarea>
					<button type="submit" class="submitbtn">전 송</button>
					
				</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>