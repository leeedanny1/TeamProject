const notice_update_button = document.querySelector(".notice_update_button")
const notice_cancel_button = document.querySelector(".notice_cancel_button")
const update_form = document.querySelector("#update_form")


// 공지사항 업데이트
notice_update_button.onclick = () => {
    let formData = new FormData(update_form)

    const notice_code = formData.get("notice_code")
    const notice_title = formData.get("notice_title")

    if(confirm("글 번호: " + notice_code + "\n글 제목: " + notice_title + "\n해당 공지사항을 정말 수정하시겠습니까?")){
        $.ajax({
            type: "put",
            url: "/notice/update",
            enctype: "form-data",
            data: formData,
            processData: false,
            contentType: false,
            success: function(data){
                if(data == 1){
                    alert("공지사항이 정상적으로 수정되었습니다.")
                    location.replace("/notice/" + formData.get("notice_code"))
                }
            }
        })
    }
}



// 공지사항 업데이트 취소
notice_cancel_button.onclick = () => {
    const notice_code = document.querySelector("#notice_code")
    if(confirm("공지사항 수정을 취소하고, " + notice_code.value + "번 공지사항으로 돌아가시겠습니까?")){
        location.replace("/notice/" + notice_code.value)
    }
}