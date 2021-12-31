<%@page import="com.spring.project.vo.FreeBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>freeboard.jsp</title>
<!-- 부트스트랩 추가 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- css추가 -->
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/freeboard.css">
<!-- 자바스크립트 추가 -->
<script src="js/freeboard.js"></script>
</head>
<body>
	<!-- 헤더부분 추가 -->
	<%@ include file="header.jsp"%>
	<%@ include file="freeHeader.jsp"%>
	<!-- 컨테이너부분 시작 -->
	<div id="fwarp">
		<!-- 게시판 검색 영역 시작 -->
		<form action="freeboard.do">
			<div class="input-group">
				<select class="select" name="searchSelect">
					<option value="TITLE">제목</option>
					<option value="WRITER">작성자</option>
				</select>
				<input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" name="searchText" /> 
				<input class="btn btn-outline-primary" type="submit" value="검색">
			</div>
		</form>
		<!-- 게시판 검색 영역 끝 -->
		<!-- 게시글 리스트 시작 -->
		<table>
			<tr>
				<th>순번</th>
				<th class="title">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!-- 순번 셋팅 -->
			<c:set var="num" value="${pagination.listCnt - ((pagination.page-1) * 10) }" />
			<c:if test="${freeboardlist.size()>0 }">
			<c:forEach var="i" begin="0" end="${freeboardlist.size()-1 }">
			<tr>
				<td>${num}</td>
				<td>
					<a href="getFreeBoard.do?freeseq=${freeboardlist.get(i).getFreeseq()}">${freeboardlist.get(i).getTitle()}</a>
				</td>
				<td>${freeboardlist.get(i).getWriter()}</td>
				<td>${freeboardlist.get(i).getRegdata()}</td>
				<td>${freeboardlist.get(i).getCnt()}</td>
			</tr>
			<c:set var="num" value="${num-1 }"></c:set>
			</c:forEach>
			</c:if>
		</table>
		<!-- 게시글 리스트 출력 끝 -->
		<!-- 버튼 -->
		<div>
			<a class="insertbtn" href="loginCheck.do?check=freeboard">글쓰기</a>
			<button class="freebordlistbtn" type="button" onclick="location.href='freeboard.do';">목록</button>
		</div>
		<!-- pagination{s} 페이징-->
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
				</c:if>
				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
					<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/>"><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
				</c:forEach>
				<c:if test="${pagination.next}">
					<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a></li>
				</c:if>
			</ul>
		</nav>
		<!-- pagination{e} -->
	</div>
	<!-- 컨테이너부분 끝 -->
	<%@ include file="footer.jsp"%>
</body>
</html>