const notice_delete_btn = document.querySelector(".notice_delete_btn")




// 공지사항 삭제
notice_delete_btn.onclick = () => {
    const notice_code = document.querySelector("#notice_code")
    const notice_title = document.querySelector("#notice_title")

    if (confirm("글 번호: " + notice_code.value + "\n글 제목: " + notice_title.value + "\n해당 공지사항을 정말 삭제하시겠습니까?")) {
        $.ajax({
            type: "delete",
            url: "/notice/delete/" + notice_code.value,
            dataType: "text",
            success: function (data) {
                if (data == 1) {
                    alert(notice_code.value + "번 공지사항이 성공적으로 삭제되었습니다.");
                    location.replace('/notice/list/1');
                } else if (data == 0) {
                    alert("공지사항 삭제 실패! (DB 처리 오류)")
                }
            },
            error: function () {
                console.log(notice_code.value)
                alert("삭제 실패! (비동기 처리 오류)")
            }
        })
    } else {
        alert("공지사항 삭제를 취소하였습니다.")
    }
}




