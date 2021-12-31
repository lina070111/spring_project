const check = function() {	
	$.ajax({
        type: 'POST',
        url:'getFreeBoardListIndexJson.do',
        dataType:'json', //JSON.pase
        success: function(data){
        	console.log("성공"); 
        	let html='<tr></tr>';
        	for(let item of data){
   
        		html += '<tr>';
                html += ('<td class="freetitle">' + '<a href="getFreeBoard.do?freeseq='+item.freeseq+'">'+ item.title + '</a>'+'</td>');
                html += ('<td>' + item.writer + '</td>');
                html += '</tr>'; 
            }
        	const freeArea = document.querySelector('#freeArea');
        	freeArea.innerHTML = html;  
  
        },
        error: function(request, status,error){
        	console.log("실패"); 
            console.log(status,error);
        }
    });
	
	$.ajax({
        type: 'POST',
        url:'getnewsBoardListNewsJson.do',
        dataType:'json', //JSON.pase
        success: function(data){
        	console.log("성공"); 
        	console.log(data[0].filename); 
        	let html2 = '<a href="getNewsBoard.do?newsseq='+data[0].newsseq+'"><img src="images/'+data[0].filename+'" width="230px;" height="150px;"></a>';
        	const newsImg = document.querySelector('#newsImg');
        	newsImg.innerHTML = html2;  
        	let html='<tr></tr>';
        	
        	for(let item of data){
        		html += '<tr>';
                html += ('<td class="newstitle">' + '<a href="getNewsBoard.do?newsseq='+item.newsseq+'">'+ item.title + '</a>'+'</td>');
                html += ('<td>' + item.writer + '</td>');
                html += '</tr>';
            }
        	const newsArea = document.querySelector('#newsArea');
        	newsArea.innerHTML = html;  
  
        },
        error: function(request, status,error){
        	console.log("실패"); 
            console.log(status,error);
        }
    });
}



$(document).ready(function () {
	check();
})