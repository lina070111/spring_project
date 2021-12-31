/**
 * 
 */

const updateGetFree = function() {
	console.log("글수정");
	const idx1 =document.querySelector('#idx1').value;
	const idx2 =document.querySelector('#idx2').value;
	console.log(idx1);
	console.log(idx2);
	if(idx1 === idx2){
		alert("글쓴이 동일")
		updateFreeBoard.submit();
	}else{
		alert("본인이 쓴글만 수정가능합니다.")
		return;
	}
	
}
const deleteGetFree = function() {
	console.log("글삭제");
	const idx1 =document.querySelector('#idx1').value;
	const idx2 =document.querySelector('#idx2').value;
	const freeseq =document.querySelector('#freeseq').value;
	console.log(idx1);
	console.log(idx2);
	if(idx1 === idx2){
		alert("글쓴이 동일")
		location.href ="deleteFreeBoard.do?freeseq="+freeseq;
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
        url:'updateCommentJson.do',
        dataType:'json', //JSON.pase
        data:{"coseq":coseq, "content":content},
        success: function(data){
        	console.log("성공");
        	
        $.ajax({
        type: 'POST',
        url:'getCommentJson.do',
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
	const upbtn = document.querySelector('#updateGetFree');
	const debtn = document.querySelector('#deleteGetFree');
    const btn = document.querySelector('#updateCommnet');
    const btnCancel = document.querySelector('#updateCommnetCancel');

    upbtn.onclick = function () {
    	updateGetFree();
    }
	debtn.onclick = function () {
    	deleteGetFree();
    }
	btn.onclick = function () {
    	updateCommnet();
    }
    btnCancel.onclick = function () {
    	updateCommnetCancel();
    }
})  
