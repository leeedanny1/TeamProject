const inputs = document.querySelectorAll('.input');
const check_btns = document.querySelectorAll('.check_btn');
const submit_btn = document.querySelector('.submit_btn');
const user_info = document.querySelectorAll('.user_info');
var signUpData = {
    user_id:'',
    user_password: '',
    user_name: '',
    user_phone: '',
    user_nickname:''
 }

var phoneCheckResult = 0;
var checkNicknameResult = 0;
var tempNickNameValue = '';
var checkEmptyResult = false;
var tempPhoneValue='';
var authCode= "";
inputs.forEach((input, inputIndex) => {
	input.addEventListener('blur', () => {
		checkEmpty(input, inputIndex);
	});
});


check_btns.forEach((check_btn, checkIndex) => {

	check_btn.addEventListener('click', () => {
			
	 //전화번호 체크버튼 클릭 시 
	 if(checkIndex == 0) {
	    if(checkEmpty(inputs[checkIndex],checkIndex)) {
		 //전화번호 체크버튼이고 그 값이 비어있지않고 인증번호가날라왔을 때 
		  if(phoneCheckResult == 1){
			checkAuth(inputs[checkIndex]);
			 return;
		 }
		 checkPhoneFormat(inputs[0]);
		    
	}
	  
	 //별명 중복확인 버튼 클릭 시 
	}else if (checkIndex == 1) {
			if (checkEmpty(inputs[checkIndex], checkIndex)) {
				checkNicknameFormat(inputs[checkIndex]);
			}
		}
	
});
});

//전화번호 인증
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
	        signUpData.user_phone = tempPhoneValue;
	        phoneCheckResult = 1;
	},
	error: function(){
		phoneCheckResult = 2;
		alert("오류가발생하였습니다 다시시도해주세요.");
	}
})

}


function checkAuth(input) {
	console.log(input)

	let authNumber = input.value;
	if (authCode == authNumber) {
		alert('인증완료하였습니다. ');
	} else {
		msgService(input, '인증번호가 일치하지 않습니다. ', 0);
	}
}

//전화번호 정규식 체크
function checkPhoneFormat(input) {

	if (!/^[A-Za-z0-9]{11}$/.test(input.value)) {
		msgService(input, '전화번호를 정확히 입력해 주세요.', 0);
		return;
	}
	tempPhoneValue=input.value;
	checkPhone(input);
	inputs[0].value = '';
	inputs[0].focus();
	inputs[0].placeholder = '인증번호를 입력해 주세요. ';
	check_btns[0].textContent = '인증확인 '
}
function checkEmpty(input, checkIndex) {
	console.log('input: ' + input)
	clearMsg(input);

	if (input.value.length == 0) {
		if (checkIndex == 0) {
			//전화번호 날리고 인증번호 입력을 받을 때 
			if (phoneCheckResult == 1) {
				msgService(input, '인증번호를 입력해주세요. ', 0);
				return;
			}
			msgService(input, '전화번호를 입력해주세요. ', 0);
		} else if (checkIndex == 1) {
			checkNicknameResult = 0;
			msgService(input, '닉네임을 입력해주세요. ', 0);

		}
		
		return false;
	}

	return true;
}

submit_btn.onclick=(input)=>{
	socailupdate(input);
	alert(input);
}
//닉네임 정규식 체크 
function checkNicknameFormat(input) {
	nickname = input.value;

	if (nickname.search(/\s/) != -1) {
		msgService(input, '공백을 포함할 수 없습니다. ');

		return false;
	} else if (nickname.length < 2 || nickname.length > 13) {
		msgService(input, '2~13이내로 사용가능합니다. ');

		return false;
	} else if (/[`~!@#$%^&*|\\\'\";:\/?]/gi.test(nickname)) {
		msgService(input, '특수문자는 사용하실수없습니다. ', 0);
		return false;
	}
	checkNickname(input);
	return true;
}
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

	while (input.nextElementSibling.tagName == 'P') {
		input.nextElementSibling.remove();
	}
}


//메세지 만들어서 추가
function msgService(input, msgContent, msgIndex) {
	const p = document.createElement('p');
	p.textContent = msgContent;
	//에러메시지 
	if (msgIndex == 0) {
		p.classList.add('error_msg');
		//성공메시지 
	} else if (msgIndex == 1) {
		p.classList.add('success_msg');
	}
	input.after(p);
}
function socailupdate(input) {
     $.ajax({
	   type: "put",
	   url: "social-sign-update",
	   data: JSON.stringify(signUpData),
		contentType: "application/json;charset=UTF-8",
	 	 dataType: "text",
	   success: function(data) {
	       alert('회원수정을 완료하였습니다.  ');
				location.replace('index');
	},
	error: function(){
		phoneCheckResult = 2;
		alert("오류가발생하였습니다 다시시도해주세요.");
	}
})

}
