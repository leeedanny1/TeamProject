const update_form = document.querySelector('.sign_form');
const user_info = document.querySelectorAll('.user_info');
const inputs = document.querySelectorAll('.input');
const submit_btn = document.querySelector('.submit_btn');
const check_btn = document.querySelector('.check_btn');

var updateData = {
    user_id: user_info[2].value,
    user_password: '',
    user_name: user_info[0].value,
    user_phone: user_info[1].value,
    user_nickname: ''
}

var checkPasswordResult = 0;
var checkNicknameResult = 0;
var checkEmptyResult;

//blur input 
inputs.forEach((input, inputIndex) => {
    input.addEventListener('blur', () => {
	  checkEmptyResult = checkEmpty(input);
    if(checkEmptyResult == true) {
	  checkInputValue(input, inputIndex);
}
});
});


//수정 버튼 클릭시 
submit_btn.addEventListener('click', () => {
	inputs.forEach((input, inputIndex) => {
	  if(checkEmptyResult == true) {
		checkInputValue(input, inputIndex);
	  }
});
	
	   onSubmit();
});


function confirmService(confirmFlag, content) {
	if(confirmFlag == 0) {
		if(confirm('변경 할 값이 없습니다. 그대로 진행하시겠습니까?')) {
	        alert('회원수정을 완료하였습니다. ');
	        location.replace('index');
	    }
	     return;
	}
	
    if(confirm(`${content} 값이 입력되지 않았습니다. 그대로 진행하시겠습니까?`)) {
	    console.log(`${content} 값 변경없음 `);
	}
}


function onSubmit() {
    
	//비밀번호, 닉네임 값 모두 없을때 
	if(inputs[0].value.length == 0 && inputs[2].value.length == 0) {
		confirmService(0);
		return;
	}
	//비밀번호에만 값이 있을 때 
	if(inputs[0].value.length != 0 && inputs[2].value.length == 0){
	    if(checkPasswordResult == 1) {
		  confirmService(1, '닉네임 ');
		  updateData.user_nickname = '';
		  update();
	}
	return;
	}    
	//닉네임에만 값이 있을 때
	if(inputs[0].value.length == 0 && inputs[2].value.length != 0) {
		if(checkNicknameResult == 0 || checkNicknameResult == 2) {
			alert('닉네임 인증을 진행해 주세요. ');
		}else {
			confirmService(1, '비밀번호' );
			updateData.user_password = '';
			update();
		}
	}
	//둘다 값이 있을 때 
	if(inputs[0].value.length != 0 && inputs[2].value.length != 0) {
        if(checkNicknameResult == 0 || checkNicknameResult == 2) {
			alert('닉네임 인증을 진행해 주세요. ');
		}else {
			update();
		}
	}
	
  if(checkPasswordResult == 1 && checkNicknameResult == 1) {
	   update();
}
  }



//닉네임 중복확인 버튼 클릭 시 
check_btn.addEventListener('click', () => {
	
	 //닉네임 중복확인 
	      checkEmptyResult =  checkEmpty(inputs[2]);
	      //닉네임 형식 체크에 실패했을 때 
	      if(checkEmptyResult == false) {
		   msgService(inputs[2], '닉네임을 입력해 주세요.');
		    return;
	}
	     //값이 있고 닉네임 체크에 성공했을 때 ajax로 인증 
	      if(checkNicknameFormat(inputs[2])){
	       checkNicknameResult = 1;
	       checkNickname(inputs[2]);
	}else {
		    checkNicknameResult = 2;
	}
		
});



//input 값 체크 
function checkInputValue(input, inputIndex) {
	// 비밀번호 
	 if(inputIndex == 0) {
		if(!checkPasswordFormat(updateData.user_id, input.value, input)){
			 checkPasswordResult = 2;
		}else {
			 checkPasswordResult = 1;
		}
	//비밀번호 확인 
	 }else if(inputIndex == 1) {
		 checkRepassword(inputs[inputIndex - 1].value, input.value, input);
		}
	}




//빈값 체크 
function checkEmpty(input) {
	
	clearMsg(input)
	if(input.value.length == 0){
		return false;
	}else {
		return true;
	}
}



//비밀번호 정규식 체크 
function checkPasswordFormat(id, password, input) {


    let check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(password);   //영문,숫자
    let check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/.test(password);  //영문,특수문자 
    let check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(password);  //특수문자, 숫자

    if (password.length >= 14) {
        msgService(input, '14자 이내로 입력해주세요. ');
         return false;
    }

    if (!(check1 || check2 || check3)) {
        msgService(input, '사용할 수 없는 조합입니다');
        return false;
    }

    if (/(\w)\1\1/.test(password)) {
        msgService(input, '같은 문자를 3번 이상 사용하실 수 없습니다.');
         return false;

    }
    if (password.search(id) > -1) {
        msgService(input, '비밀번호에 아이디가 포함되었습니다.');
        return false;
    }
    
       return true;

}

//비밀번호 일치 체크 
function checkRepassword(password, repassword, input) {
   console.log(password)
   console.log(repassword)
    if (password != repassword) {
	  msgService(input, '비밀번호가 일치하지 않습니다. ');
	 checkPasswordResult = 2;
	 return false;
    }else{
	    checkPasswordResult = 1;
        updateData.user_password = input.value;
        return true;
    }

}

//닉네임 정규식 체크 
function checkNicknameFormat(input) {
    nickname = input.value;

    if (nickname.search(/\s/) != -1) {
        msgService(input, '공백을 포함할 수 없습니다. ');
         checkNicknameResult =2;
        return false;
    } else if (nickname.length < 2 || nickname.length > 13 || /[`~!@#$%^&*|\\\'\";,.:\/?]/gi.test(nickname) == true) {
        msgService(input, '2~13이내의 영문과 숫자만 사용 가능합니다. ');
        checkNicknameResult =2;
        return false;
    }
    checkNicknameResult =1;
    return true;

}

//닉네임 중복확인 
function checkNickname(input) {
    $.ajax({
        type: "get",
        url: "nickname-check",
        data: {
           signUpNickname: input.value,
        },
        dataType: "text",
        success: function (data) {
            if (data == 1) {
                msgService(input, `${input.value} 는 이미 존재하는 닉네임입니다.`);
                checkNicknameResult = 2;
            } else if (data == 0) {
                msgService(input, '사용가능한 닉네임입니다. ');
                updateData.user_nickname = input.value;
                checkNicknameResult = 1;
            }

        },
        error: function () {
            alert('오류가 발생했습니다. 다시시도해주세요. ');
        }
    })
}


//업데이트
function update() {
	$.ajax({
		type: "post",
		url: "update",
		data: JSON.stringify(updateData),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			console.log(data)
			if(data == 0) {
			    alert('회원수정에 실패하였습니다. ');
			}else if(data == 1) {
				alert('회원수정을 완료하였습니다.  ');
				location.replace('index');
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
function msgService(input, msgContent) {
    const p = document.createElement('p');
    p.textContent = msgContent;
    p.classList.add('msg');
    input.after(p);
}
