const product_delete_btn = document.querySelector(".product_delete_btn")


// 상품삭제
product_delete_btn.onclick = () => {
    const item_code = document.querySelector(".item_code")
    const item_title_value = document.querySelector("#item_title_value")
    const item_title = item_title_value.textContent

    if(confirm("상품명: " + item_title + "\n해당 상품을 정말 삭제하시겠습니까?")){
        $.ajax({
            type: "delete",
            url: "/items/delete/" + item_code.value,
            dataType: "text",
            success: function(data){
                if(data == 1){
                    alert("상품명: " + item_title + "\n해당 상품이 정상적으로 삭제되었습니다.")
                    location.replace("/items/new/1")
                } else {
                    alert("상품삭제를 실패했습니다. (Service 오류)")
                }
            },
            error: function(){
                alert("상품삭제를 실패했습니다. (비동기 처리 오류)")
            }
        })
    } else{
        alert("상품 삭제를 취소하였습니다.")
    }
}