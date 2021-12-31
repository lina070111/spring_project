<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<style>
#headertop{margin: 0 auto; }
.Indexheder{height:70px; background-color: #3f63bf; line-height: 70px; color: #fff; text-align: center;}
.menuheader{width: 700px;margin: 0 auto; clear: both; }
.nav_ul_a{list-style: none; list-style: none; margin-top: 3px;}
.nav_li_a{width: 120px; float: left; height: 50px; line-height: 50px; text-align: center; }
.nav_li_a a {display: block; text-decoration: none;}
.nav_li_a a:hover {border-radius:10px 10px 0 0; border-top: 1px solid #c0c0c0;border-right: 1px solid #c0c0c0;border-left: 1px solid #c0c0c0;	}
.userInfos{padding-top: 15px; color: #fff; float: right; padding-right: 20px; font-size: 12px;}
.userInfos a{color: #fff;} 
.userInfos a:hover{color: #d2dfff; }
.headerTitle{color: #fff;} 
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
const ppt = function() {
	if (!confirm("프로젝트 ppt를 다운받으시겠습니까?")) {
        // 취소(아니오) 버튼 클릭 시 이벤트
        return;
    } else {
        location.href ="/file/suyoung_project.pptx";
    	 return;
    }
}
</script>
<div id="headertop">

<div class="Indexheder">
빅데이터 & 자바 중간 프로젝트 : 김수영
<% 
String userId = (String)session.getAttribute("userId"); 
String userName = (String)session.getAttribute("userName"); 
%>
<c:set var="userId" value="${userId }"></c:set>
<c:choose>
<c:when test="${empty sessionScope.userId }">
<div class="userInfos">
<a href="login.jsp">로그인</a> | <a href="join.jsp">회원가입</a>
</div>
</c:when>
<c:otherwise>
<div class="userInfos">
아이디 : ${userId } (이름: ${userName } )
 | <a href="logout.do">로그아웃</a> | <a href="userModify.jsp?id=${userId }">내정보</a>
</div>
</c:otherwise>
</c:choose>
</div>
<div role="tabpanel" class="menuheader">

<ul class="nav_ul_a">
  <li role="presentation" class="nav_li_a"><a href="index.jsp">Home</a></li>
  <li role="presentation" class="nav_li_a"><a href="newsboard.do">News</a></li>
  <li role="presentation" class="nav_li_a"><a href="freeboard.do">FreeBoard</a></li>
  <li role="presentation" class="nav_li_a"><a href="loginCheck.do?check=subscribe">구독하기</a></li>
  <li role="presentation" class="nav_li_a"><a href="#" onclick="ppt()">프로젝트 PPT</a></li>
</ul>

</div>
</div> 
