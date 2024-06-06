<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<c:set var="path" value="${pageContext.request.contextPath} "/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty employees }">
		<table>
			<tr>
				<th>사원ID</th>
				<th>이름</th>
				<th>번호</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>부서코드</th>
				<th>직급코드</th>
				<th>급여수듄</th>
				<th>급여</th>
				<th>보너스</th>
				<th>관리자ID</th>
				<th>취직일</th>
				<th>퇴사일</th>
				<th>퇴사여부</th>
			</tr>
			<c:forEach var="e" items="${employees }">
				<tr>
					<td>${e.EMP_ID}</td>
					<td>${e.EMP_NAME}</td>
					<td>${e.EMP_NO}</td>
					<td>${e.EMAIL}</td>
					<td>${e.PHONE}</td>
					<td>${e.DEPT_CODE}</td>
					<td>${e.JOB_CODE}</td>
					<td>${e.SAL_LEVEL}</td>
					<td><fmt:formatNumber type="currency" value="${e.SALARY }"/></td>
					<td><fmt:formatNumber type="percent" value="${e.BONUS }"/></td>
					<td>${e.MANAGER_ID}</td>
					<td><fmt:formatDate pattern="yy/MM/dd, E" value="${e.HIRE_DATE }"/></td>
					<td><fmt:formatDate pattern="yy/MM/dd, E" value="${e.ENT_DATE }"/></td>
					<td>${e.ENT_YN}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>