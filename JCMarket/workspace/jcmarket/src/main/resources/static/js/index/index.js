const toUpdatePage = document.querySelector('.toUpdatePage');
const check_password = document.querySelector('.check_password');
const toUpdatePage_btn = document.querySelector('.toUpdatePage_btn');
const input_password = document.querySelector('.input_password');
const h_search_btn = document.querySelector('.h_search_btn');
const h_search = document.querySelector('.h_search');



//검색 아이콘 클릭 시 
h_search_btn.addEventListener('click', ()=> {
	console.log(123);
	location.href = '/items/search/' + h_search.value;
});




toUpdatePage.addEventListener('click' , () => {
	check_password.classList.toggle('invisible');
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



