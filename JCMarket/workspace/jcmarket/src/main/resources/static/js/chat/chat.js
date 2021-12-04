const msginput = document.querySelector('.msginput');
const submitbtn = document.querySelector('.submitbtn');
const chatlist_btn= document.querySelectorAll('.chatlist_btn');


notice_insert_button.onclick = () => {
    let formData = new FormData(chatting)

msginput.onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
		chatting();
	}
}

function chatting(){
	  $.ajax({
            type: "put",
            url: "/chatting",
            data: formData,
            enctype: "form-data",
            processData: false,
            contentType: false,
            success: function(data){
            },
            error: function(){
            }
        })
}
}