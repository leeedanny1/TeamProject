const update_date = document.querySelector('.update_date');
const item_time = document.querySelector('.item_time');


let updateDate = new Date(update_date.value);
let now = new Date();
let betweenTime = Math.floor((now.getTime()-updateDate.getTime())/1000/60/60);

if(betweenTime < 24) {
	item_time.textContent = `${betweenTime}시간 전`;
}else {
	let betweenDay =  Math.floor(betweenTime / 24);
	item_time.textContent = `${betweenDay}일 전`;
}
