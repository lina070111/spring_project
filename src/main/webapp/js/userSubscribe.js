/**
 * 
 */
const subperiod = function() {
	console.log("구독기간");
	const idx =document.querySelector('#idx').value;
	console.dir(idx);
		$.ajax({
	        type: 'POST',
	        url:'getSubscribe.do',
			data:{"id": idx},
	        dataType:'json', //JSON.pase
	        success: function(data){
	        	console.log("성공?");
				console.log(data.start_date); 
				console.log(data.end_date); 
				const hiddenStart_date = document.querySelector('#hiddenStart_date');
				const start_date = document.querySelector('#start_date');
				hiddenStart_date.value = data.start_date;
				
				
				let today = new Date();
				var convertedDate = convertDateFormat(today);
			    console.log(convertedDate);
				console.log("날짜?" + today);
				
				start_date.value = data.end_date
				start_date.min = data.end_date				
			    var year = start_date.value.substring(0,4);
			    var month = start_date.value.substring(5,7);
			    var day = start_date.value.substring(8,10);
			    const date = new Date(year, month-1, day);
			    date.setDate(date.getDate() + 30);
			    var convertedDate1 = convertDateFormat(date);
			    console.log(convertedDate1);
			    const end_date = document.querySelector('#end_date');
			    end_date.value=convertedDate1;
				if(data.end_date < convertedDate){
					console.log("진짜날짜?" + convertedDate);					
					$('#period_c').text("구독중이 아닙니다")
					$("#period_c").css("color","red")
					start_date.value = convertedDate
				}else{
					console.log(";;;;" );	
					$('#period_c').text(data.start_date +" ~ " +data.end_date);
					const date1 = new Date(year, month-1, day+1);
					start_date.max=convertedDate;
				}
				
	        	  
	        },
	        error: function(request, status,error){
	        	console.log("실패"); 
	            console.log(status,error);
	        }
	    });
	}

const subpoint = function() {
	console.log("보유포인트");
	const idx =document.querySelector('#idx').value;
	console.log(idx);
		$.ajax({
	        type: 'POST',
	        url:'getUserPoint.do',
			data:{"id": idx},
	        dataType:'json', //JSON.pase
	        success: function(data){
	        	console.log("성공이냥?");
				console.log(data); 
				$('#point').text(data);
				const hiddenPoint = document.querySelector('#hiddenPoint');
				hiddenPoint.value =data;
	        },
	        error: function(request, status,error){
	        	console.log("실패"); 
	            console.log(status,error);
	        }
	    });
	}

function changePeriod(){
	console.log("changePeriod")
	var month = document.querySelector('#period');
	var monthIndex = document.querySelector('#period').options.selectedIndex;
	var payment = document.querySelector('#payment');
	console.log(month);
	console.log(monthIndex);
	const start_date = document.querySelector('#start_date');
    var year = start_date.value.substring(0,4);
    var months = start_date.value.substring(5,7);
    var day = start_date.value.substring(8,10);
    const date = new Date(year, months-1, day);
	console.log(date)
	if(month.options[monthIndex].value ==1){
		console.log("1개월")
		payment.value = 5000;
		date.setDate(date.getDate() + 30);
	    var convertedDate = convertDateFormat(date);
	    console.log(convertedDate);
	    const end_date = document.querySelector('#end_date');
	    end_date.value=convertedDate;
		console.log(payment.value);
	}else if(month.options[monthIndex].value ==3){
		console.log("3개월")
		payment.value = 13500;
		date.setDate(date.getDate() + 90);
	    var convertedDate = convertDateFormat(date);
	    console.log(convertedDate);
	    const end_date = document.querySelector('#end_date');
	    end_date.value=convertedDate;
		console.log(payment.value);
	}else if(month.options[monthIndex].value ==6){
		console.log("6개월")
		payment.value = 24000;
		date.setDate(date.getDate() + 180);
	    var convertedDate = convertDateFormat(date);
	    console.log(convertedDate);
	    const end_date = document.querySelector('#end_date');
	    end_date.value=convertedDate;
		console.log(payment.value);
	}else if(month.options[monthIndex].value ==12){
		console.log("12개월")
		payment.value = 30000;
		date.setDate(date.getDate() + 365);
	    var convertedDate = convertDateFormat(date);
	    console.log(convertedDate);
	    const end_date = document.querySelector('#end_date');
	    end_date.value=convertedDate;
		console.log(payment.value);
	}
}
const check = function() {
	console.log("구독");
		
	console.log("payment : "+payment.value);
	var pay= parseInt(payment.value)
	var point = parseInt($('#point').text());
	console.log(pay);
	console.log(point);
	const idx =document.querySelector('#idx').value;
	const hiddenStart_date = document.querySelector('#hiddenStart_date');
	
	if(point<pay){
		if (!confirm("포인트가 부족합니다. 충전하시겠습니까?")) {
	        // 취소(아니오) 버튼 클릭 시 이벤트
	        return;
	    } else {
	        location.href ="userPoint.jsp?id="+idx;
	    	 return;
	    }
	}else{
		if (!confirm("결제를 진행합니다.")) {
	        // 취소(아니오) 버튼 클릭 시 이벤트
	        return;
	    } else {
	        // 확인(예) 버튼 클릭 시 이벤트
if(hiddenStart_date.value=='0000-00-00'){
		console.log("성공????");
		hiddenStart_date.value=start_date.value;
		console.log(hiddenStart_date.value); 
	}
			document.userModifyForm.submit();
	    }
	}
	console.log(pay);
	console.log(point);
	//if(${point})


}

function convertDateFormat(date) {
	console.log("date");
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    month = month >= 10 ? month : '0' + month;
    var day = date.getDate();
    day = day >= 10 ? day : '0' + day;
    return [year, month, day].join('-');
}

$(document).ready(function () {
	subperiod();
	subpoint();
	const start_date = document.querySelector('#start_date');
  	const idx =document.querySelector('#idx').value;
    const Mbtn = document.querySelector('#userModifybtn');
    Mbtn.onclick = function () {
    	check();
    }
	const Pbtn = document.querySelector('#userPoint');
    Pbtn.onclick = function () {
		console.log("포인트충전");
    	location.href ="userPoint.jsp?id="+idx;
    }
})
