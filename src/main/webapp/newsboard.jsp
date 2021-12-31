<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>freeboard.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/newsboard.css">
<script src="js/newsboard.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="newsHeader.jsp" %>
<div id="nwarp">
<div>
<form action="newsboard.do">
<div class="input-group">
<select class="select" name="searchSelect">
	<option value="TITLE">제목</option>
	<option value="WRITER">작성자</option>
</select>
  <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
  aria-describedby="search-addon" name="searchText" />
<input class="btn btn-outline-primary" type="submit" value="검색">
</div>
</form>
</div>
<div >
<c:set var="num" value="${pagination.listCnt - ((pagination.page-1) * 5) }"/>
<c:if test="${newsboardlist.size()>0 }">
<c:forEach var="i" begin="0" end="${newsboardlist.size()-1 }">
<div style="padding-top: 5px;">
<div  style="float: left; clear: both; height: 150px; "><a href="getNewsBoard.do?newsseq=${newsboardlist.get(i).getNewsseq() }"><img src="images/${newsboardlist.get(i).getFilename() }" width="230px;" height="150px;"></a></div>
<table class="newsTable">
<tr>
<td class="newsTitle" >
<a href="getNewsBoard.do?newsseq=${newsboardlist.get(i).getNewsseq() }">
<c:choose>
	<c:when test="${fn:length(newsboardlist.get(i).getTitle()) gt 30}">
		<c:out value="${fn:substring(newsboardlist.get(i).getTitle(),0,28)}" />...
	</c:when>
	<c:otherwise>
		<c:out value="${newsboardlist.get(i).getTitle()}" />
	</c:otherwise>
</c:choose>
</a>
</td>
<td>${newsboardlist.get(i).getRegdata() }</td>
</tr>
<tr><td colspan="2" class="newsContent" >
<a href="getNewsBoard.do?newsseq=${newsboardlist.get(i).getNewsseq() }" style="color: #636363;">
<c:choose>
	<c:when test="${fn:length(newsboardlist.get(i).getContent()) gt 100}">
		<c:out value="${fn:substring(newsboardlist.get(i).getContent(),0,98)}" />...
	</c:when>
	<c:otherwise>
		<c:out value="${newsboardlist.get(i).getContent()}" />
	</c:otherwise>
</c:choose>
</a>
</td></tr>
<c:set var="num" value="${num-1 }"></c:set>
</table>
</div>
</c:forEach>
</c:if>
</div>
<div id="newspage">
<!-- pagination{s} -->
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${paginationNews.prev}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${paginationNews.page}', '${paginationNews.range}', '${paginationNews.rangeSize}')">Previous</a></li>
			</c:if>
			<c:forEach begin="${paginationNews.startPage}" end="${paginationNews.endPage}" var="idx">
				<li class="page-item <c:out value="${paginationNews.page == idx ? 'active' : ''}"/>">
				<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${paginationNews.range}', '${paginationNews.rangeSize}')"> ${idx} </a></li>
			</c:forEach>
			<c:if test="${paginationNews.next}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${paginationNews.range}', '${paginationNews.range}', '${paginationNews.rangeSize}')" >Next</a></li>
			</c:if>
		</ul>
	</nav>
<!-- pagination{e} -->
</div>

<div id="cnewsfoot">
<button class="btn btn-primary btn-sm" onclick="location.href='loginCheck.do?check=newsboard'">글쓰기</button>
<button class="btn btn-primary btn-sm" type="button" onclick="location.href='newsboard.do'">목록</button>

</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>