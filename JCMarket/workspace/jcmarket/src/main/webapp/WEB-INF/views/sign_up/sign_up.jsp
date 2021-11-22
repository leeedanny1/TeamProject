<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JC마켓 : JC마켓 회원가입</title>

    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/sign/sign.css">
    <link rel="stylesheet" href="css/sign/sign_up.css">
    <script src="js/sign_up.js" defer></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    


    <main class="sign_container">
        <h1 class="sign_name">JC마켓 회원가입</h1>
        <span class="sign_exp">회원가입을 위해 전화번호 인증을 진행 해 주세요</span>


        <div class="sign_form">
            <input type="text" name="" class="input" id="" placeholder="이름" autofocus>
           
            <section class="check_section">
                <input type="tel" name="" class="input" id="" placeholder="전화번호">
                <button type="button" class="check_btn">전화번호 인증</button>
            </section>
            <button type="button" class="submit_btn disabled">다음</button>
        </div>


        <div class="sign_form  invisible">
            <input type="text" name=""  class= "user_info" id="" value="" readonly>
            <section class="check_section">
                <input type="email" class="input" name="" id="" placeholder="아이디" autofocus>
                <button type="button" class="check_btn">아이디 중복 확인</button>
            </section>
           

            <input type="password" name="" class="input" id="" placeholder="비밀번호">
           
            <input type="password" name="" id="" class="input" placeholder="비밀번호 확인">
          
            <input type="text" name="" class= "user_info" id="" value="" readonly>

            <section class="check_section">
                <input type="text" name="" id="" class="input" placeholder="별명">
                <button type="button" class="check_btn">별명 중복 확인</button>
            </section>
           

            <button type="button" class="submit_btn disabled">회원가입</button>
        </div>
    </main>
</body>
</html>