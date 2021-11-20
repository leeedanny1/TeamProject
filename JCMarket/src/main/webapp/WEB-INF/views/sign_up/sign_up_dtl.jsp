<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <span class="sign_exp">회원가입을 위해 상세 정보를 입력 해 주세요</span>
        <form action="" class="sign_form">
            <input type="text" name="" id="" value="인증받은 이름" readonly>
            <section class="check_section">
                <input type="email" name="" id="" placeholder="아이디" autofocus>
                <button type="button" class="check_btn">아이디 중복 확인</button>
            </section>
            <p class="e_msg">아이디를 입력해 주세요</p>
            <p class="e_msg">아이디 중복확인을 진행해 주세요</p>

            <input type="password" name="" id="" placeholder="비밀번호">
            <p class="e_msg">비밀번호를 입력해 주세요</p>
            <p class="e_msg">비밀번호에 아이디는 포함될 수 없습니다.</p>
            <input type="password" name="" id="" placeholder="비밀번호 확인">
            <p class="e_msg">비밀번호가 일치하지 않습니다.</p>

            <input type="text" name="" id="" value="인증받은 전화번호" readonly>

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