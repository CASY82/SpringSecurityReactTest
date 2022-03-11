<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">

function json_convert(){
	
	let username = document.getElementById('username');
	let password = document.getElementById('password');
	
	$.ajax({
		type: "post",
		url: "/authenticate/token", //데이터 전송받는 특정 주소
		data: JSON.stringify({
			'username' : username.value,
			'password' : password.value
		}),
		dataType: "json",
		contentType: "application/json",
		success: function(data) {
			alert("성공 : " + data.token);
			localStorage.setItem('token', data.token);
		},
		error: function(request, error){
			alert("안됨 : ");
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
	
}

function test(){
	var token = localStorage.getItem("token");
	    $.ajax({
	        type: "GET",
	        url: "/hello",
	        beforeSend: function (xhr) {
	            xhr.setRequestHeader("Content-type","application/json");
	            xhr.setRequestHeader("Authorization","Bearer " + token);
	        },
	        success: function (res) {
	            alert("해당 url로 가나연?");
	        }
	    });
	
}


</script>

<body>
	<div>
        <form name="f" id="f">               
            <fieldset>
                <legend>Please Login</legend>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>        
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>    
                <div class="form-actions">
        			<button type="button" class="btn" onclick="json_convert();">Log in</button>            
                </div>
            </fieldset>
        </form>
    </div>
    
    <button type="button" class="btn" onclick="test();">토큰 인증 방식 성공 테스트</button>



</body>
</html>