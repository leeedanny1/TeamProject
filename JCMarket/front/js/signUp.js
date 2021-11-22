const inputs = document.querySelectorAll('.input');
const submit_btns = document.querySelectorAll('.submit_btn');
const sign_form = document.querySelectorAll('.sign_form');

var signUpData = {
    signUpEmail: '',
    signUpPassword: '',
    signUpPhone: '',
    signUpName:'',
    
}

//blur input
inputs.forEach((input, inputIndex) => {
     input.addEventListener('blur', () => checkEmpty(input,inputIndex));
});

//click submit_btn
submit_btns.forEach((submitBtn, submitBtnIndex) => {
    console.log(submitBtnIndex)
    submitBtn.addEventListener('click', () => onSubmit(submitBtn,submitBtnIndex));
});


//비어있는지 체크
function checkEmpty(input, inputIndex) {
    clearMsg(input);
    if(input.value.length == 0){
        magService(input, '필수항목입니다.');
    }
    if(inputIndex == 0) {
       
    }
}

// 메세지 제거
function clearMsg(input) {
    while(input.nextElementSibling.tagName == 'P'){
        input.nextElementSibling.remove();
    }
}

//메세지 만들어서 추가
function magService(input,msgContent) {
    const p =document.createElement('p');
    p.textContent = msgContent;
    p.classList.add('msg');
    input.after(p);
}

function onSubmit(submitBtn, submitBtnIndex) {
     
     if(submitBtnIndex == 0) {
        sign_form[submitBtnIndex].classList.add('invisible');
        sign_form[submitBtnIndex + 1].classList.add('visible');
     }
}
