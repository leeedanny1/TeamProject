<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JC마켓 : JC마켓 회원정보수</title>

    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/sign/sign.css">
    <link rel="stylesheet" href="../css/sign/sign_up.css">
    <script src="../js/mypage/user_update.js" defer></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
    

        <main class="sign_container">
        <h1 class="sign_name">JC마켓 회원정보수정</h1>
        <span class="sign_exp">회원정보수정을 진행해 주세요.</span>


        <form class="sign_form">
                
           
                <input type="text" name="" class="user_info" id="" value="전보석" readonly>
                <input type="text" name="" class="user_info" id="" value="01000000000"  readonly>
                <input type="email" value = "seokbo" class="user_info" readonly>
                  
               
                <input type="password"   class="input"name="id" id="" placeholder="비밀번호">
           
                <input type="password"  id="" class="input" name="id" placeholder="비밀번호 확인">
            
                <section class="check_section">
                    <input type="text" name="" id="" class="input"  placeholder="별명">
                    <button type="button" class="check_btn">별명 중복 확인</button>
                </section>

                <button type="button" class="submit_btn">회원정보수정</button>
            </form>
    </main>
</body>
</html>