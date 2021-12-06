const notice_update_btn = document.querySelector(".notice_update_btn")

// 수정하기 연결
notice_update_btn.onclick = () => {
    const notice_code = document.querySelector("#notice_code")

    if(confirm(notice_code.value + "번 공지사항을 수정하시겠습니까?")){
        location.href = "/notice/update/" + notice_code.value
    } else {
        alert("공지사항 수정을 취소하였습니다.")
    }
}




