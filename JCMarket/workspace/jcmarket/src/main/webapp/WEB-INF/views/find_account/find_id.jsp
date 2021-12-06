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
    <link rel="stylesheet" href="/css/sign/sign_up.css">
    <script src="/js/find_account/find_id.js" defer></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style type="text/css">
      .sign_container{
        height: 500px;
        }
        h1{
        font-size: 1.2rem;
      }
     
    </style>
</head>
<body>

 <main class="sign_container">
         <h1 class="sign_name">JC마켓 아이디 찾기</h1>
        <span class="sign_exp">아이디 찾기를 위해 이름과 전화번호를 입력해주세요. </span>
        
   <div class="sign_form phone_check find_form">
          <input type="tel" class="input" placeholder="이름을 입력해주세요.">
          <section class="check_section">
               <input type="tel" class="input" id="" placeholder="'-'을 빼고 입력해주세요. ">
                <button type="button" class="check_btn">전화번호 인증</button>
              
            </section>
         <button type="button"  class="submit_btn">다음</button>   
        </div> 
        
    <div class="sign_form find_form invisible">
        
          <section class="check_section ">
               <h1 class="find_id_mag"></h1>
               <h4 class= "create_date"></h4>
            </section>
       
        </div>   
         
    </main>
</body>
</html>