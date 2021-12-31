<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/join.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div id="fwarp">
<p>Login</>
<form action="login.do" method="post">
<table border="1">
<tr><th class="loginth">ID</th><td><input type="text" name="id"></td></tr>
<tr><th class="loginth">PW</th><td><input type="text" name="password"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="LOGIN"></td></tr>
</table>
</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>