/**
 * 
 */
const userInfo = function() {
	console.log("userInfo");
	const idx =document.querySelector('#idx').value;
	$.ajax({
        type: 'POST',
        url:'userInfo.do',
		data:{"id": idx},
        dataType:'json', //JSON.pase
        success: function(data){
        	console.log("성공일까요");
        	console.log(data);
			const name =document.querySelector('#name');
			const phone =document.querySelector('#phone');
			name.value = data.name;
			phone.value = data.phone;
			
        },
        error: function(request, status,error){
        	console.log("실패"); 
            console.log(status,error);
        }
    });
}
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
			$('#period').text(data.start_date +" ~ " +data.end_date)
        	  
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
console.dir(idx);
	$.ajax({
        type: 'POST',
        url:'getUserPoint.do',
		data:{"id": idx},
        dataType:'json', //JSON.pase
        success: function(data){
        	console.log("성공이냥?");
			console.log(data); 
			$('#point').text(data)
        	  
        },
        error: function(request, status,error){
        	console.log("실패"); 
            console.log(status,error);
        }
    });
}
 const check = function() {
 			console.log("회원정보수정");
 			const form = document.userModifyForm; //name으로 바로 접근가능
            const id = $('#id').text();
            const password = form.password;
            const password2 = form.password2;
            const name = form.name;
            const phone = form.phone;
            
 			if(password.value.length  ===0){
                alert('PW를 입력하세요');
                password.focus();
                return false;
            }
            if(password2.value.length  ===0){
                alert('PW확인을 입력하세요');
                password2.focus();
                return false;
            }
            if(password.value != password2.value){
                alert('비밀번호와 비밀번호 확인이 다립니다.');
                password2.focus();
                return false;
            }
            if(name.value.length  ===0){
                alert('name을 입력하세요');
                name.focus();
                return false;
            }

			var reg = /^[0-9]+/g;
            if(!reg.test(phone.value)){
                alert('phone은 숫자만 입력할수 있습니다.');
                phone.focus();
                return false;
            }

			document.userModifyForm.submit();
 }


  const userDelete = function() { 
if (confirm("정말 탈퇴하시겠습니까??") == true){    //확인
    console.log("회원탈퇴");
var id = $('#id').text();
console.log(id);
    location.href="deleteUser.do?id="+id;
}else{   //취소
    return;
}
 }    
     
        $(document).ready(function () {
			userInfo();
			subpoint();
			subperiod();
            const Mbtn = document.querySelector('#userModifybtn');
            const Dbtn = document.querySelector('#userDeletebtn');
            console.log("성공");
            console.log(Mbtn);
            console.log(Dbtn);
            Mbtn.onclick = function () {
                check();	

            }
            Dbtn.onclick = function () {
                userDelete();
            }
        })   