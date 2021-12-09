const item_update_btn = document.querySelector(".item_update_btn")
const item_cancel_btn = document.querySelector(".item_cancel_btn")
const update_form = document.querySelector("#update_form")


// 상품수정
item_update_btn.onclick = () => {
    let formData = new FormData(update_form)

    const item_code = formData.get("item_code")
    const item_title = formData.get("item_title")

    if(confirm("상품명: " + item_title + "\n해당 상품을 정말 수정하시겠습니까?")){
        $.ajax({
            type: "put",
            url: "/items/update",
            enctype: "form-data",
            data: formData,
            processData: false,
            contentType: false,
            success: function(data){
                if(data == 1){
                    alert("상품이 정상적으로 수정되었습니다.")
                    location.replace("/items/" + formData.get("item_code"))
                } else{
                    alert("상품 수정을 실패하였습니다. (Service오류)")
                }
            },
            error: function(){
                alert("상품 수정을 실패했습니다. (비동기 처리 오류)")
            }

        })
    }
}