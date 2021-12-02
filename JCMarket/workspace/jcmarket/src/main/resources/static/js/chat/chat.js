const msginput = document.querySelector('.msginput');
const submitbtn = document.querySelector('.submitbtn');
const chatlist_btn= document.querySelectorAll('.chatlist_btn');


msginput.onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
	}
}
function submitmsg(){
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