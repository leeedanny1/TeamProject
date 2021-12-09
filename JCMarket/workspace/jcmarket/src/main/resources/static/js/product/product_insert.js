const insert_form = document.querySelector('#insert_form')
const insert_btn = document.querySelector('.item_insert_btn')
const cancel_btn = document.querySelector('.item_cancel_btn')

const item_title = document.querySelector('#item_title')
const item_price = document.querySelector('#item_price')
const item_stat = document.querySelector('#item_stat')
const item_change = document.querySelector('#item_change')
const item_delivery = document.querySelector('#item_delivery')
const item_content = document.querySelector('#item_content')


// 상품등록
insert_btn.onclick = () => {
    let formData = new FormData(insert_form)
    
    if(confirm("상품을 등록하시겠습니까?")){
        if(item_title.value == ''){
            alert("상품명을 입력해 주세요.")
            item_title.focus();
            return;
        } else if(item_price.value == ''){
            alert("상품 가격을 입력해 주세요.")
            item_price.focus();
            return;
        } else if(item_stat.value == "null"){
            alert("상품 상태를 선택해 주세요.")
            item_stat.focus();
            return;
        } else if (item_change.value == "null"){
            alert("교환 여부를 선택해 주세요.")
            item_change.focus();
            return;
        } else if (item_delivery.value == "null"){
            alert("배송비 부담 방법을 선택해 주세요.")
            item_delivery.focus();
            return;
        } else if(item_content.value == ''){
            alert("상품설명을 입력해 주세요.")
            item_content.focus();
            return;
        } else{
            $.ajax({
                type: "post",
                url: "/items/insert",
                data: formData,
                enctype: "multipart/form-data",
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
}


// 상품등록취소버튼
cancel_btn.onclick = () => {
    if(confirm("상품등록을 취소하고, 상품목록으로 돌아가사겠습니까?")){
        location.replace("/items/new/1")
    }
}