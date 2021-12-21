const inputs = document.querySelectorAll('.input');
const submit_btns = document.querySelectorAll('.submit_btn');
const check_btn = document.querySelector('.check_btn');
const find_form = document.querySelectorAll('.find_form');
const sign_exp = document.querySelector('.sign_exp');


//전화번호 형식체크가 일치하면 ajax날리기 위해 변수 선언 
var phoneCheckResult = 0;
var nameCheckResult = 0;
var PasswordFormatResult = 0;
var passwordResult = 0;
var tempPhoneValue = '';
//인증번호가 일치시 다음으로 넘기기위해 변수 선언
var phoneAuthResult = 0;

var userData = {
	user_name: '',
	user_phone: '',
	user_id: '',
	user_password: '',
}

console.log(userData);
submit_btns[0].addEventListener('click', () => {
	//아이디 
	if (checkEmpty(inputs[0], 0)) {
		CheckIdFormat(inputs[0], 0);

	}
});

submit_btns[1].addEventListener('click', () => {
	console.log("1:" + userData.user_id);
	console.log("1:" + userData.user_name);
	console.log("1:" + userData.user_phone);

	//이름 
	if (checkEmpty(inputs[1], 1)) {
		checkNameFormat(inputs[1]);
	}
	if (nameCheckResult == 1 && phoneAuthResult == 1) {
		findPassword();
	} else if (nameCheckResult == 1 && phoneAuthResult == 0) {
		alert('전화번호 인증을 진행해주세요. ');
	}
});


submit_btns[2].addEventListener('click', () => {
	console.log("2:" + userData.user_id);
	console.log("2:" + userData.user_name);
	console.log("2:" + userData.user_phone);
	//비밀번호 변경 
	if (checkEmpty(inputs[3], 3)) {
		checkPasswordFormat(inputs[0].value, inputs[3].value, inputs[3]);
	}
	if (checkEmpty(inputs[4], 4)) {
		checkRepassword(inputs[3].value, inputs[4].value, inputs[4]);
	}
	if (PasswordFormatResult == 1 && passwordResult == 1) {
		updatePassword();
	}
});


function updatePassword() {

	$.ajax({
		type: "put",
		url: "update-password",
		data: JSON.stringify(userData),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function (data) {
			console.log(data)
			if (data == 0) {
				alert('비밀번호 수정에 실패하였습니다. 다시시도 해 주세요. ');
			} else if (data == 1) {
				alert('비밀번호 수정을 완료하였습니다. 다시 로그인 해주세요.');
				location.replace('sign-in');
			}
		},
		error: function () {
			alert('오류가 발생했습니다. 다시시도해주세요. ');
		}


	});

}



//비밀번호 일치 체크 
function checkRepassword(password, repassword, input) {
	console.log(password)
	console.log(repassword)
	if (password != repassword) {
		passwordCheckResult = 2;
		msgService(input, '비밀번호가 일치하지 않습니다. ', 0);
		return;
	}
	passwordResult = 1;
	userData.user_password = input.value;

}


//비밀번호 정규식 체크 
function checkPasswordFormat(id, password, input) {

	let check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(password);   //영문,숫자
	let check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/.test(password);  //영문,특수문자 
	let check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(password);  //특수문자, 숫자

	if (password.length >= 14) {
		msgService(input, '14자 이내로 입력해주세요. ', 0);
		return false;
	}

	if (!(check1 || check2 || check3)) {
		msgService(input, '사용할 수 없는 조합입니다', 0);
		return false;
	}

	if (/(\w)\1\1/.test(password)) {
		msgService(input, '같은 문자를 3번 이상 사용하실 수 없습니다.', 0);
		return false;

	}
	if (id.length != 0) {
		if (password.search(id) > -1) {
			msgService(input, '비밀번호에 아이디가 포함되었습니다.', 0);
			return false;
		}
	}
	PasswordFormatResult = 1;
	return true;

}


function findPassword() {
	$.ajax({
		type: "post",
		url: "/find-password",
		data: JSON.stringify(userData),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function (data) {
			if (data == '') {
				alert('해당 이름과 전화번호와 일치하는 아이디가 없습니다. ');
			} else {
				sign_exp.textContent = '새로운 비밀번호로 변경해 주세요. ';
				find_form[1].classList.add('invisible');
				find_form[2].classList.remove('invisible');
			}

		},
		error: function () {

		}
	});
}



//전화번호버튼클릭시 

check_btn.addEventListener('click', () => {
	clearMsg(inputs[2]);

	//전화번호 체크버튼 클릭 시 
	if (checkEmpty(inputs[2], 2)) {
		//전화번호 체크버튼이고 그 값이 비어있지않고 인증번호가날라왔을 때 
		if (phoneCheckResult == 1) {
			checkAuth(inputs[2]);
			return;
		}

		checkPhoneFormat(inputs[2]);

	}
});



//휴대폰 인증번호 일치여부 확인
function checkAuth(input) {

	console.log(input.value)
	let authNumber = input.value;
	console.log(authNumber)
	if (authCode == authNumber) {
		console.log('인증번호 일치함  ')
		phoneAuthResult = 1;
		alert('인증완료하였습니다. ');
	} else {
		console.log('인증번호 일치하지 않음 ')
		msgService(input, '인증번호가 일치하지 않습니다. ', 0);
	}
}


//전화번호 인증
function checkPhone(input) {
	console.log("3:" + userData.user_id);
	console.log("3:" + userData.user_name);
	console.log("3:" + userData.user_phone);
	console.log('checkPhone: ' + input);
	$.ajax({
		type: "get",
		url: "phone-check",
		data: {
			phoneNumber: input.value
		},
		dataType: "text",
		success: function (data) {
			authCode = data;
			userData.user_phone = tempPhoneValue; //checkPhoneFormat에서 tempPhoneValue에 저장해놓은 유저의 전화번호의 값을
			//인증번호가 일치할때만 signUpData.user_phone에 값을 넣어준다. 
			//유저가 입력한 인증번호가 일치하지 않을때에는 넣어주면 안된다.( signUpData.user_phone는 데이터베이스로 넘어가는 값이기 떄문 ) 
			tempPasswordValue = input.value;
			phoneCheckResult = 1;
		},
		error: function () {
			phoneCheckResult = 2;
			alert("오류가발생하였습니다 다시시도해주세요.");
		}
	})

}




function checkEmpty(input, inputIndex) {
	clearMsg(input);
	if (input.value.length == 0) {
		if (inputIndex == 0) {
			msgService(input, '아이디를 입력해주세요. ', 0);
		} else if (inputIndex == 1) {
			msgService(input, '이름를 입력해주세요. ', 0);
		} else if (inputIndex == 2) {
			if (phoneCheckResult == 1) {
				msgService(input, '인증번호를 입력해주세요. ', 0);
				return;
			}
			msgService(input, '전화번호를 입력해주세요. ', 0);
		} else if (inputIndex == 3) {
			msgService(input, '비밀번호를 입력해주세요. ', 0);
		} else if (inputIndex == 4) {
			msgService(input, '비밀번호를 한번 더 입력해주세요. ', 0);
		}
		return false;
	}
	return true;
}



//아이디 정규식 체크
function CheckIdFormat(input) {

	if (!/^[a-z]+[a-z0-9]{5,15}$/g.test(input.value)) {
		msgService(input, '아이디는 6~20자 영문자 또는 숫자이어야 합니다.', 0);
		return;
	}

	userData.user_id = input.value;
	checkId(input);

}



//아이디 중복확인 
function checkId(input) {
	$.ajax({
		type: "post",
		url: "id-check",
		data: JSON.stringify(userData),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function (data) {
			if (data == 1) {

				find_form[0].classList.add('invisible');
				find_form[1].classList.remove('invisible');
				sign_exp.textContent = '비밀번호 찾기를 위해 이름과 전화번호를 입력해주세요.';


			} else if (data == 0) {
				userData.user_id = '';
				alert('찾고자 하는 아이디가 없습니다.');
			}
		},
		error: function () {
			alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
	})
}


//이름 정규식 체크
function checkNameFormat(input) {
	console.log('input.value: ' + input.value);
	let reg_name = /^[가-힣]+$/;
	if (!reg_name.test(input.value)) {
		checkNameResult = 2;
		msgService(input, '이름을 정확히 입력해주세요.', 0);
		return false;
	}
	nameCheckResult = 1;
	userData.user_name = input.value;
	console.log('123:' + userData.user_name);
	return true;
}



//전화번호 정규식 체크
function checkPhoneFormat(input) {

	if (!/^[A-Za-z0-9]{11}$/.test(input.value)) {
		msgService(input, '전화번호를 정확히 입력해 주세요.', 0);
		return;
	}

	tempPhoneValue = input.value;  // inputs[0].value = '' 이걸 해주기때문에 input을 넘기면 checkPhone(input)의 input.value는 null이된다.
	checkPhone(input);             //그래서 보내기전에 미리 tempPhoneValue안에 유저의 전화번호를 저장해둔다 .
	inputs[2].value = '';
	inputs[2].focus();
	inputs[2].placeholder = '인증번호를 입력해 주세요. ';
	check_btn.textContent = '인증확인 ';

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