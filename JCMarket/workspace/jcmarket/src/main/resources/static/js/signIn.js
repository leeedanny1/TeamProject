const submit_btn=document.querySelector('.submit_btn');
const item_ip=document.querySelectorAll('.item_ip');
const e_msg= document.querySelectorAll('.e_msg');

item_ip[0].onblur = () => {
    if(item_ip[0].value.length==0){
        e_msg[0].style.display = 'block';
    }else {
        e_msg[0].style.display = 'none';
    }
}
item_ip[1].onblur = () => {
    if(item_ip[1].value.length==0){
        e_msg[1].style.display = 'block';
    }else {
        e_msg[1].style.display = 'none';
    }
}
item_ip[0].onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
		item_ip[1].focus();
	}
}

item_ip[1].onkeypress = () => {
	if(window.event.keyCode == 13){
		window.event.preventDefault();
		// signInService();
	}
}