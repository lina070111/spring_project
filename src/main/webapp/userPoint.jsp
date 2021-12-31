<%@page import="java.util.Date"%>
<%@page import="com.spring.project.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>userModify.jsp</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/join.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="js/userPoint.js"></script>
</head>
</head>
<body>
<%@ include file="header.jsp" %>
<% 
String uid =(String)request.getParameter("id");
%>
<div id="fwarp">
<p>포인트 충전</p>

<form action="updateUserPoint.do" method="post" name="updateUserPoint">
<input type="hidden" name="id" id="idx" value="<%=uid %>">
<input type="hidden" name="point" id="point_charge" value="">
<div>
<label>아이디</label>
<span id="id"><%=uid %></span>
</div>
<div>
<label>보유포인트</label>
<span id="point"></span>
</div>
<div>
<div>
<label>현재 구독중인 기간</label>
<span id="period_c"></span>
</div>
<div>
<label>충전할 포인트</label>
(최소 5,000, 최대 50,000) <input type="number" id="charge" value="5000" min="5000" max="50000" step="1000"  >
</div>
<button type="button" id="userPointbtn"  >포인트 충전</button>
<button class="freebordlistbtn" type="button" onclick="location.href='index.jsp';">취소</button>
</div>
</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>