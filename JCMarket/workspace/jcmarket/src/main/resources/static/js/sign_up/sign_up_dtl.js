const inputs =document.querySelectorAll('.input');
const check_btns = document.querySelectorAll('.check_btn');
const sign_form = document.querySelectorAll('.sign_form');
const user_info = document.querySelector('.user_info');
const submit_btn = document.querySelector('.submit_btn');

user_info.value = '01034012679';

var signUpData = {
    user_id:'',
    user_password: '',
    user_name: '',
    user_phone: '',
    user_nickname:''
 }

var authCode= "";
var phoneCheckResult = 0; 
var idCheckResult = 0;
var passwordCheckResult = 0;
var  checkNicknameResult = 0;
var tempIdValue = ''; 
var tempNickNameValue= '';
var tempPasswordValue = '';
var checkEmptyResult = false;

//blur될때는 빈값체크만, password는 정규식검사와 일치여부 체크 까지 
//input blur될때 빈값체크, password일치여부 체크 
inputs.forEach((input, inputIndex) => {
	input.addEventListener('blur', () => {
		checkEmpty(input,inputIndex);
		checkPasswordService(input, inputIndex);
	});
});




//중복확인 버튼클릭시 
check_btns.forEach((check_btn, checkIndex) => {

	check_btn.addEventListener('click', () => {
			
	 //전화번호 체크버튼 클릭 시 
	 if(checkIndex == 0) {
	    if(checkEmpty(inputs[checkIndex],checkIndex)) {
		 //전화번호 체크버튼이고 그 값이 비어있지않고 인증번호가날라왔을 때 
		  if(phoneCheckResult == 1){
			checkAuth(inputs[checkIndex - 1]);
			 return;
		 }
		 checkPhoneFormat(inputs[0]);
		    
	}
	  
	 //아이디 중복확인 버튼 클릭 시 
	}else if(checkIndex == 1){
		 if(checkEmpty(inputs[checkIndex], checkIndex)) {
			CheckIdFormat(inputs[checkIndex]);
		}
	}
	//별명중복확인 버튼 클릭 시 
    else if(checkIndex == 2){
	     if(checkEmpty(inputs[checkIndex +2], checkIndex +2)) {
		  checkNicknameFormat(inputs[checkIndex + 2]);
	}
}
});
});


//다음버튼,회원가입 버튼클릭 시 
submit_btn.addEventListener('click', ()=> {
	inputs.forEach((input, inputIndex) => {
	   	checkEmpty(input, inputIndex);
	   	checkPasswordService(input, inputIndex);
	   	
	});
	//중복확인 안하거나 틀렸을때 
	
    if(idCheckResult == 0 || idCheckResult == 2) {
	   if(inputs[1].value.length != 0) {
		 alert('아이디 중복확인을 진행해주세요. ');
	}
	} else if(checkNicknameResult == 0 || checkNicknameResult == 2){
		if(inputs[4].value.length != 0) {
			checkNicknameResult = 2;
			alert('닉네임 중복확인을 진행해주세요. ');
		}
	//중복확인 했을 때 
	}else if(idCheckResult == 1 || checkNicknameResult == 1 || passwordCheckResult == 1) {
		 if(tempIdValue != inputs[1].value) {
			idCheckResult = 2;
			alert('아이디 값이 변경되었습니다 다시 인증을 해주세요.');
		}else if(tempNickNameValue != inputs[4].value) {
		   checkNicknameResult = 2;
		   alert('닉네임 값이 변경 되었습니다 다시 인증을 해주세요. ');
	
	}
	}
	if(idCheckResult == 1 && checkNicknameResult == 1 && passwordCheckResult == 1){
			if(confirm('입력하신 정보로 회원가입을 진행하시겠습니까? ')){
			  signUp();
			
	}
	}
	
});


//회원가입 
function signUp() {
	 $.ajax({
		type: "post",
		url: "sign-up",
		data: JSON.stringify(signUpData),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			 if(data == 0) {
				 if(confirm('회원가입에 실패하였습니다. 다시시도하시겠습니까?')){
					location.href = 'sign-up';
				}
			}else if(data == 1) {
				alert('jc마켓의 회원이 되셨습니다!!');
			    location.replace('index');
			}
		},
		error: function() {
			alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
		
	})
}

//빈값 체크 
function checkEmpty(input, checkIndex) {
	console.log('input: ' + checkIndex)
	  clearMsg(input);
	
    if(input.value.length == 0 ){
			if(checkIndex == 0){
				//전화번호 날리고 인증번호 입력을 받을 때 
				if(phoneCheckResult == 1) {
				msgService(input, '인증번호를 입력해주세요. ', 0);
				return;
				}
			msgService(input, '전화번호를 입력해주세요. ', 0);
			}else if(checkIndex == 1){
				idCheckResult = 0;
				msgService(input, '아이디를 입력해주세요. ', 0);	
				
			}else if(checkIndex == 2 || checkIndex == 3) {
				msgService(input, '비밀번호를 입력해주세요. ', 0);	
			}else if(checkIndex == 4) {
				checkNicknameResult = 0;
				msgService(input, '닉네임을 입력해주세요. ', 0);
				
		   }
		return false;
	}
	
	 return true;
	}
	

//비밀번호 일치여부 확인하기전의 검사 
function checkPasswordService(input, inputIndex) {
	
	  checkEmptyResult = checkEmpty(input,inputIndex);
		 if(checkEmptyResult == true){
			if(inputIndex == 2) {
				if(!checkPasswordFormat(inputs[inputIndex -1].value, input.value, input)){
					passwordCheckResult = 2; //비밀번호 형식이 맞지 않으면 2  
				}else {
					passwordCheckResult = 1; //형식이 맞으면 다시 1을 넣어줌 
				}
			}else if(inputIndex == 3) {
				checkRepassword(inputs[inputIndex -1].value, input.value, input);
			}
		} 
}


//비밀번호 일치 체크 
function checkRepassword(password, repassword, input) {
	 
	  if(password != repassword) {
		 passwordCheckResult = 2;
		  msgService(input, '비밀번호가 일치하지 않습니다. ', 0);
		  testPasswordValue = input.value;
		 
		  return;
	}else {
		  passwordCheckResult = 1;
		  signUpData.user_password = input.value;
		  return;
	}
  	
}


//전화번호 정규식 체크
function checkPhoneFormat(input) {
	
	if(!/^[A-Za-z0-9]{11}$/.test(input.value)) {
	   msgService(input, '전화번호를 정확히 입력해 주세요.' , 0);
	   return;
	 }
	 checkPhone(input);
	 inputs[0].value = '';
	 inputs[0].focus();
	 inputs[0].placeholder = '인증번호를 입력해 주세요. ';
	 check_btns[0].textContent = '인증확인 '
	
}

//아이디 정규식 체크
function CheckIdFormat(input) {
	
      if(!/^[a-z]+[a-z0-9]{5,19}$/g.test(input.value)) {
            msgService(input, '아이디는 6~20자 영문자 또는 숫자이어야 합니다.', 0);
            return;
        }else {
	        checkId(input);
	        return true;
}
}
  

//비밀번호 정규식 체크 
function checkPasswordFormat(id, password, input) {
	
	 let check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(password);   //영문,숫자
     let check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/.test(password);  //영문,특수문자 
	 let check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(password);  //특수문자, 숫자
	   
    if(password.length >= 14) {
	  msgService(input, '14자 이내로 입력해주세요. ', 0);
	 return false;
    }
  
    if(!(check1||check2||check3)){
		msgService(input, '사용할 수 없는 조합입니다', 0);
        return false;
	}

	   if(/(\w)\1\1/.test(password)){
        msgService(input, '같은 문자를 3번 이상 사용하실 수 없습니다.', 0);
		return false;

	}
	 if(id.length != 0 ){
       if(password.search(id)>-1){
	    msgService(input, '비밀번호에 아이디가 포함되었습니다.', 0);
        return false;
	}
	}
	return true;

}
  

//닉네임 정규식 체크 
function checkNicknameFormat(input) {
    nickname = input.value;
   
     if(nickname.search(/\s/) != -1){
	  msgService(input, '공백을 포함할 수 없습니다. ');
	 
	  return false;
     }else if(nickname.length < 2 || nickname.length > 13 ||  /[`~!@#$%^&*|\\\'\";,.:\/?]/gi.test(nickname) == true){
	  msgService(input, '2~13이내의 영문과 숫자만 사용 가능합니다. ');
	 
      return false;
}  
     checkNickname(input);
     return true;
}


//휴대폰 인증번호 일치여부 확인
function checkAuth(input) {
	
	console.log('checkAuth: ' +  signUpData.user_phone)
	 let authNumber = input.value;
	 if(authCode == authNumber) {
		  alert('인증완료하였습니다. ');
		 user_info.value = signUpData.user_phone;
		  sign_form[0].classList.add('invisible');
	      sign_form[1].classList.remove('invisible');
	}else {
		msgService(input, '인증번호가 일치하지 않습니다. ', 0);
	}
}

  
//전화번호 인증
function checkPhone(input) {
	 
	 console.log('checkPhone: ' + input.value)
     $.ajax({
	   type: "get",
	   url: "phone-check",
	   data: {
		 phoneNumber : input.value
	   },
	   dataType: "text",
	   success: function(data) {
	        authCode= data;
	        tempPasswordValue = input.value;
	        signUpData.user_phone = input.value;
	        phoneCheckResult = 1;
	},
	error: function(){
		phoneCheckResult = 2;
		alert("오류가발생하였습니다 다시시도해주세요.");
	}
})

}

//아이디 중복확인 
function  checkId(input) {
     $.ajax({
	    type: "post",
	    url: "id-check",
	    data: JSON.stringify(signUpData),
        contentType: "application/json;charset=UTF-8",
        dataType : "text",
		success: function(data) {
			if(data == 1){
				msgService(input,  `${input.value} 은(는) 이미 존재하는 아이디 입니다. `, 0);
				idCheckResult = 2;
			}else if(data == 0) {
				msgService(input,  '사용가능한 아이디 입니다.', 1);
				signUpData.user_id = input.value;
				tempIdValue = input.value;
				idCheckResult = 1;
			}
		},
		error: function() {
			alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
})
}

//닉네임 중복확인 
function checkNickname(input) {
	 $.ajax({
		type: "get",
		url: "nickname-check",
		data: {
			signUpNickname : input.value,
		},
		dataType: 'text',
		success: function(data) {
		  if(data == 1) {
			 msgService(input, `${input.value} 는 이미 존재하는 닉네임입니다.`, 0);
			 checkNicknameResult = 2;
		}else if(data == 0) {
			 msgService(input, '사용가능한 닉네임입니다. ', 1);
			 signUpData.user_nickname = input.value;
			 tempNickNameValue = input.value;
			 checkNicknameResult = 1;
		}
		   
		},
		error: function() {
				alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
	})
}

   

// 메세지 제거
function clearMsg(input) {
    
    while(input.nextElementSibling.tagName == 'P'){
        input.nextElementSibling.remove();
    }
}


//메세지 만들어서 추가
function msgService(input,msgContent, msgIndex) {
	const p =document.createElement('p');
    p.textContent = msgContent;
    //에러메시지 
	if(msgIndex == 0) {
	    p.classList.add('error_msg');
	//성공메시지 
	}else if(msgIndex == 1) {
		p.classList.add('success_msg');
	}
    input.after(p);
}