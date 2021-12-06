const submit_btn=document.querySelector('.submit_btn');
const item_ip=document.querySelectorAll('.item_ip');
const e_msg= document.querySelectorAll('.e_msg');
const find_id = document.querySelector('.find_id');
const find_password = document.querySelector('.find_password');

var signInData = {
	user_id: '',
	user_password: '',
}
function msgservice(i){
        if(item_ip[i].value.length==0){
            e_msg[i].style.display = 'block';
        }else {
            e_msg[i].style.display = 'none';
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
for(let i=0;i<item_ip.length;i++){

    item_ip[i].onblur =()=>{
        msgservice(i);
         if(item_ip[0].value.length!=0&&item_ip[1].value.length!=0){
            submit_btn.style.opacity = 1;
             }
        }
}

find_id.addEventListener('click', () => {
	
});

find_password.addEventListener('click', () => {
	
});

