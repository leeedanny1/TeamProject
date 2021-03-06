<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JC마켓 : 로그인</title>

    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/sign/sign.css">
    <link rel="stylesheet" href="/css/sign/sign_in_select.css">
</head>

<body>
    <main class="sign_container">
        <h1 class="login_name">JC마켓 로그인</h1>
        <p>로그인 수단을 선택해 주세요</p>
        <section class="login_option">
            <button onclick="location.href= '/oauth2/authorization/google'">구글 계정으로 로그인</article>
                <button onclick="location.href= '/oauth2/authorization/naver'">네이버 계정으로 로그인</button>
                <button onclick="location.href='/sign-in'">JC마켓 계정으로 로그인</button>
        </section>
    </main>
</body>

</html>