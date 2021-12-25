const items_time = document.querySelectorAll('.item_time');
const item_list = document.querySelectorAll('.item_list');



//검색 페이지 로드시 로드가 된 후 foreach를 돌려서 시간을 하나씩 설정해준다. 
items_time.forEach((item_time) => {
    let update_date = item_time.textContent;

    let updateDate = new Date(update_date);

    let now = new Date();
    let betweenTime = Math.floor((now.getTime() - updateDate.getTime()) / 1000);
    console.log(betweenTime);
    if (betweenTime < 60) {
        item_time.textContent = '방금';
    } else if (betweenTime >= 60 && betweenTime < 3600) {
        let betweeMinute = Math.floor(betweenTime / 60);
        item_time.textContent = `${betweeMinute}분 전`;
    } else if (betweenTime >= 3600 && betweenTime < 86400) {
        let betweenHours = Math.floor(betweenTime / 60 / 60);
        item_time.textContent = `${betweenHours}시간 전`;
    } else if (betweenTime >= 86400) {
        let betweenDay = Math.floor(betweenTime / 60 / 60 / 24);
        item_time.textContent = `${betweenDay}일 전`;
    }

});

//search페이지 처음 로드시 기본적으로 10개는 보여준다. 
for (let i = 0; i < 10; i++) {
    item_list[i].classList.add('showItem');
}


//window 스크롤 시 fadeIn효과 
document.addEventListener('scroll', () => {
    //화면의 bottom 값 구하기 = 스크롤된 값 + 네비게이션바를 제외한 화면 전체 높이 
    let scrollBottom = window.scrollY + window.innerHeight;
    //각각의 아이템들을 하나씩 추출 
    for (let item of item_list) {
        //item의 half구하기 = 각각의 item들의 높이에서 2를 나눈다. + 네비게이션바를 제외하고 화면 가장 top부분부터 요소가 위치하는 곳(고정값임) 
        //2로 나누는 이유는 요소(item)의 반쯤에 도달하면 보여주기 위해  
        let itemHalf = item.offsetHeight / 2 + item.offsetTop;
        //만약 itemHalf 보다  scrollBottom의 값이 크다면 
        if (scrollBottom > itemHalf) {
            //보여주고 
            item.classList.add('showItem');
            //작다면      
        } else {
            //보여주지 않는다. 
            item.classList.remove('showItem');
        }
    }
});






