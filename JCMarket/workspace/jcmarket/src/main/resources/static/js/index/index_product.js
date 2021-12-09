const items_time = document.querySelectorAll('.item_time');
const item_list = document.querySelectorAll('.item_list');

console.log(items_time[0].textContent);



//검색 페이지 로드시 로드가 된 후 foreach를 돌려서 시간을 하나씩 설정해준다. 
items_time.forEach((item_time) => {
	let update_date = item_time.textContent;

   let updateDate = new Date(update_date);
   
   let now = new Date();
   let betweenTime = Math.floor((now.getTime()-updateDate.getTime())/1000);
      console.log(betweenTime);
   if(betweenTime < 60) { 
       item_time.textContent = '방금';
   }else if(betweenTime >= 60 && betweenTime < 3600) {
	    let betweeMinute =  Math.floor(betweenTime/60);
	  item_time.textContent = `${betweeMinute}분 전`;
   }else if(betweenTime >= 3600 && betweenTime < 86400) {
	   let betweenHours =  Math.floor(betweenTime /60/60);
	   item_time.textContent = `${betweenHours}시간 전`;
   }else if(betweenTime >= 86400){
	   let betweenDay =  Math.floor(betweenTime/60/60/24);
	   item_time.textContent = `${betweenDay}일 전`;
   } 
	
   });