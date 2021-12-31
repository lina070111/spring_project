<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/join.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="js/join.js"></script>
</head>
</head>
<body>
<%@ include file="header.jsp" %>
<div id="fwarp">
<p>회원가입</p>
<form action="join.do" method="post" name="joinForm">
<div>
<label>아이디</label>
<input type="text" name="id" id="id"><button type="button" id="idcheck" >중복체크</button><br>
<span id="area"></span>
</div>
<div>
<label>패스워드</label>
<input type="text" name="password" >
</div>
<div>
<label>패스워드확인</label>
<input type="text" name="password2">
</div>
<div>
<label>이름</label>
<input type="text" name="name">
</div>
<div>
<label>전화번호</label>
<input type="text" name="phone">
</div>
<div>
<button type="button" id="btn"  value="join" disabled="disabled">회원가입</button>
<button class="freebordlistbtn" type="button" onclick="location.href='index.jsp';">취소</button>
</div>
</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>