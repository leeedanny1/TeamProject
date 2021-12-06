const msginput = document.querySelector('.msginput');
const submitbtn = document.querySelector('.submitbtn');
const chatlist_btn = document.querySelectorAll('.chatlist_btn');
const chatinfo= document.querySelectorAll('.chatinfo');
const chatmsg = document.querySelector('.chatmsg');

var chatObj = {
	item_code : '',
	buyer_id :'',
	seller_id :'',
	chat_content: '',
	writer_id : ''
}
for(let i = 0; i< chatlist_btn.length; i++){
	chatlist_btn[i].onclick = () => {
		EnterInChatRoom(i);
	}
}

function clearChatRoom(){
	while(chatmsg.hasChildNodes()){
		chatmsg.removeChild(chatmsg.firstChild);
	}
}

function chatContentAppend(id, chatRespObj){
	clearChatRoom();
	for(let i = 0; i < chatRespObj.length; i++){
		if(id == chatRespObj[i].writer_id){
			chatmsg.innerHTML += 
				`<h2 class="my">
					<li>${chatRespObj[i].chat_content}</li>
					<li><h5 class="nickname">${chatRespObj[i].writer_nickname }</h5></li>
				</h2>`;
		}else{
			chatmsg.innerHTML += 
				`<h2 class="you">
					<li>${chatRespObj[i].chat_content}</li>
					<li><h5 class="nickname">${chatRespObj[i].writer_nickname }</h5></li>
				</h2>`;
		}
	}
	
}


function EnterInChatRoom(i){
	chatObj.item_code = chatinfo[i * 4].value;
	chatObj.buyer_id = chatinfo[(i * 4) + 1].value;
	chatObj.seller_id = chatinfo[(i * 4) + 2].value;
	chatObj.id = chatinfo[(i * 4) + 3].value;
	$.ajax({
		type: "post",
		url: "/chatting/" + i,
		data: JSON.stringify(chatObj),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data){
			chatRespObj = JSON.parse(data);
			chatContentAppend(chatObj.id, chatRespObj);
		},
		error: function(){
			alert('비동기 처리 실패');
		}
	})
}

function chatSend(chatObj){
	$.ajax({
		type: "POST",
		url: "/chat-insert",
		 data: JSON.stringify(chatObj),
		 contentType: "application/json;charset=UTF-8",
	 	 dataType: "text",
		success: function(data) {
			alert(JSON.stringify(chatObj))
		},error(){
		
		}
	});
}


msginput.onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
		chatinfo1.chat_content=msginput.value;
		alert(chatObj.value);
		chatSend();
	}
}


submitbtn.onclick = () => {
	chatObj.chat_content=msginput.value;
	chatSend();
}