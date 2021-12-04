const msginput = document.querySelector('.msginput');
const submitbtn = document.querySelector('.submitbtn');
const chatlist_btn = document.querySelectorAll('.chatlist_btn');
const chatinfo= document.querySelectorAll('.chatinfo');

var chatinfo1 = {
	item_code : chatinfo[0].value,
	buyer_id :chatinfo[1].value,
	seller_id :chatinfo[2].value,
	chat_content: '',
	writer_nickname :chatinfo[3].value
}
msginput.onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
		chatinfo1.chat_content=msginput.value;
		submit();
	}
}

	console.log('123');
submitbtn.onclick = () => {
	chatinfo1.chat_content=msginput.value;
	alert(chatinfo1.chat_content);
	alert(chatinfo1.item_code);
	alert(chatinfo1.buyer_id);
	alert(chatinfo1.seller_id);
	alert(chatinfo1.writer_nickname);
	$.ajax({
		type: "POST",
		url: "/chat-insert",
		 data: JSON.stringify(chatinfo1),
		 contentType: "application/json;charset=UTF-8",
	 	 dataType: "text",
		success: function(data) {
			alert(JSON.stringify(chatinfo1))
		},error(){
		
		}
	});

}