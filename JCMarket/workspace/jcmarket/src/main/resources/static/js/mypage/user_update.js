const update_form = document.querySelector('.sign_form');
const user_info = document.querySelectorAll('.user_info');
const inputs = document.querySelectorAll('.input');
const submit_btn = document.querySelector('.submit_btn');

var updateData = {
    user_id: user_info[2].value,
    user_password: '',
    user_name: user_info[0].value,
    user_phone: user_info[1].value,
    user_nickname: ''
}

var checkNicknameResult;
var passwordFormatResult;
var nicknameFormatResult;
var checkPasswordResult;

//blur input 
inputs.forEach((input, inputIndex) => {
    input.addEventListener('blur', () => checkEmpty(input, inputIndex));

});

function serviceConfirm(inputIndex, confirmContent) {
    if (inputIndex == 0) {
        if (confirm('값이 입력되지 않았습니다. 그대로 진행하시겠습니까?')) {
            console.log('값 없음')
        }
        return;
    }
    if (confirm(`${confirmContent} 값이 입력되지 않았습니다. 그대로 진행하시겠습니까?`)) {
    }
}

//비어있는지 체크
function checkEmpty(input, inputIndex) {
    clearMsg(input);
    if (input.value.length == 0) {
        return;
    }

    //비밀번호
    if (inputIndex == 0) {
        passwordFormatResult = checkPasswordFormat(updateData.user_id, input.value, input);

        //비밀번호 확인
    } else if (inputIndex == 1) {
        checkRepassword(inputs[inputIndex - 1].value, input.value, input);

        //닉네임  
    } else if (inputIndex == 2) {
        nicknameFormatResult = checkNicknameFormat(input);
        if (nicknameFormatResult == true) {
            Checknickname(input);
        }
    }
}


submit_btn.addEventListener('click', () => {

    inputs.forEach((input, inputIndex) => {

        checkEmpty(input, inputIndex);
    });
    if (inputs[0].value.length == 0 && inputs[1].value.length == 0 && inputs[2].value.length == 0) {
        serviceConfirm(0);
        return;
    }
    //닉네임 값은 있는데 비밀번호 값이 없을 때
    if (inputs[2].value.length != 0 && inputs[0].value.length == 0) {
        serviceConfirm(1, '비밀번호');
        return;
    }
    //비밀번호 값이 없는 상태에서 비밀번호 재확인에 입력 하려고 할때
    if (inputs[0].value.length == 0 && inputs[1].value.length != 0) {
        clearMsg(inputs[1]);
        alert('비밀번호를 먼저 입력해주세요.');
        inputs[1].value = '';
        inputs[0].focus();
        return;
    }
    //비밀번호 값은 있는데 닉네임 값은 없을때 
    if (inputs[0].value.length != 0 && inputs[2].value.length == 0) {
        //비밀번호 값은 있는데 닉네임 값은 없을때 password정규식이 맞지 않으면 alert창을 띄우지않고
        //오류 메시지 출력
        if (passwordFormatResult == false) {
            return;
        }
        serviceConfirm(1, '닉네임');
        return;
    }

});


//비밀번호 정규식 체크 
function checkPasswordFormat(id, password, input) {


    let check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$/.test(password);   //영문,숫자
    let check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$/.test(password);  //영문,특수문자 
    let check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$/.test(password);  //특수문자, 숫자

    if (password.length >= 14) {
        msgService(input, '14자 이내로 입력해주세요. ');
        return false;
    }

    if (!(check1 || check2 || check3)) {
        msgService(input, '사용할 수 없는 조합입니다');
        return false;
    }

    if (/(\w)\1\1/.test(password)) {
        msgService(input, '같은 문자를 3번 이상 사용하실 수 없습니다.');
        return false;

    }
    if (password.search(id) > -1) {
        msgService(input, '비밀번호에 아이디가 포함되었습니다.');
        return false;

    }
    return true;

}

//비밀번호 일치 체크 
function checkRepassword(password, repassword, input) {
    if (password != repassword) {
        msgService(input, '비밀번호가 일치하지 않습니다. ');
        testPasswordValue = input.value;
        checkPasswordResult = 2;
        return;
    } else {
        checkPasswordResult = 1;
        updateData.user_password = input.value;
        return;
    }

}

//닉네임 정규식 체크 
function checkNicknameFormat(input) {
    nickname = input.value;

    if (nickname.search(/\s/) != -1) {
        msgService(input, '공백을 포함할 수 없습니다. ');

        return false;
    } else if (nickname.length < 2 || nickname.length > 13 || /[`~!@#$%^&*|\\\'\";,.:\/?]/gi.test(nickname) == true) {
        msgService(input, '2~13이내의 영문과 숫자만 사용 가능합니다. ');
        checkNicknameResult = 2;
        return false;
    }
  
    return true;

}

//닉네임 중복확인 
function Checknickname(input) {
    $.ajax({
        type: "get",
        url: "nickname-check",
        data: {
            signUpNickname: input.value,
        },
        dataType: 'text',
        success: function (data) {
            if (data == 1) {
                msgService(input, `${input.value} 는 이미 존재하는 닉네임입니다.`);
                checkNicknameResult = 2;
            } else if (data == 0) {
                msgService(input, '사용가능한 닉네임입니다. ');
                updateData.user_nickname = input.value;
                checkNicknameResult = 1;
            }

        },
        error: function () {
            alert('오류가 발생했습니다. 다시시도해주세요. ');
        }
    })
}

// 메세지 제거
function clearMsg(input) {
    console.log(input)
    while (input.nextElementSibling.tagName == 'P') {
        input.nextElementSibling.remove();
    }
}

//메세지 만들어서 추가
function msgService(input, msgContent) {
    const p = document.createElement('p');
    p.textContent = msgContent;
    p.classList.add('msg');
    input.after(p);
}


