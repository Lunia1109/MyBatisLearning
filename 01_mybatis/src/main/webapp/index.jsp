<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis 기본 활용</title>
</head>
<body>
	<h2>mybatis 접속하기</h2>
	<h3>
		<a href="${path}/mybatistest.do">접속 테스트</a>
	</h3>
	
	<h3>
		<a href="${path }/insertstudent.do">학생 등록</a>
	</h3>
	
	<form action="${path }/insertstudentbyname.do" method="post">
		<input type='text' name='name'>
		<input type='submit' value='저장'>
	</form>

	<form action="${path }/insertstudentbymap.do" method="post">
		<input type='text' name='name'>
		<input type='text' name='studentTel'>
		<input type='text' name='studentEmail'>	
		<input type='text' name='studentAddr'>
		<input type='submit' value='저장'>
	</form>
	
	<h3>회원정보 수정</h3>
	<form action="${path }/updatestudentbydto.do" method="post">
		<input type='text' name='studentNo' placeholder='학생번호'>
		<input type='text' name='name' placeholder='학생이름'>
		<input type='text' name='studentTel' placeholder='학생전번'>
		<input type='text' name='studentEmail' placeholder='학생이멜'>	
		<input type='text' name='studentAddr' placeholder='학생주소'>
		<input type='submit' value='수정'>
	</form>
	
	
	<h3>회원정보 삭제</h3>
	<form action="${path }/deletestudentbydto.do" method="post">
		<input type='text' name='studentNo' placeholder='학생번호'>
		<input type='text' name='name' placeholder='학생이름'>
		<input type='text' name='studentTel' placeholder='학생전번'>
		<input type='text' name='studentEmail' placeholder='학생이멜'>	
		<input type='text' name='studentAddr' placeholder='학생주소'>
		<input type='submit' value='삭제'>
	</form>
	
	
	<h3>DB에 저장된 데이터 조회하기</h3>
	<p>SELECT문을 실행시키기 → ResultSet을 가져옴 → 자동으로 Dto로 Mapping</p>
	
	<h3>학생 수 조회하기</h3>
	<h4>
		<a href="${path }/student/studentCount.do">전체 학생수</a>
	</h4>
	
	<h3>학생 조회하기</h3>
	<h4>
		<a href="${path }/student/studentbyno?no=1">1번 학생조회</a>
	</h4>
	
	<h3>학생번호 입력받아 조회하기</h3>
	<form action="${path }/student/studentbyno" method="post">
		<input type="text" name="no" placeholder="학번입력">
		<input type='submit' value='조회'>
	</form>
	
	
</body>
</html>