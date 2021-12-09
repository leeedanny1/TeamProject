const product_update_btn = document.querySelector(".product_update_btn")

// 수정하기 연결
product_update_btn.onclick = () => {
    const item = document.querySelector('#item_title_value')
    const code = document.querySelector('.item_code')

    if(confirm("상품명: " + item.textContent + "\n상품을 수정하시겠습니까?")){
        console.log(code.value)
        location.href = "/items/update/" + code.value
    } else {
        alert("상품 수정을 취소하였습니다.")
    }
}