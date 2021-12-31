<%@page import="com.spring.project.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>userModify.jsp</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/join.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script src="js/userModify.js"></script>
</head>
</head>
<body>
<%@ include file="header.jsp" %>
<% 
String uid =(String)request.getParameter("id");
%>
<div id="fwarp">
<p>회원정보수정</p>

<form action="updateUser.do" method="post" name="userModifyForm">
<input type="hidden" id="idx" value="<%=uid%>">
<div>
<label>아이디</label>
<span id="id"><%=uid%></span>
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
<input type="text" name="name" value="${getUser.name }" id="name">
</div>
<div>
<label>전화번호</label>
<input type="text" name="phone" value="${getUser.phone }" id="phone">
</div>
<div>
<label>보유포인트</label>
<span id="point"></span>
</div>
<div>
<label>구독기간</label>
<span id="period"></span>
</div>
<div>
<button type="button" id="userModifybtn"  >회원정보 수정</button>
<button type="button" id="userDeletebtn" >회원 탈퇴</button>
<button class="freebordlistbtn" type="button" onclick="location.href='index.jsp';">취소</button>
</div>
</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>