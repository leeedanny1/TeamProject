<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>

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
					<i class="far fa-times-circle" id="exit"></i>
					<div class="chatlist_btn">
						<input type="hidden" class="chatinfo" value="${chat.item_code}">
						<input type="hidden" class="chatinfo" value="${chat.buyer_id}">
						<input type="hidden" class="chatinfo" value="${chat.seller_id}">
						<input type="hidden" class="chatinfo" value="${principal.user.id }">
						<ul>
							<c:if test="${principal.user.user_nickname eq chat.buyer_nickname}">
								<li class="chat_title">
									<br>${chat.seller_nickname}님<br>과의 대화방
								</li>
							</c:if>
							<c:if test="${principal.user.user_nickname eq chat.seller_nickname}">
								<li class="chat_title"><br>${chat.buyer_nickname}님<br>과의 대화방</li>
							</c:if>
						</ul>
					</div>
					<div class="none">
						<div class="msgbox">
							<textarea class="msginput" placeholder="메세지를 입력해주세요"></textarea>
							<button type="button" class="submitbtn">전 송</button>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="chatting">

				<ul>
					<li>
						<div class="chatmsg">
							<h2 class="my">
					<li>${chatmsg1.chat_content}</li>
					<li>
						<h5 class="nickname">${chatmsg1.writer_nickname }</h5>
					</li>
					</h2>
			</div>
			</li>

			</ul>


		</div>

	</div>
	</div>
	<script src="https://kit.fontawesome.com/85db88a229.js" crossorigin="anonymous"></script>
</body>

</html>