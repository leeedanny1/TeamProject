const insert_form = document.querySelector('#insert_form')
const insert_btn = document.querySelector('.item_insert_btn')
const cancel_btn = document.querySelector('.item_cancel_btn')


// 상품등록
insert_btn.onclick = () => {
    let formData = new FormData(insert_form)

    if(confirm("상품을 등록하시겠습니까?")){
        $.ajax({
            type: "post",
            url: "/items/insert",
            data: formData,
            enctype: "form-data",
            processData: false,
            contentType: false,
            success: function(data){
                if(data == 1){
                    alert("상품이 성공적으로 등록되었습니다.")
                    location.replace("/items/new/1")
                } else {
                    alert("상품등록을 실패했습니다. (service오류)")
                }
            },
            error: function(){
                alert("상품등록을 실패했습니다. (비동기 처리 오류)")
            }
        })
    }
}


// 상품등록취소버튼
cancel_btn.onclick = () => {
    if(confirm("상품등록을 취소하고, 상품목록으로 돌아가사겠습니까?")){
        location.replace("/items/new/1")
    }
}