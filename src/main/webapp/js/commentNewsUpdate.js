/**
 * 
 */
const updateGetNews = function() {
	console.log("글수정");
	const idx1 =document.querySelector('#idx1').value;
	const idx2 =document.querySelector('#idx2').value;
	console.log(idx1);
	console.log(idx2);
	if(idx1 === idx2){
		alert("글쓴이 동일")
		updateNewsBoard.submit();
	}else{
		alert("본인이 쓴글만 수정가능합니다.")
		return;
	}
	
}

const deleteGetNews = function() {
	console.log("글삭제");
	const idx1 =document.querySelector('#idx1').value;
	const idx2 =document.querySelector('#idx2').value;
	const newsseq =document.querySelector('#newsseq').value;
	console.log(idx1);
	console.log(idx2);
	if(idx1 === idx2){
		alert("글쓴이 동일")
		location.href ="deleteNewsBoard.do?newsseq="+newsseq;
	}else{
		alert("본인이 쓴글만 삭제가능합니다.")
		return;
	}
	
}

const UpComment = function() {
	 const newUpComment = document.querySelector('#newUpComment');
	 $("#newUpComment").show();
}

const updateCommnetCancel = function() {
	 $("#newUpComment").hide();
}

const updateCommnet = function() {

	var coseq =  $("#coseq").val(); 
	var content =  $("#content").val();  
	console.log(coseq);
	console.log(content);
	
	$.ajax({
        type: 'POST',
        url:'updateCommentNewsJson.do',
        dataType:'json', //JSON.pase
        data:{"coseq":coseq, "content":content},
        success: function(data){
        	console.log("성공");
        	
        $.ajax({
        type: 'POST',
        url:'getCommentNewsJson.do',
        dataType:'json', //JSON.pase
        data:{"coseq":coseq},
        success: function(data){
        	console.log("성공");
        	console.log(content);
        	$("#newUpComment").hide();
        	$("#insertCommnetContent").text(content);
        	console.log($("#insertCommnetContent").text(content));
        	
        },
        error: function(request, status,error){
        	console.log("실패");   
        	console.log(status,error);
        }
    });	
        	
        },
        error: function(request, status,error){
        	console.log("실패");   
        	console.log(status,error);
        }
    });	
    
}



$(document).ready(function () {
	const upbtn = document.querySelector('#updateGetNews');
	const debtn = document.querySelector('#deleteGetNews');
    const btn = document.querySelector('#updateCommnet');
    const btnCancel = document.querySelector('#updateCommnetCancel');
    console.log(btn);
	upbtn.onclick = function () {
    	updateGetNews();
    }
	debtn.onclick = function () {
    	deleteGetNews();
    }
    btn.onclick = function () {
    	updateCommnet();
    }
    btnCancel.onclick = function () {
    	updateCommnetCancel();
    }
})  
