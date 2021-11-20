<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
!DOCTYPE html>
<html lang="ko">
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
        <h1 class="sign_name">JC마켓 회원가입</h1>
        <span class="sign_exp">회원가입을 위해 전화번호 인증을 진행 해 주세요.</span>
        <form action="" class="sign_form">
            <input type="text" name="" id="" placeholder="이름" autofocus>
            <p class="e_msg">이름을 입력해 주세요</p>

            <section class="check_section">
                <input type="tel" name="" id="" placeholder="전화번호">
                <button type="button" class="check_btn">전화번호 인증</button>
            </section>
            <p class="e_msg">전화번호를 입력해 주세요</p>
            <p class="s_msg">본인인증 성공</p>

            <button type="button" class="submit_btn" onclick="location.href='sign_up_dtl.html'">다음</button>
        </form>
    </main>
</body>
</html>