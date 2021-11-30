const like_button = document.querySelector('.like_button');
const like_icon = document.querySelector('.like_button i');
const like_count = document.querySelector('.like_count');
const item_info_btn = document.querySelector('.item_info_btn');
const user_id = document.querySelector('#user_id');

let  LikeServiceFlag = 0;


//다시 새로고침했을때 하트아이콘색 유지를 위해 
if(user_id.value == 0 ) {
	 like_icon.classList.remove('color--red');
	 
}else {
	like_icon.classList.add('color--red');
}

//좋아요 버튼 클릭시 
like_button.addEventListener('click', () => {
	 LikeServiceFlag++;
	 if(LikeServiceFlag == 1) {
		 addLike();
	}else if(LikeServiceFlag == 2){
		 LikeServiceFlag = 0;
	     deleteLike();
	}
});





//좋아요 추가 
function addLike() {
	
	//modelAndView로 받아와서 el로 like_button.value에 product아이디 값을 저장해두고
	//버튼클릭시 그 값을 받아온다. 
	 let productId = like_button.value;
	
	 $.ajax({
		type: "post",
		url: "/items/add-like",
		data: {
			"productId" : productId
		},
		dataType: "text",
		success: function(data) {
			let productLikeData = JSON.parse(data);
			console.log('add: ' +productLikeData);
			if(productLikeData.like_result == 1) {
				msgService('찜하기가 완료되었습니다', 1);
				console.log(' productLikeData.like_count: ' +  productLikeData.like_count);
				
			}else if(data == 2) { 
				alert('로그인이 필요합니다.');  //여기까지 왔다는 건 찜하기 버튼을 한번 누른상태이다.(지금 LikeServiceFlag은 1인상태)
				 LikeServiceFlag = 0;      //그래서 다시 버튼을 누르면 2가되고 2는 delete이다.(insert도 되지않은 상태에서 delete를 하려고하니 오류가난다.)
			}                              //그러므로 다시 flag값을 0으로 리셋시켜주어야한다. 
		 },                                
		 error: function() {
			
		}
		});
			 
}


//좋아요 삭제  
function deleteLike() {
	 let productId = like_button.value;
	
	 $.ajax({
		type: "delete",
		url: "/items/delete-like",
		data: {
			"productId" : productId
		},
		dataType: "text",
		success: function(data) {
			let productLikeData = JSON.parse(data);
			console.log();
			if(productLikeData.like_result == 1) {
				msgService('찜하기가 제거되었습니다', 2);
			   
			}
		 },
		 error: function() {
			
		}
		});
			  
	
}


function msgService(content, result) {

	setTimeout(() => {
		const p = document.createElement('p');
		 p.textContent = content;
		//좋아요 추가 
		if(result == 1){
	   p.classList.add('add_msg');
	   like_icon.classList.add('color--red');
	   like_count.textContent = parseInt(like_count.textContent) + 1;
	  
	   //좋아요 삭제 
	   }else if(result == 2) {
		 p.classList.add('delete_msg');
		 like_icon.classList.remove('color--red');
		 like_count.textContent = parseInt(like_count.textContent) - 1;
	   }
	    item_info_btn.after(p);
	}, 500);
	  
	setTimeout(() => {
		if(item_info_btn.nextElementSibling.tagName == 'P'){
		 item_info_btn.nextElementSibling.remove();		
		 }
	 }, 3000);
				
}


			
		