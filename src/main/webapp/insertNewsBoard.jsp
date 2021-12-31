<%@page import="com.spring.project.vo.FreeBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getFreeBoard.jsp</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/insertfreeboard.css">
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="newsHeader.jsp" %>
<div id="fwarp">
<form action="insertNewsBoard.do" method="post" enctype="multipart/form-data" >
<input type="hidden" name="writer" value="<%=session.getAttribute("userName") %>">
<input type="hidden" name="id" value="<%=session.getAttribute("userId") %>">
<table>
<tr><th>제목*</th><td><input type="text" name="title"></td></tr>
<tr><th>작성자*</th><td><%=session.getAttribute("userName") %></td></tr>
<tr><th class="content">내용*</th><td><textarea rows="8" cols="80" name="content" placeholder="내용을 입력해주세요"></textarea></td></tr>
<tr><th>Upload</th><td><input type="file" name="uploadFile"></td></tr>
</table>
<div>
<input class="btn" type="submit" value="확인">
<button class="btn" type="button" onclick="location.href='newsboard.do';">취소</button>
</div>

</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>