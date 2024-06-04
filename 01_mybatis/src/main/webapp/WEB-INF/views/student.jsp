<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 정보</h2>
	<div>
		<h3>등록된 학생 수 : <c:out value="${count }"/> </h3>
	</div>
	
	<div>
		<table>
			<tr>
				<th>학생 번호</th>
				<th>학생 이름</th>
				<th>학생 전번</th>
				<th>학생 이멜</th>
				<th>학생 주소</th>
				<th>등록 날짜</th>
			</tr>
			<tbody>
			<c:if test="${student!=null }">
				<tr>
					<td><c:out value="${student.studentNo }"/></td>
					<td><c:out value="${student.studentName }"/></td>
					<td><c:out value="${student.studentTel }"/></td>
					<td><c:out value="${student.studentEmail }"/></td>
					<td><c:out value="${student.studentAddr }"/></td>
					<td><c:out value="${student.reg_date }"/></td>
				</tr>
			</c:if>
			<c:if test="${student==null }">
				<tr>
					<td colspan="6">조회된 학생이 없습니다.</td>
				</tr>
			</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>