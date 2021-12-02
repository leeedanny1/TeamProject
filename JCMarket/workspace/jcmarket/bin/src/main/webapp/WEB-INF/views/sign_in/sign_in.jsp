<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JC마켓 : JC마켓 계정로그인</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/sign/sign.css">
    <script src="/js/sign_in/sign_in.js" defer></script>
</head>
<body>
	<form action="/sign-in" method="post">
     <main class="sign_container">
        <h1 class="sign_name">JC마켓 로그인</h1>
        <div action="" class="sign_form">
            <input type="text" class="item_ip" name="user_id" id="user_id" placeholder="ID"  autofocus>

            <p class="e_msg">아이디를 입력해 주세요</p>

            <input type="password"class="item_ip" name="user_password" id="user_password" placeholder="PASSWORD">
            <p class="e_msg">비밀번호를 입력해 주세요</p>

            <button type="submit" class="submit_btn">로그인</button>
            </form>
        </div>
    </main>
 
</body>
</html>