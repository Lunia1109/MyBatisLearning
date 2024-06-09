<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<a href="${path }/emp/empall.do">전체사원조회</a>
	</h3>
	<form action="${path }/dept/deptbyid.do">
		<select name="deptId">
			<option value="D9">총무부</option>
			<option value="D1">인사관리부</option>
			<option value="D2">회계관리부</option>
			<option value="D3">마케팅부</option>
			<option value="D4">국내영업부</option>
			<option value="D5">해외영업1부</option>
			<option value="D6">해외영업2부</option>
			<option value="D7">해외영업3부</option>
			<option value="D8">기술지원부</option>
		</select>
		<input type="submit" value="조회">
	</form>
	
	<h2>다른 DB에 접속하기</h2>
	<h3>
		<a href="${path }/member/memberAll.do">전체 회원 조회</a>
	</h3>
	<h3>
		<a href="${path }/board/boardAll.do">게시글 조회</a>
	</h3>
	<!--  
		1. web 계정에 접속해서 전체 member 조회하기
		2. web 계정에서 전체 게시글 + comment 까지 조회하기
	-->
	
</body>
</html>