const inputs = document.querySelectorAll('.input');
const submit_btns = document.querySelectorAll('.submit_btn');
const find_form  = document.querySelectorAll('.find_form');
const sign_exp = document.querySelector('.sign_exp');

console.log(find_form[1]);


var userData = {
    user_id:'',
    user_password: '',
    user_name: '',
    user_phone: '',
    user_nickname:''
 }


submit_btns[0].addEventListener('click', () => {
	 //아이디 
	 if(checkEmpty(inputs[0], 0)) {
		checkInputFormat(inputs[0], 0);
	
  }
});

submit_btns[1].addEventListener('click', ()=> {
    //이름 
	if(checkEmpty(inputs[1], 1)) {
		checkNameFormat(inputs[1]);
		return;
	}
	if(nameCheckResult == 1 && phoneCheckResult == 1) {
		findId();
	}else if(nameCheckResult == 1 && phoneCheckResult == 0) {
		alert('전화번호 인증을 진행해주세요. ');
	}
});


//전화번호버튼클릭시 

check_btn.addEventListener('click', () => {
    
	 //전화번호 체크버튼 클릭 시 
	     if(checkEmpty(inputs[1],1)) {
		 //전화번호 체크버튼이고 그 값이 비어있지않고 인증번호가날라왔을 때 
		  if(phoneCheckResult == 1){
			checkAuth(inputs[1]);
			 return;
		 }
		
		 checkPhoneFormat(inputs[1]);
		    
	}
});



//휴대폰 인증번호 일치여부 확인
function checkAuth(input) {
	 console.log(input)
	
	 let authNumber = input.value;
	 if(authCode == authNumber) {
		  alert('인증완료하였습니다. ');
		  
	}else {
		msgService(input, '인증번호가 일치하지 않습니다. ', 0);
	}
}

  
//전화번호 인증
function checkPhone(input) {
	 
	 console.log('checkPhone: ' + input);
     $.ajax({
	   type: "get",
	   url: "phone-check",
	   data: {
		 phoneNumber : input.value
	   },
	   dataType: "text",
	   success: function(data) {
	        authCode= data;
	        userData.user_phone = tempPhoneValue; //checkPhoneFormat에서 tempPhoneValue에 저장해놓은 유저의 전화번호의 값을
		                                        //인증번호가 일치할때만 signUpData.user_phone에 값을 넣어준다. 
		                                       //유저가 입력한 인증번호가 일치하지 않을때에는 넣어주면 안된다.( signUpData.user_phone는 데이터베이스로 넘어가는 값이기 떄문 ) 
	        tempPasswordValue = input.value;
	        phoneCheckResult = 1;
	},
	error: function(){
		phoneCheckResult = 2;
		alert("오류가발생하였습니다 다시시도해주세요.");
	}
})

}




function checkEmpty(input, inputIndex) {
    clearMsg(input);
	if(input.value.length == 0) {
		if(inputIndex == 0) {
		msgService(input, '아이디를 입력해주세요. ', 0);
		}else if(inputIndex == 1){
		msgService(input, '이름를 입력해주세요. ', 0);
		}else if(inputIndex == 2) {
		msgService(input, '전화번호를 입력해주세요. ', 0);
		}
		return false;
	}
	return true;
}

function checkInputFormat(input, inputIndex) {
	if(inputIndex == 0) {
		CheckIdFormat(input);
	}else if(inputIndex == 1) {
		
	}else if(inputIndex == 2){
		
	}
}



//아이디 정규식 체크
function CheckIdFormat(input) {
	
      if(!/^[a-z]+[a-z0-9]{5,15}$/g.test(input.value)) {
            msgService(input, '아이디는 6~20자 영문자 또는 숫자이어야 합니다.', 0);
            return;
        }
        
          userData.user_id = input.value;
	      checkId(input);
	       
}

  

//아이디 중복확인 
function  checkId(input) {
     $.ajax({
	    type: "post",
	    url: "id-check",
	    data: JSON.stringify(userData),
        contentType: "application/json;charset=UTF-8",
        dataType : "text",
		success: function(data) {
			console.log(123)
			if(data == 1){
				find_form[0].classList.add('invisible');
				find_form[1].classList.remove('invisible');
				sign_exp.textContent = '비밀번호 찾기를 위해 이름과 전화번호를 입력해주세요.';
		        
				
			}else if(data == 0) {
				alert('찾고자 하는 아이디가 없습니다.');
			}
		},
		error: function() {
			alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
})
}


//이름 정규식 체크
function checkNameFormat(input) {
	console.log('input.value: ' + input.value);
	  let reg_name = /^[가-힣]+$/;
	 if(!reg_name.test(input.value)){
		checkNameResult = 2;
	    msgService(input, '이름을 정확히 입력해주세요.', 0);
	    return false;
    }
    nameCheckResult = 1;
    userData.user_name = input.value;
    return true;
}



//전화번호 정규식 체크
function checkPhoneFormat(input) {
	
	if(!/^[A-Za-z0-9]{11}$/.test(input.value)) {
	   msgService(input, '전화번호를 정확히 입력해 주세요.' , 0);
	   return;
	 }
	 
	 tempPhoneValue = input.value;  // inputs[0].value = '' 이걸 해주기때문에 input을 넘기면 checkPhone(input)의 input.value는 null이된다.
	 checkPhone(input);             //그래서 보내기전에 미리 tempPhoneValue안에 유저의 전화번호를 저장해둔다 .
	 inputs[1].value = '';
	 inputs[1].focus();
	 inputs[1].placeholder = '인증번호를 입력해 주세요. ';
	 check_btn.textContent = '인증확인 ';
	
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