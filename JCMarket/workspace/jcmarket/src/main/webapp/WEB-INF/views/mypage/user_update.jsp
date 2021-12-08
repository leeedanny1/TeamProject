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
    <title>JC마켓 : JC마켓 회원정보수정 </title>

    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/sign/sign.css">
    <link rel="stylesheet" href="../css/sign/sign_up.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
      <script src="/js/mypage/user_update.js" defer></script>
</head>
<body>
    
        <input type = "hidden" class = "create_date" value = "${principal.user.create_date}">
        <main class="sign_container">
        <h1 class="sign_name">JC마켓 회원정보수정</h1>
        <span class="sign_exp">회원정보수정을 진행해 주세요.</span>


        <form class="sign_form">
                 
                <input type="text" name="" class="user_info" id="" value= "${principal.user.user_name}" readonly>
                <input type="text" name="" class="user_info" id="" value="${principal.user.user_phone}" readonly>
                <input type="email" value = "${principal.user.user_id}" class="user_info" readonly>
                  
               
                <input type="password"   class="input"name="id" id="" placeholder="비밀번호">
           
                <input type="password"  id="" class="input" name="id" placeholder="비밀번호 확인">
            
                <section class="check_section">
                    <input type="text" name="" id="" class="input"  value="${principal.user.user_nickname}" placeholder="별명">
                    <button type="button" class="check_btn">별명 중복 확인</button>
                </section>

                <button type="button" class="submit_btn">회원정보수정</button>
                <div class="withdraw_btn_section">
                <button type="button" class="withdraw_btn">회원탈퇴</button>
                </div>
            </form>
    </main>
   
</body>
</html>