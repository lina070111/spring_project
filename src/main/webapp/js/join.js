/**
 * 
 */
 const check = function() {
        	console.log('check');
            const form = document.joinForm; //name으로 바로 접근가능
            const id = form.id;
            const password = form.password;
            const password2 = form.password2;
            const name = form.name;
            const phone = form.phone;
            if(id.value ===''){
                alert('ID를 입력하세요');
                id.focus();
                return;
            }
            if(id.value.length < 3 ){
                alert('3자이상 넣으세요');
                id.focus();
                return;
            }
            if(password.value.length  ===0){
                alert('PW를 입력하세요');
                password.focus();
                return;
            }
            if(password2.value.length  ===0){
                alert('PW확인을 입력하세요');
                password2.focus();
                return;
            }
            if(password.value != password2.value){
                alert('비밀번호와 비밀번호 확인이 다립니다.');
                password2.focus();
                return;
            }
            if(name.value.length  ===0){
                alert('name을 입력하세요');
                name.focus();
                return;
            }
            if(phone.value.length  ===0){
                alert('phone를 입력하세요');
                phone.focus();
                return;
            }else{
            	var regex = /^01\d\d{3,4}\d{4}$/;
                var result = regex.exec(phone.value);
               if(result != null){
            	   
               }else{
            	   alert('정확한 번호를 입력해주세요');
            	   phone.focus();
                   return; 
               }
            }
            joinForm.submit();
        }
        
        const idck = function() {
        	$('#id').change(function () {
        		$("#area").text("중복검사해주세요")
                $("#area").css("color","red")
                $("#id").focus();
                $("#btn").attr("disabled", "disabled");
        	    })
        	var id =  $("#id").val();  
        	var specialCheck = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
        	if(id.trim().trim().length === 0){
        		alert("아이디를 입력해주세요.");
        	}else if(id.search(/\s/) != -1){
        		alert("아이디에는 공백이 들어갈 수 없습니다.");	
        	}else if(specialCheck.test(id)){
        		alert("id는 특수문자를 포함 할 수 없습니다.");
        	}else{	
        	$.ajax({
                type: 'POST',
                url:'idcheck.do',
                dataType:'json', //JSON.pase
                data:{"id":id},
                success: function(data){
					if(data>0){
                		//사용할수 없는 아이디
                		alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                        //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
                        $("#area").text("사용중인 아이디 입니다.")
                        $("#area").css("color","red")
                        $("#id").focus();
                        $("#btn").attr("disabled", "disabled");
                         $("#btn").css("color","#c0c0c0");
                	}else if(data===0){                	
                		console.dir(data);
                		//사용할수 있는 아이디
                		alert("사용할수 있는 아이디 입니다.");
                        //아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
                        $("#area").text("사용할수 있는 아이디 입니다.")
                        $("#area").css("color","blue")
                        $("#id").focus();
                        $("#btn").removeAttr("disabled");
                        $("#btn").css("color","#fff");
                	}
                    console.log('data'+data);
                    
                },
                error: function(request, status,error){
                    console.log(status,error);
                }
            });
        }}
        
     
        $(document).ready(function () {
            const btn = document.querySelector('#btn');
            const idcheck = document.querySelector('#idcheck');
            console.log(btn);
            btn.onclick = function () {
                check();
            }
            idcheck.onclick = function () {            	
            	console.log('idcheck');
            	idck();
            }
        })   