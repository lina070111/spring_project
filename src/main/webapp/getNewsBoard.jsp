<%@page import="java.util.List"%>
<%@page import="com.spring.project.vo.CommentNewsVO"%>
<%@page import="com.spring.project.vo.NewsBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getFreeBoard.jsp</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/getnewsboard.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="js/commentNewsUpdate.js" ></script>
</head>
<body>
<%@ include file="header.jsp" %>

<div id="warp">
<%NewsBoardVO vo= (NewsBoardVO)request.getAttribute("getNewsBoard"); %>
<form action="updateNewsBoard.jsp" method="post" name="updateNewsBoard">
<input type="hidden" id="idx1" value="<%=session.getAttribute("userId") %>">
<input type="hidden" id="idx2" value="<%=vo.getId()%>">
<input type="hidden" id="newsseq" value="<%=vo.getNewsseq()%>">
<table id="newsTable">
<tr><th id="newsTitle"><%=vo.getTitle() %></th></tr>
<tr><td id="writer"><%=vo.getWriter() %> | <%=vo.getRegdata() %> | 조회수 : <%=vo.getCnt() %></td></tr>
<tr><td id="newsImg">
	<%if(vo.getFilename() != null){ %>
	<img src="images/<%=vo.getFilename() %>" width="350px" >
	<%} %>		
</td></tr>
<tr><td id="newsContent"><%=vo.getContent() %></td></tr>
</table>
<div id="mid">
<button class="btn" type="button" onclick="location.href='newsboard.do';">목록</button>
<button class="btn" type="button" id="updateGetNews">수정</button>
<button class="dBtn" type="button" id="deleteGetNews" >삭제</button>
</div>
</form>


<form action="insertCommentNews.do" method="post">
<input type="hidden" name="Newsseq" value="<%=vo.getNewsseq()%>">
<table class="commentTable">
<tr><td>댓글 | 작성자 : <input type="text" name="writer" ></td></tr>
<tr><td><textarea name="content" rows="3" cols="50" placeholder="댓글을 입력해주세요"></textarea></td>
<td><input class="btn" type="submit" name="insert" value="등록"></td></tr>
</table>
</form >
<%List<CommentNewsVO> list = (List<CommentNewsVO>)request.getAttribute("getCommentListNews");
for(CommentNewsVO cvo: list){%>
<table class="commentTable">
<tr><td><%=cvo.getWriter() %> | <%=cvo.getRegdata() %> |  <a href="#" id="upComment" onclick="UpComment();return false;" 
>수정</a> | <a href="deleteCommentNews.do?coseq=<%=cvo.getCoseq()%>&newsseq=<%=cvo.getNewsseq()%>">삭제</a></td></tr>
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