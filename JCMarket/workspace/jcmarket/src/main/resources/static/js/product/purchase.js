const like_button = document.querySelector('.like_button');
const like_icon = document.querySelector('.like_button i');
const like_count = document.querySelector('.like_count');
const item_info_btn = document.querySelector('.item_info_btn');

let click_count = 0;
like_button.addEventListener('click', () => {
	console.log(like_button.value);
   if(like_button.value  === '') {
	alert('로그인이 필요합니다! ');
	return;
}
     click_count++;
     if(click_count == 1){
	//추가 
	 like_icon.classList.add('color--red');
	 like_count.textContent = 1;
	 addLike();
    }else if(click_count == 2) {
	//삭제 
	   like_icon.classList.remove('color--red');
	   like_count.textContent = 0;
	   click_count = 0;
}

});


//좋아요 추가 
function addLike() {
	 let productId = like_button.value;
	
	 $.ajax({
		type: "post",
		url: "/items/add-like",
		data: {
			productId : 2
		},
		dataType: "text",
		success: function(data) {
			if(data == 1) {
				msgService('찜하기가 완료되었습니다');
			}
		 },
		 error: function() {
			
		}
		});
			  
	
}

//좋아요 삭제 
function removeLike() {
	//modelAndView로 받아와서 el로 like_button.value에 product아이디 값을 저장해두고
	//버튼클릭시 그 값을 받아온다. 
	 let product_id = like_button.value;
	 
}

function msgService(content) {

	setTimeout(() => {
		 const p = document.createElement('p');
	   p.classList.add('msg');
	   p.textContent = content;
	   item_info_btn.after(p);
	}, 500);
	  
	setTimeout(() => {
		if(item_info_btn.nextElementSibling.tagName == 'P'){
		 item_info_btn.nextElementSibling.remove();		
		 }
	 }, 3000);
				
}


			
		