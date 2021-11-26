const inputs = document.querySelectorAll('.input');
const submit_btns = document.querySelectorAll('.submit_btn');
const sign_form = document.querySelectorAll('.sign_form');
const check_btns = document.querySelectorAll('.check_btn');
const user_info = document.querySelectorAll('.user_info');

var signUpData = {
    user_id:'',
    user_password: '',
    user_name: '',
    user_phone: '',
    user_nickname:''
 }
var checkNameFormatResult = false;
var checkPhoneFormatResult = false;
var passwordFormatResult = false;
var nicknameFormatResult = false;
var checkIdFormatResult = false;
var checkPhoneResult = 0;
var checkNicknameResult = 0;
var checkPasswordResult = 0;
var checkIdResult = 0;
var testNameValue ='';
var testPasswordValue ='';
var testPhoneValue ='';
var testNickNameValue = '';
var testIdValue = '';
var checkEmptyResult;


//blur input 
inputs.forEach((input, inputIndex) => {
     input.addEventListener('blur', () => checkEmpty(input,inputIndex));
     
});

//click submit_btn
submit_btns.forEach((submitBtn, submitBtnIndex) => {
     submitBtn.addEventListener('click', () => onSubmit(submitBtn,submitBtnIndex));
});

//click check_btn
check_btns.forEach((checkBtn, checkbtnIndex) => {
	 checkBtn.addEventListener('click', () => {
		
		//전화번호 인증버튼 클릭 시 
		if(checkbtnIndex == 0) { 
		checkEmptyResult = checkEmpty(inputs[checkbtnIndex +1], checkbtnIndex+1); 
	      //checkEmptyResult 값이 false가 아니고 (value.length가 0이 아닐때 )
	      //이름형식과 전화번호 형식이 옳을 때만 전화번호 인증 checkPhone함수 호출 
	      //checkEmptyResult 값이 false가 아닐때만 <- 이거 해주지않으면
	      // 전화전호 input값이 0일때에도  checkPhone 함수가 실행된다.(그 결과 '필수항목입니다' 메시지가 묻힘 )
			if(checkEmptyResult != false && checkNameFormatResult == true && checkPhoneFormatResult == true){
			   checkPhone(inputs[checkbtnIndex +1]);
			  
			}
	    //아이디 중복확인 
	    }else if(checkbtnIndex == 1){ 
		       checkEmptyResult =  checkEmpty(inputs[checkbtnIndex +1], checkbtnIndex+1);
		       if(checkEmptyResult != false && checkIdFormatResult == true){
			        checkId(inputs[checkbtnIndex +1]);
		}
		//닉네임 중복확인 
	    }else if(checkbtnIndex == 2) {
		       checkEmptyResult = checkEmpty(inputs[checkbtnIndex +3], checkbtnIndex + 3);
		       if(checkEmptyResult != false && nicknameFormatResult == true) {
			       Checknickname(inputs[checkbtnIndex +3]);
		}
	    }
	});
});





//비어있는지 체크
function checkEmpty(input, inputIndex) {
     
     clearMsg(input);
    if(input.value.length == 0){
        msgService(input, '필수항목입니다.');
        return false;
    }
    //이름 
    if(inputIndex == 0) {
	    checkNameFormatResult = checkNameFormat(input);
	    
    //전화번호 
    }else if(inputIndex == 1) {
	     checkPhoneFormatResult = checkPhoneFormat(input);
	      
	//아이디  
    }else if(inputIndex == 2) {
	      checkIdFormatResult =  CheckIdFormat(input);
	     
    //비밀번호 
    }else if(inputIndex == 3) {
	      passwordFormatResult = checkPasswordFormat(inputs[inputIndex - 1].value, input.value, input);
    //비밀번호 재입력 
    }else if(passwordFormatResult == true && inputIndex == 4) {
	    checkRepassword(inputs[inputIndex - 1].value, input.value, input);
    //닉네임 
    }else if(inputIndex == 5) {
	       nicknameFormatResult = checkNicknameFormat(input);
}
   
}

// 메세지 제거
function clearMsg(input) {
    
    while(input.nextElementSibling.tagName == 'P'){
        input.nextElementSibling.remove();
    
    }
}

//메세지 만들어서 추가
function msgService(input,msgContent) {
    const p =document.createElement('p');
    p.textContent = msgContent;
    p.classList.add('msg');
    input.after(p);
}

//이름 정규식 체크
function checkNameFormat(input) {
	  let reg_name = /^[가-힣]+$/;
	 if(!reg_name.test(input.value)){
	    msgService(input, '이름을 정확히 입력해주세요.');
	    return false;
    }
    clearMsg(input);
     signUpData.user_name = input.value;
    return true;
}

//전화번호 정규식 체크
function checkPhoneFormat(input) {
      if(input.value.length > 11 || input.value.length < 11){
	     msgService(input, '전화번호를 정확히 입력해주세요.');
	     return false;
    }
    clearMsg(input);
    signUpData.user_phone = input.value;
   
    return true;
}

//전화번호 인증
function checkPhone(input) {
	
     $.ajax({
	   type: "post",
	   url: "phone-check",
	   data: JSON.stringify(signUpData),
	   contentType: "application/json;charset=UTF-8",
	   dataType: "text",
	   success: function(data) {
		  clearMsg(input);
	      if(data == 0){
			 msgService(input,  '존재하지 않는 전화번호입니다.');
			  checkPhoneResult = 2;
		  }else if(data == 1) {
			 msgService(input, '사용 가능한 전화번호 입니다.');
			 checkPhoneResult = 1;
			  testNameValue = inputs[data-1].value;
			  testPhoneValue = input.value;
			  
		  }else if(data == 2){
			 msgService(input, `${input.value}은 이미 가입된 전화번호 입니다.`);
			 checkPhoneResult = 2;
	    }
	},
	error: function(){
		alert("오류가발생하였습니다 다시시도해주세요.");
	}
})

}

//아이디 정규식 체크
function CheckIdFormat(input) {
	
      if(!/^[a-z]+[a-z0-9]{5,19}$/g.test(input.value)) {
            msgService(input, '아이디는 6~20자 영문자 또는 숫자이어야 합니다.');
            return false;
        }else {
	        signUpData.user_nickname = input.value;
	        return true;
}
}


//아이디 중복확인 
function  checkId(input) {
	signUpData.user_id = input.value;
     $.ajax({
	    type: "post",
	    url: "/id-check",
	    data: JSON.stringify(signUpData),
	    contentType: "application/json; charset=utf-8",
	    dataType : "text",
		success: function(data) {
			if(data == 1){
				msgService(input,  `${input.value} 은(는) 이미 존재하는 아이디 입니다. `);
				checkIdResult = 2;
			}else if(data == 0) {
				msgService(input,  '사용가능한 아이디 입니다.');
				signUpData.user_id = input.value;
				testIdValue = input.value;
				checkIdResult = 1;
			}
		},
		error: function() {
			alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
})
}

//비밀번호 정규식 체크 
function checkPasswordFormat(id, password, input) {
	
	
	 let check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(password);   //영문,숫자
     let check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/.test(password);  //영문,특수문자 
	 let check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(password);  //특수문자, 숫자
	   
    if(password.length >= 14) {
	  msgService(input, '14자 이내로 입력해주세요. ');
	 return false;
    }
  
    if(!(check1||check2||check3)){
		msgService(input, '사용할 수 없은 조합입니다');
        return false;
	}

	   if(/(\w)\1\1/.test(password)){
        msgService(input, '같은 문자를 3번 이상 사용하실 수 없습니다.');
		return false;

	}
       if(password.search(id)>-1){
	    msgService(input, '비밀번호에 아이디가 포함되었습니다.');
        return false;

	}
	return true;

}
//비밀번호 일치 체크 
function checkRepassword(password, repassword, input) {
	  if(password != repassword) {
		  msgService(input, '비밀번호가 일치하지 않습니다. ');
		  testPasswordValue = input.value;
		  checkPasswordResult = 2;
		  return;
	}else {
		  checkPasswordResult = 1;
		  signUpData.user_password = input.value;
		  return;
	}
  	
}

//닉네임 정규식 체크 
function checkNicknameFormat(input) {
    nickname = input.value;
   
     if(nickname.search(/\s/) != -1){
	  msgService(input, '공백을 포함할 수 없습니다. ');
	  
	  return false;
     }else if(nickname.length < 2 || nickname.length > 13 ||  /[`~!@#$%^&*|\\\'\";,.:\/?]/gi.test(nickname) == true){
	 msgService(input, '2~13이내의 영문과 숫자만 사용 가능합니다. ');
	 checkNicknameResult = 2;
    return false;
}  
     return true;
	 
}

//닉네임 중복확인 
function Checknickname(input) {
	 $.ajax({
		type: "get",
		url: "nickname-check",
		data: {
			signUpNickname : input.value,
		},
		dataType: 'text',
		success: function(data) {
		  if(data == 1) {
			 msgService(input, `${input.value} 는 이미 존재하는 닉네임입니다.`);
			 checkNicknameResult = 2;
		}else if(data == 0) {
			 msgService(input, '사용가능한 닉네임입니다. ');
			 signUpData.user_nickname = input.value;
			 testNickNameValue = input.value;
			 checkNicknameResult = 1;
		}
		   
		},
		error: function() {
				alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
	})
}

//insert
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



//다음 버튼 클릭 시 
function onSubmit(submitBtn,submitBtnIndex) {
  
	if(submitBtnIndex == 0 ) {
		if(checkPhoneResult == 0){
			alert('전화번호 인증을 먼저 진행해주세요!');
		}else if(checkPhoneResult == 1){//전화번호인증에서 다음버튼클릭 때와 전화번호인증 성공 시 
		//전화번호인증 성공 시 값을 지우거나 변경하고 다음버튼을 클릭하면 넘어가는 것을 방지 
       //전화번호 인증 성공시에 성공한 이름과 전화번호 값을 변수에 저장후 다음버튼을 눌렀을때 input값이 변경되었으면 
       //넘어가지 않고 alert창띄우고 checkPhoneResult값을 0으로 변경시킨 후 다시 인증을 진행하도록 유도 
       if(testNameValue != inputs[submitBtnIndex].value || testPhoneValue != inputs[submitBtnIndex + 1].value){
	     checkPhoneResult = 0;
		 alert('값이 변경 되었습니다. 다시 인증을 진행해주세요.  ');
       }else{
	     user_info[submitBtnIndex].value = signUpData.user_name;
	    user_info[submitBtnIndex + 1].value = signUpData.user_phone;
	    sign_form[submitBtnIndex].classList.add('invisible');
        sign_form[submitBtnIndex + 1].classList.add('visible'); 
       } 
	}
  }else if(submitBtnIndex == 1) {

	 if(checkIdResult == 0 || checkNicknameResult == 0) {
		   alert('중복확인을 진행해 주세요!')
    }else if(checkIdResult == 2 || checkNicknameResult == 2){
	      if(testIdValue != inputs[submitBtnIndex + 1].value || testNickNameValue != inputs[submitBtnIndex +4].value){
		       alert(' 다시 인증을 진행해주세요.  ');
	}

	}else if(checkIdResult == 1 || checkNicknameResult == 1) {
		
		 if(testIdValue != inputs[submitBtnIndex + 1].value || testNickNameValue != inputs[submitBtnIndex +4].value){
			 alert('값이 변경 되었습니다. 다시 인증을 진행해주세요.  ');
		}
		 else{
			if(confirm('입력하신 정보로 회원가입을 진행하시겠습니까?')){
			signUp();
		}
    }
	}
} 
 }    

	     