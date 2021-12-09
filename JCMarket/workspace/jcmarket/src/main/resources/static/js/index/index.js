const toUpdatePage = document.querySelector('.toUpdatePage');
const check_password = document.querySelector('.check_password');
const toUpdatePage_btn = document.querySelector('.toUpdatePage_btn');
const input_password = document.querySelector('.input_password');
const h_search_btn = document.querySelector('.h_search_btn');
const h_search = document.querySelector('.h_search');
const h_sale_btn = document.querySelector('.h_sale_btn');
const h_myshop_btn = document.querySelector('.h_myshop_btn');
const h_jctalk_btn = document.querySelector('.h_jctalk_btn');
const searchValue = document.querySelector('.searchValue');
const user_id = document.querySelector('.user_id');




//검색시 검색input안의 값을 남기기 위해 
h_search.value = searchValue.value;

//검색 아이콘 클릭 시 
h_search_btn.addEventListener('click', ()=> {  
	if(h_search.value.length == 0) {
		alert('검색어를 입력해 주세요!');
	    return;
	}
	location.href = '/items/search/' + h_search.value;
});


// 헤더 검색창 우측부분
// 판매하기 버튼을 눌렀을 때
h_sale_btn.onclick = () => {
	if(toUpdatePage == null){
		alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.")
		location.href = "/sign-in-select"
	} else {
		location.href = "/items/sale"
	}

}
// 내상점 버튼을 눌렀을 때
h_myshop_btn.onclick = () => {
	if(toUpdatePage == null){
		alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.")
		location.href = "/sign-in-select"
	} else {
		location.href = "/my-shop/" + user_id.value;
	}

}
// jc톡 버튼을 눌렀을 때
h_jctalk_btn.onclick = () => {
	if(toUpdatePage == null){
		alert("로그인이 필요합니다. 로그인 페이지로 이동합니다.")
		location.href = "/sign-in-select"
	} else {
		window.open('/chat')
	}

}





toUpdatePage.addEventListener('click' , () => {

	if(user_id.value.length < 16 ) {
	check_password.classList.toggle('invisible');
	}else {
		location.href = '/update';
	}
});

toUpdatePage_btn.addEventListener('click', () => {
    getUserPassword();
});


function getUserPassword() {
	$.ajax({
		type: "get",
		url: "get-password",
		data: {
			input_password: input_password.value
		},
		dataType: "text",
		success: function(data) {
			console.log('data: '+ data);
			if(data == 1) {
				location.replace('/update');
			}else if(data == 2 ){
				alert('비밀번호가 일치하지 않습니다.');
			}
		},
		error: function() {
			
		}
		
	});
}



