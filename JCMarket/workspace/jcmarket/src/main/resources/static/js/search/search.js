const items_time = document.querySelectorAll('.item_time');


//검색 페이지 로드시 로드가 된 후 foreach를 돌려서 시간을 하나씩 설정해준다. 
items_time.forEach((item_time) => {
	let update_date = item_time.textContent;

   let updateDate = new Date(update_date);
  
   let now = new Date();
   let betweenTime = Math.floor((now.getTime()-updateDate.getTime())/1000/60/60);
 
   if(betweenTime < 24) {
	   item_time.textContent = `${betweenTime}시간 전`;
   }else {
	   let betweenDay =  Math.floor(betweenTime / 24);
	   item_time.textContent = `${betweenDay}일 전`;
   } 
	
   });







