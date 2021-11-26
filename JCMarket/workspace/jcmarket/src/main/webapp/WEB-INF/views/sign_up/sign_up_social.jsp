<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JC마켓 : JC마켓 회원가입</title>

<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/sign/sign.css">
<link rel="stylesheet" href="../css/sign/sign_up.css">

</head>
<body>
	<main class="sign_container">
		<h1 class="sign_name">구글로 JC마켓 회원가입</h1>
		<span class="sign_exp">회원가입을 위해 상세 정보를 입력 해 주세요</span>
		<form action="" class="sign_form">
			<input type="text" name="" id="" value="${principal.user.user_name} " readonly>
			<input type="text" name="" id="" value="${principal.user.user_id}" readonly>
			 <input type="text" name="" id="" value="소셜계정 전화번호" readonly>

			<section class="check_section">
				<input type="text" name="" id="" placeholder="별명">
				<button type="button" class="check_btn">별명 중복 확인</button>
			</section>
			<p class="e_msg">별명을 입력해 주세요</p>
			<p class="e_msg">별명 중복확인을 진행해 주세요</p>

			<button type="submit" class="submit_btn">회원가입</button>
		</form>
	</main>
</body>
</html>