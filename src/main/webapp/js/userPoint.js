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
				$('#period_c').text(data.start_date +" ~ " +data.end_date)
				let today = new Date();
				console.log("날짜?" + today);
			    var convertedDate = convertDateFormat(today);
			    console.log(convertedDate);
				if(data.end_date < convertedDate){
					console.log("진짜날짜?" + convertedDate);
					$('#period_c').text("구독중이 아닙니다")
					$("#period_c").css("color","red")
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
	        },
	        error: function(request, status,error){
	        	console.log("실패"); 
	            console.log(status,error);
	        }
	    });
	}


const check = function() {
	console.log("포인트 충전");
	const charge = document.querySelector('#charge');
	const point = $('#point').text();
	var poin_cha = parseInt(charge.value) + parseInt(point)
	console.log(poin_cha);
	const point_charge = document.querySelector('#point_charge');
	point_charge.value =poin_cha
	if (!confirm("포인트를 충전하시겠습니까?")) {
	        // 취소(아니오) 버튼 클릭 시 이벤트
	        return;
	    } else {
	        location.href ="userPoint.jsp?id="+idx;
	    	 document.updateUserPoint.submit();;
	    }
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
  
    const Mbtn = document.querySelector('#userPointbtn');
    Mbtn.onclick = function () {
    	check();
    }
})
