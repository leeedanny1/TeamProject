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
var tempPasswordValue = '';
var tempNicknameValue = '';

//닉네임 중복확인버튼 클릭 시 
check_btn.addEventListener('click' , () => {
      if(checkEmpty(inputs[2], 2)) {
	     checkNicknameFormat(inputs[2]);
	  }else {
		checkNicknameResult = 0;
		msgService(inputs[2], '닉네임을 입력해주세요. ', 0);
	}
	
});


//blur시에는 비밀번호만 체크 
inputs.forEach((input, inputIndex) => {
	 input.addEventListener('blur', () => {
		clearMsg(input);
		checkPasswordService(input, inputIndex);
	});
});


//비밀번호 일치여부 확인하기전의 검사 
function checkPasswordService(input, inputIndex) {
	console.log(inputIndex)
	   checkEmptyResult = checkEmpty(input, inputIndex);
	   //입력값이 있든없든 패스워드 일치여부를 체크해야한다.
	   //그렇지 않으면 비밀번호에 값이 있고 비밀번호 확인에 값이 없을 경우에도 그냥 넘어간다.
	   //수정페이지에서는 입력값이 없어도 넘어가야하기때문
	 
	 if(inputIndex == 0) {
			checkPasswordFormat(updateData.user_id, input.value, input);
				
	
	 }else if(inputIndex == 1) {
			checkRepassword(inputs[inputIndex -1].value, input.value, input);
			}
		
}



submit_btn.addEventListener('click', () => {
	
	
	console.log(inputs[0].value.length)
	console.log(checkNicknameResult);
	console.log('checkNicknameResult: ' + checkNicknameResult);
	console.log('checkPasswordResult: ' + checkPasswordResult)
	inputs.forEach((input, inputIndex) => {
		//빈값인 상태에서 닉네임 체크를 친행했을 경우 닉네임을 입력해주세요 메시지가 뜬다.
		//그 상태에서 사용자가 닉네임을 바꾸지 않고 회원정보수정 버튼 클릭 시 위의 메시지를 지우기 위함 
	   clearMsg(input);
	    checkEmpty(input,inputIndex);
	    checkPasswordService(input, inputIndex) ;
	});
	
	
	  //비밀번호 값, 닉네임 값이 둘다 없을때 
      if(inputs[0].value.length == 0 && inputs[1].value.length == 0 && inputs[2].value.length == 0){
            console.log('둘다 없을 때: ' + updateData.user_password + updateData.user_nickname);
	         if(confirm('변경할 값이 없습니다. 그대로 진행하시겠습니까?')) {
		        alert('회원수정이 완료되었습니다. ');
		        location.replace('/index');
		        }
        }
	
	 //비밀번호 일치여부 체크 성공하고 닉네임 값이 있을때 
	 else if(checkPasswordResult == 1 && inputs[2].value.length !=0){
		 //비밀번호 일치여부 체크 성공하고 닉네임 값이 있는데 중복확인을 안했을 경우 
		 if(checkNicknameResult != 1) {
			  alert('닉네임 중복확인을 진행해 주세요. ');
		 //비밀번호 일치여부 체크 성공하고 닉네임 값도 있고  중복확인을 했을 경우 
	      }else {
		 //비밀번호 일치여부 체크 성공, 닉네임 중복확인 성공, 닉네임 중복확인 성공후 값을 바꿨을 때 
			 if(tempNicknameValue != inputs[2].value) {
			    checkNicknameResult = 2;
				alert('닉네임 값이 변경되었습니다. 다시 인증을 진행해 주세요.');
	    //비밀번호 일치여부 체크 성공, 닉네임 중복확인 성공, 닉네임 중복확 성공후 값을 바꾸지 않았을때 ajax
		      }else{
		       console.log('둘다 있을때  : ' + updateData.user_password + updateData.user_nickname);
				if(confirm('입력하신 정보로 수정을 진행하시겠습니까? ')){
			   update();
			}
			}
         }//end of 비밀번호 일치여부 체크 성공하고 닉네임 값도 있고  중복확인을 했을 경우 
        
       
     }//end of  //비밀번호 일치여부 체크 성공하고 닉네임 값이 있을때 
     
     //비밀번호 일치여부 체크 성공하고 닉네임 값이 없을 때  
     else if(checkPasswordResult == 1 && inputs[2].value.length == 0){    
	console.log(checkPasswordResult);
	    
	     if(confirm('닉네임이 입력되지 않았습니다. 그대로 진행하시겠습니까? ')) {
					update();
				}
				
	//닉네임값은 있는데 중복확인을 안했거나, 중복확인실패 , 중복성공 이 세가지중하나와  비밀번호 값이 없을 때 			
     }else if((checkNicknameResult == 0 || checkNicknameResult == 1 || checkNicknameResult == 2) && checkPasswordResult == 0) {
	        if(checkNicknameResult != 1) {
			  alert('닉네임 중복확인을 진행해 주세요. ');
		    }else{
	         if(tempNicknameValue != inputs[2].value) {
			    checkNicknameResult = 2;
				alert('닉네임 값이 변경되었습니다. 다시 인증을 진행해 주세요.');
				}
	          else{ 
		          if(confirm('비밀번호가 입력되지 않았습니다. 그대로 진행하시겠습니까? ')) {
					 update();
				}
			}	
}
}//end of //닉네임값은 있는데 중복확인을 안했거나, 중복확인실패 , 중복성공 이 세가지중하나와  비밀번호 값이 없을 때 

});





//빈값 체크 
function checkEmpty(input, checkIndex) {
	clearMsg(input);
    if(input.value.length == 0 ){
       if(checkIndex == 0 || checkIndex == 1) {
	checkPasswordResult = 0;
}
	//비밀번호, 닉네임은 입력이 필수가 아니기때문에 빈값이라도 메시지는 띄우지않는다.
	//단, 닉네임 중복확인 버튼을 눌렀을 때에는 빈값메시지를 띄워준다. (빈값을 체크할순 없기때문 )
  
	 return false;
	}
	
	
	 return true;
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
    if(id.length != 0){
    if (password.search(id) > -1) {
        msgService(input, '비밀번호에 아이디가 포함되었습니다.', 0);
        return false;
    }
    }
    
       return true;
       

}

//비밀번호 일치 체크 
function checkRepassword(password, repassword, input) {
   console.log(password);
    console.log(repassword);
    if (password != repassword) {
	  msgService(input, '비밀번호가 일치하지 않습니다. ', 0);
	 checkPasswordResult = 2;
	 return false;
    }
    if(password.length != 0){
	   tempPasswordValue = password;
	    checkPasswordResult = 1;
        updateData.user_password = input.value;
        return true;
        }
    }



//닉네임 정규식 체크 
function checkNicknameFormat(input) {
    nickname = input.value;

    if (nickname.search(/\s/) != -1) {
        msgService(input, '공백을 포함할 수 없습니다. ', 0);
         checkNicknameResult =2;
        return false;
    } else if (nickname.length < 2 || nickname.length > 13 || /[`~!@#$%^&*|\\\'\";,.:\/?]/gi.test(nickname) == true) {
        msgService(input, '2~13이내의 영문과 숫자만 사용 가능합니다. ', 0);
        checkNicknameResult =2;
        return false;
    }
   
    checkNickname(input);
    return true;
}

//닉네임 중복확인 
function checkNickname(input) {
	console.log(input.value);
	 $.ajax({
		type: "get",
		url: 'nickname-check',
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
			 updateData.user_nickname = input.value;
			 tempNicknameValue = input.value;
			 checkNicknameResult = 1;
		}
		   
		},
		error: function() {
				alert('오류가 발생했습니다. 다시시도해주세요. ');
		}
	})
}


//업데이트
function update() {
	$.ajax({
		type: "put",
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