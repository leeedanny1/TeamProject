const notice_update_button = document.querySelector(".notice_update_button")
const update_form = document.querySelector("#update_form")


notice_update_button.onclick = () => {
    let formData = new FormData(update_form)

    const notice_code = document.querySelector("#notice_code")
    const notice_title = document.querySelector("#notice_title")

    if(confirm("글 번호: " + notice_code.value + "\n글 제목: " + notice_title.value + "\n해당 공지사항을 정말 수정하시겠습니까?")){
        $.ajax({
            type: "put",
            url: "/notice/update/" + formData.get("notice_code"),
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