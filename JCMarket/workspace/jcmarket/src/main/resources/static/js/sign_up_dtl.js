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
    phone_flag: 0,
    user_nickname:'',
    
}
 var checkNameFormatResult = false;
 var checkPhoneFormatResult = false;
 var passwordFormatResult = false;
 var nicknameFormatResult = false;

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
			checkEmpty(inputs[checkbtnIndex +1], checkbtnIndex+1);
			if(checkNameFormatResult == true && checkPhoneFormatResult == true){
				checkPhone(inputs[checkbtnIndex +1]);
			}
	    //아이디 중복확인 
	    }else if(checkbtnIndex == 1){ 
		      checkEmpty(inputs[checkbtnIndex +1], checkbtnIndex+1);
		//닉네임 중복확인 
	    }else if(checkbtnIndex == 2) {
		       checkEmpty(inputs[checkbtnIndex +3], checkbtnIndex + 3);
		       if(nicknameFormatResult == true) {
			       nicknameCheck(inputs[checkbtnIndex +3]);
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
	       checkId(input);
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
    console.log(input)
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
		   signUpData = JSON.parse(data);
	      clearMsg(input);
	      if(signUpData.phone_flag == 0){
			 msgService(input,  '존재하지 않는 전화번호입니다.');
		  }else if(signUpData.phone_flag == 1) {
			 msgService(input, '사용 가능한 전화번호 입니다.');
			 activeSubmitBtn(submit_btns[signUpData.phone_flag-1]);
		  }else if(signUpData.phone_flag == 2){
			 msgService(input, `${signUpData.user_phone}은 이미 가입된 전화번호 입니다.`);
	    }
	},
	error: function(){
		alert("오류가발생하였습니다 다시시도해주세요.");
	}
})

}

//아이디 중복확인 
function  checkId(input) {
     $.ajax({
	    type: "get",
	    url: "id-check",
	    data: {
		  signUpId : input.value
		},
		dataType : "text",
		success: function(data) {
			if(data == 1){
				msgService(input,  `${input.value} 는 이미 존재하는 아이디 입니다. `);
			}else if(data == 0) {
				msgService(input,  '사용가능한 아이디 입니다.');
				
			}
		},
		error: function() {
			alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
})
}

function checkPasswordFormat(id, password, input) {
	console.log(id);
	console.log(password.length);
	console.log(input);
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

function checkRepassword(password, repassword, input) {
	  if(password != repassword) {
		  msgService(input, '비밀번호가 일치하지 않습니다. ');
		  return false;
	}
  	
}

function checkNicknameFormat(input) {
    nickname = input.value;
   
     if(nickname.search(/\s/) != -1){
	  msgService(input, '공백을 포함할 수 없습니다. ');
      return false;
     }else if(nickname.length < 2 || nickname.length > 13 ||  /[`~!@#$%^&*|\\\'\";,.:\/?]/gi.test(nickname) == true){
	 msgService(input, '2~13이내의 영문과 숫자만 사용 가능합니다. ');
	 return false;
}  
     return true;
	 
}

function nicknameCheck(input) {
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
		}else if(data == 0) {
			 msgService(input, '사용가능한 닉네임입니다. ');
			 signUpData.user_nickname = input.value;
		}
		   
		},
		error: function() {
				alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
	})
}



function activeSubmitBtn(submitBtn) {
	submitBtn.classList.remove('disabled');
}
function nextService(input, submitBtn) {
	 //input 값이 변경될때 phone_flag값을 0으로 바꿔서 다시 인증하도록 
     //인증 후 값을 지우거나 변경시 다음버튼눌렀을때 넘어가는 경우를 방지
	 if(signUpData.phone_flag == 1){
	  input.addEventListener('change', () => {
		signUpData.phone_flag = 0;
	     submitBtn.classList.add('disabled');
	    console.log('change: ' + signUpData.phone_flag);
	});
	}
}


//submit
function onSubmit(submitBtn,submitBtnIndex) {
	inputs.forEach((input) => {
		nextService(input, submitBtn);
    });
     if(submitBtnIndex == 0){
	    user_info[submitBtnIndex].value = signUpData.user_name;
	    user_info[submitBtnIndex + 1].value = signUpData.user_phone;
	    sign_form[submitBtnIndex].classList.add('invisible');
        sign_form[submitBtnIndex + 1].classList.add('visible');
    }else if(submitBtnIndex == 1)  {
	    
}
     
	  
        
}
	     