const inputs = document.querySelectorAll('.input')
const check_btn = document.querySelectorAll('.check_btn')
var signUpData = {
    user_id:'',
    user_password: '',
    user_name: '',
    user_phone: '',
    user_nickname:''
 }

var phoneCheckResult = 0; 
var  checkNicknameResult = 0;
var tempNickNameValue= '';
var checkEmptyResult = false;

check_btn[1].onclick =() => {
	checkNickname(inputs[1]);
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
			alert('${input.value}는 이미 존재하는 닉네임입니다.');
			 checkNicknameResult = 2;
		}else if(data == 0) {
			 alert('${input.value}는 사용가능한 닉네임입니다.');
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