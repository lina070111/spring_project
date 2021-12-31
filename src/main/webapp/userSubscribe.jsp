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
<script src="js/userSubscribe.js"></script>
</head>
</head>
<body>
<%@ include file="header.jsp" %>
<% 
String uid =(String)request.getParameter("id");
%>
<div id="fwarp">
<p>구독하기</p>

<form action="insertSubscribe.do" method="post" name="userModifyForm">
<input type="hidden" name="id" id="idx" value="<%=uid %>">
<input type="hidden" name="point" id="hiddenPoint" value="" >
<input type="hidden" name="start_date" id="hiddenStart_date" value="" >
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
<label>구독 시작일</label>
<input type="date" id="start_date" onchange="changePeriod()" value="" min="">
</div>
<div>
<label>구독 종료일</label>
<input type="text" name="end_date"  id="end_date" readonly="readonly" value="">
</div>
<div>
<label>구독기간</label>
<select name="period" id="period" onchange="changePeriod()">
	<option value="1" selected="selected">1개월(5000원)</option>
	<option value="3">3개월(10%할인)</option>
	<option value="6">6개월(20%할인)</option>
	<option value="12">12개월(50%할인)</option>
</select>
</div>
<div>

<label>결제금액</label>
<input type="text" name="payment"  id="payment" readonly="readonly" value="5000">
</div>
<div>
<label>결제일</label>
<c:set var="today" value="<%=new java.util.Date()%>" />
<!-- 현재날짜 -->
<c:set var="date"><fmt:formatDate value="${today}" pattern="yyyy-MM-dd" /></c:set>
<input type="text" name="payment_date"  id="payment_date" readonly="readonly" value="<c:out value="${date}" />">
</div>
<button type="button" id="userModifybtn"  >구독하기</button>
<button type="button" id="userPoint"  >포인트 충전</button>
<button class="freebordlistbtn" type="button" onclick="location.href='index.jsp';">취소</button>
</div>
</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>