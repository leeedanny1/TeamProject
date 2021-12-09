const msginput = document.querySelectorAll('.msginput');
const submitbtn = document.querySelectorAll('.submitbtn');
const chatlist_btn = document.querySelectorAll('.chatlist_btn');
const chatinfo = document.querySelectorAll('.chatinfo');
const chatmsg = document.querySelector('.chatmsg');
const chatting = document.querySelector('.chatting');
const none = document.querySelectorAll('.none');
const exit = document.querySelectorAll("#exit");
var chatObj = {
	item_code: '',
	buyer_id: '',
	seller_id: '',
	chat_content: '',
	writer_id: ''
}

for (let i = 0; i < chatlist_btn.length; i++) {
	chatlist_btn[i].onclick = () => {
		for(let i = 0; i < chatlist_btn.length; i++){
			none[i].style.display = 'none';
		}
		EnterInChatRoom(i);
	}
}


function clearChatRoom() {
	while (chatmsg.hasChildNodes()) {
		chatmsg.removeChild(chatmsg.firstChild);
	}
}

function chatContentAppend(id, chatRespObj) {
	clearChatRoom();
	
	for (let i = 0; i < chatRespObj.length; i++) {
		if (id == chatRespObj[i].writer_id) {
			chatmsg.innerHTML +=
				`<h2 class="you" >
					<li>${chatRespObj[i].chat_content}</li>
					<li><h5 class="nickname">${chatRespObj[i].writer_nickname}</h5></li>
				</h2>`;
		} else {
			chatmsg.innerHTML +=
				`<h2 class="my">
					<li>${chatRespObj[i].chat_content}</li>
					<li><h5 class="nickname">${chatRespObj[i].writer_nickname}</h5></li>
				</h2>`;
		}
	}
	chatting.scrollTop = chatting.scrollHeight;

}


function EnterInChatRoom(i) {
	chatObj.item_code = chatinfo[i * 4].value;
	chatObj.buyer_id = chatinfo[(i * 4) + 1].value;
	chatObj.seller_id = chatinfo[(i * 4) + 2].value;
	chatObj.id = chatinfo[(i * 4) + 3].value;
	none[i].style.display = 'block';
	
	$.ajax({
		type: "post",
		url: "/chatting/" + i,
		data: JSON.stringify(chatObj),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			chatRespObj = JSON.parse(data);
			chatContentAppend(chatObj.id, chatRespObj);
		

		},
		error: function() {
			alert('비동기 처리 실패');
		}
	});
	
	setTimeout
	playAlert = setInterval(function() {
	$.ajax({
		type: "post",
		url: "/chatting/" + i,
		data: JSON.stringify(chatObj),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			chatRespObj = JSON.parse(data);
			chatContentAppend(chatObj.id, chatRespObj);
		

		},
		error: function() {
			alert('비동기 처리 실패');
		}
	});
	}, 3000);
}

function chatSend(i) {
	chatObj.item_code = chatinfo[i * 4].value;
	chatObj.buyer_id = chatinfo[(i * 4) + 1].value;
	chatObj.seller_id = chatinfo[(i * 4) + 2].value;
	chatObj.writer_id = chatinfo[(i * 4) + 3].value;
	chatObj.chat_content = msginput[i].value;
	if(msginput[i].value!=''){
	$.ajax({
		type: "POST",
		url: "/chat-insert",
		data: JSON.stringify(chatObj),
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		success: function(data) {
			msginput[i].value='';
			EnterInChatRoom(i);
		}, error() {

		}
	});
	}
}


for(let i = 0; i < msginput.length; i++){


	
	msginput[i].onkeypress = () => {
		if (window.event.keyCode == 13) {
			window.event.preventDefault();
			chatSend(i);
		}
	}
}

for(let i = 0; i < submitbtn.length; i++){
	submitbtn[i].onclick = () => {
		chatSend(i);
	}
}
for(let i=0; exit.length;i++){
	deletelist(i);
}
function deletelist (i) {
	chatObj.item_code = chatinfo[i * 4].value;
	chatObj.buyer_id = chatinfo[(i * 4) + 1].value;
	chatObj.seller_id = chatinfo[(i * 4) + 2].value;
	exit[i].onclick = () => {
if(confirm("이 대화방을 나가시겠습니까?\n 나가시면 채팅방의 대화기록이 사라집니다")){
			$.ajax({
			type: "delete",
			url: "/list-delete",
			data: JSON.stringify(chatObj),
			contentType: "application/json;charset=UTF-8",
			dataType: "text",
			success: function(data) {
				location.reload();
				alert("채팅방에서 나갔습니다");
			},
			error: function() {
				alert('비동기 처리 실패');
			}
			})
			}
	}
}