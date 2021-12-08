const like_button = document.querySelector('.like_button');
const like_icon = document.querySelector('.like_button i');
const like_count = document.querySelector('.like_count');
const item_info_btn = document.querySelector('.item_info_btn');
const user_id = document.querySelector('#user_id');
const chatstart = document.querySelector('.chatstart');

var list={
	
}

console.log('user_id: ' + user_id.value);


//다시 새로고침했을때 하트아이콘색 유지를 위해 
if(user_id.value == 0 ) {
	 like_icon.classList.remove('color--red');
	 //user_id가 0이라는 것은 유저가 좋아요 클릭을 안했다는 것 
	 //그래서  like_button.value에 1을 넣어주어서 클릭시 insert가 일어나게 한다. 
	  
}else {
	like_icon.classList.add('color--red');
	 //user_id가 0이 아니라는 것은 유저가 좋아요 클릭한 상태라는것 (insert가 한번 이루어진상태)
	 //그래서  like_button.value에 2 을 넣어주어서 다음 클릭시 delete가 일어나게 한다.
}

//좋아요 버튼 클릭시 
like_button.addEventListener('click', () => {
	if(user_id.value == 0) {
		 addLike();
		
	}else {
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
			"productId" : 2
		},
		dataType: "text",
		success: function(data) {
			let productLikeData = JSON.parse(data);
			console.log('add: ' +productLikeData);
			if(productLikeData.like_result == 1) {
				msgService('찜하기가 완료되었습니다', 1);
				user_id.value = productLikeData.user_id;
			}else if(data == 2) { 
				alert('로그인이 필요합니다.');  //여기까지 왔다는 건 찜하기 버튼을 한번 누른상태이다.(지금 LikeServiceFlag은 1인상태)
				     //그래서 다시 버튼을 누르면 2가되고 2는 delete이다.(insert도 되지않은 상태에서 delete를 하려고하니 오류가난다.)
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
			"productId" : 2
		},
		dataType: "text",
		success: function(data) {
			let productLikeData = JSON.parse(data);
			console.log();
			if(productLikeData.like_result == 1) {
				msgService('찜하기가 제거되었습니다', 2);
				user_id.value = '';
			  
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
	}, 300);
	  
	setTimeout(() => {
		if(item_info_btn.nextElementSibling.tagName == 'P'){
		 item_info_btn.nextElementSibling.remove();		
		 }
	 }, 2000);
				
}


			
		