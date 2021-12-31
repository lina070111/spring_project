<%@page import="java.util.List"%>
<%@page import="com.spring.project.vo.CommentVO"%>
<%@page import="com.spring.project.vo.FreeBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getFreeBoard.jsp</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/getfreeboard.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="js/commentUpdate.js" ></script>
</head>
<body>
<%@ include file="header.jsp" %>
<%FreeBoardVO vo= (FreeBoardVO)request.getAttribute("getFreeBoard"); %>
<%@ include file="freeHeader.jsp" %>
<div id="fwarp">
<form action="updateFreeBoard.jsp" method="post" name="updateFreeBoard">
<input type="hidden" id="idx1" value="<%=session.getAttribute("userId") %>">
<input type="hidden" id="idx2" value="<%=vo.getId()%>">
<input type="hidden" id="freeseq" value="<%=vo.getFreeseq()%>">
<table>
<tr><th><%=vo.getTitle() %></th></tr>
<tr><td class="writer"><%=vo.getWriter() %> | <%=vo.getRegdata() %> | 조회수 : <%=vo.getCnt() %></td></tr>
<tr><td><%=vo.getContent() %></td></tr>
</table>
<div id="mid">
<button class="btn" type="button" onclick="location.href='freeboard.do';">목록</button>
<button class="btn" type="button" id="updateGetFree">수정</button>
<button class="dBtn" type="button" id="deleteGetFree" >삭제</button>
</div>
</form>
<form action="insertComment.do" method="post">
<input type="hidden" name="freeseq" value="<%=vo.getFreeseq()%>">
<table class="commentTable">
<tr><td>댓글 | 작성자 : <input type="text" name="writer" ></td></tr>
<tr><td><textarea name="content" rows="3" cols="50" placeholder="댓글을 입력해주세요"></textarea></td>
<td><input class="btn" type="submit" name="insert" value="등록"></td></tr>
</table>
</form >
<%List<CommentVO> list = (List<CommentVO>)request.getAttribute("getCommentList");
for(CommentVO cvo: list){%>
<table class="commentTable">
<tr><td><%=cvo.getWriter() %> | <%=cvo.getRegdata() %> |  <a href="#" id="upComment" onclick="UpComment();return false;" 
>수정</a> | <a href="deleteComment.do?coseq=<%=cvo.getCoseq()%>&freeseq=<%=cvo.getFreeseq()%>">삭제</a></td></tr>
<tr><td id="insertCommnetContent"><%=cvo.getContent() %></td></tr>
</table>
<div style="display:none;" id="newUpComment" >
<form  method="post" id="updateCommentForm">
<input type="hidden" name="coseq" id="coseq" value="<%=cvo.getCoseq()%>">
<label>작성자 : </label><span>  <%=cvo.getWriter() %> </span><br>
<textarea name="content" id="content" rows="3" cols="50" placeholder="<%=cvo.getContent()%>"></textarea>
<button type="button" id="updateCommnet">수정</button> 
<button type="button" id="updateCommnetCancel">취소</button>
</form></div>
<%} %>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>