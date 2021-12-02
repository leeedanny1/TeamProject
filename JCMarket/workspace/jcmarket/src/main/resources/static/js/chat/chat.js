const msginput = document.querySelector('.msginput');
const submitbtn = document.querySelector('.submitbtn');
const chatlist_btn= document.querySelectorAll('.chatlist_btn');


msginput.onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
		submitmsg();
	}
}

function chatting(){
	$.ajax({
		type:"get",
		url:"chatting",
	})
}