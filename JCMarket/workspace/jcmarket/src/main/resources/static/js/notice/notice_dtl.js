const notice_update_btn = document.querySelector(".notice_update_btn")

// 수정하기 연결
notice_update_btn.onclick = () => {
    const notice_code = document.querySelector("#notice_code")
    location.href = "/notice/update/" + notice_code.value
}




