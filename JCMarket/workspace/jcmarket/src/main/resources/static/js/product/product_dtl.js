const product_update_btn = document.querySelector(".product_update_btn");
const like_button = document.querySelector('.like_button');
const like_icon = document.querySelector('.like_button i');
const like_count = document.querySelector('.like_count');
const item_info_btn = document.querySelector('.item_info_btn');
const chatstart = document.querySelector('.chatstart');
const listinfo = document.querySelectorAll('.listinfo');
const like_id = document.querySelector('.like_id');
const item_code = document.querySelector('.item_code');


var list = {
	item_code: listinfo[0].value,
	buyer_id: listinfo[1].value,
	seller_id: listinfo[2].value
}
chatstart.onclick = () => {

	if (list.buyer_id == list.seller_id) {
		alert('본인이 등록하신 상품입니다');
	} else if (list.seller_id == 0) {
		alert('로그인 후 사용가능한 기능입니다');
	}
	else {
		$.ajax({
			type: "post",
			url: "/list-select",
			data: JSON.stringify(list),
			contentType: "application/json;charset=UTF-8",
			dataType: "text",
			success: function(data) {
				if (data == '0') {
					$.ajax({
						type: "post",
						url: "/list-insert",
						data: JSON.stringify(list),
						contentType: "application/json;charset=UTF-8",
						dataType: "text",
						success: function(data) {
							window.open("/chat");
						}, error: function() {
						}
					})
				}
				else{
					window.open("/chat");
				}
				window.open("/chat");
			}, error: function() {
				
			}
		})


	}
}

//다시 새로고침했을때 하트아이콘색 유지를 위해 
if (like_id.value == 0) {
	like_icon.classList.remove('color--red');
	//user_id가 0이라는 것은 유저가 좋아요 클릭을 안했다는 것 
	//그래서  like_button.value에 1을 넣어주어서 클릭시 insert가 일어나게 한다. 

} else {
	like_icon.classList.add('color--red');
	//user_id가 0이 아니라는 것은 유저가 좋아요 클릭한 상태라는것 (insert가 한번 이루어진상태)
	//그래서  like_button.value에 2 을 넣어주어서 다음 클릭시 delete가 일어나게 한다.
}

//좋아요 버튼 클릭시 
like_button.addEventListener('click', () => {
	
	if (like_id.value == 0) {
		addLike();

	} else {
		deleteLike();
	}
});


//좋아요 추가 
function addLike() {

	$.ajax({
		type: "post",
		url: "/items/add-like",
		data: {
			productId: item_code.value
		},
		dataType: "text",
		success: function(data) {
			let productLikeData = JSON.parse(data);
			console.log('add: ' + productLikeData.user_id);
			if (productLikeData.like_result == 1) {
				msgService('찜하기가 완료되었습니다', 1);
				like_id.value = productLikeData.user_id;
			} else if (data == 2) {
				alert('로그인이 필요합니다.'); 
			}                             
		},
		error: function() {

		}
	});

}


//좋아요 삭제  
function deleteLike() {


	$.ajax({
		type: "delete",
		url: "/items/delete-like",
		data: {
			productId: item_code.value
		},
		dataType: "text",
		success: function(data) {
			let productLikeData = JSON.parse(data);
			console.log();
			if (productLikeData.like_result == 1) {
				msgService('찜하기가 제거되었습니다', 2);
				like_id.value = 0;

			}
		},
		error: function() {

		}
	});


}


function msgService(content, result) {
   console.log(content);
    console.log(result);
	setTimeout(() => {
		const p = document.createElement('p');
		p.textContent = content;
		//좋아요 추가 
		if (result == 1) {
			p.classList.add('add_msg');
			like_icon.classList.add('color--red');
			like_count.textContent = parseInt(like_count.textContent) + 1;
        
			//좋아요 삭제 
		} else if (result == 2) {
			p.classList.add('delete_msg');
			like_icon.classList.remove('color--red');
			like_count.textContent = parseInt(like_count.textContent) - 1;
		}
		item_info_btn.after(p);
	}, 300);

	setTimeout(() => {
		if (item_info_btn.nextElementSibling.tagName == 'P') {
			item_info_btn.nextElementSibling.remove();
		}
	}, 2000);

}



// 수정하기 연결
product_update_btn.onclick = () => {
    const item = document.querySelector('#item_title_value')
    const code = document.querySelector('.item_code')

    if(confirm("상품명: " + item.textContent + "\n상품을 수정하시겠습니까?")){
        console.log(code.value)
        location.href = "/items/update/" + code.value
    } else {
        alert("상품 수정을 취소하였습니다.")
    }
}

