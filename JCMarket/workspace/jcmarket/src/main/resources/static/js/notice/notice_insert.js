const insert_form = document.querySelector("#insert_form")
const notice_insert_button = document.querySelector(".notice_insert_button")
const notice_cancel_button = document.querySelector(".notice_cancel_button")


// 공지사항 등록
notice_insert_button.onclick = () => {
    let formData = new FormData(insert_form)

    if(confirm("공지사항을 등록하시겠습니까?")){
        $.ajax({
            type: "post",
            url: "/notice/insert",
            data: formData,
            enctype: "form-data",
            processData: false,
            contentType: false,
            success: function(data){
                if(data == 1){
                    alert("공지사항 등록이 완료되었습니다.")
                    location.replace("/notice/list")
                } else {
                    alert("공지사항 등록에 실패하였습니다. (DB오류)")
                }
            },
            error: function(){
                alert("공지사항 등록 실패 (비동기 처리 오류)")
            }
        })
    }
}


// 공지사항 등록취소 버튼
notice_cancel_button.onclick = () => {
    if(confirm("공지사항 등록을 취소하고, 공지사항 목록으로 돌아가시겠습니까?")){
        location.replace("/notice/list")
    }
}



